package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.service.ArtistService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/artists")
@Slf4j
public class ArtistController {

	@Autowired
	private ArtistService artistService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Role> roles = Arrays.asList(Role.values());
		Artist artistsFiltered = new Artist();
		Iterable<Artist> artists = artistService.list();
		
		model.addAttribute("artists", artists);
		model.addAttribute("artistsPro", artistService.listProArtist());
		model.addAttribute("artistsNoPro", artistService.listNoProArtist());
		model.addAttribute("roles", roles);
		model.addAttribute("artistsFiltered", artistsFiltered);
		
		log.info("Listing Artists..." + artists.toString());
		return "artists/listArtist";
	}
	
	@PostMapping("/listFiltered")
	public String list(@ModelAttribute("artistsFiltered") Artist artistsFiltered,Model model) {
		List<Role> roles = Arrays.asList(Role.values());
		List<Artist> artists = artistService.list();
		
		model.addAttribute("artists", artists);
		model.addAttribute("artistsFiltered", artistsFiltered);

		List<Artist> artistasProFiltrados = artists.stream()
				.filter(a -> a.getPro()==true &&
							a.getName().contains(artistsFiltered.getName()) && 
							(!roles.contains(artistsFiltered.getRole()) || a.getRole().equals(artistsFiltered.getRole()))
				).collect(Collectors.toList());
		
		List<Artist> artistasNoProFiltrados = artists.stream()
				.filter(a -> a.getPro()==false &&
							a.getName().contains(artistsFiltered.getName()) && 
							(!roles.contains(artistsFiltered.getRole()) || a.getRole().equals(artistsFiltered.getRole()))
				).collect(Collectors.toList());
		
		
		model.addAttribute("artistsPro", artistasProFiltrados);
		model.addAttribute("artistsNoPro", artistasNoProFiltrados);
		model.addAttribute("roles", roles);
		
		log.info("Listando artists..." + artistsFiltered.toString());
		return "artists/listArtist";
	}
	
	@GetMapping(value = { "/show/{artistId}" })
	public String showArtist(@PathVariable("artistId") int artistId, Model model) {
		Artist artist = artistService.findArtistById(artistId);
		model.addAttribute("artistId", artistId);
		model.addAttribute("artist", artist);
		return "artists/showArtist";
	}


	@GetMapping("/create")
	public String initFormCreateArtist(Model model) {
		Artist artist = new Artist();
		model.addAttribute("artist", artist);
		return "artists/createOrUpdateArtistForm";
	}

	@PostMapping("/create")
	public String createArtist(@Validated Artist artist, BindingResult result) {
		try {
			artistService.createArtist(artist);
			log.info("Artist Created Successfully");
		} catch (Exception e) {
			log.error("Error Create Artist", e);
		}
		return "artist/listArtist";
	}

	@GetMapping("/update/{artistId}")
	public String initFormUpdateArtist(Model model, @PathVariable("artistId") Integer artistId) {
		Artist artist = artistService.findArtistById(artistId);
		model.addAttribute("artistId", artistId);
		model.addAttribute("artist", artist);
		return "artists/createOrUpdateArtistForm";
	}

	@PostMapping("/update/{artistId}")
	public String updateArtist(@PathVariable("artistId") Integer artistId, BindingResult result) {
		try {
			artistService.editArtist(artistId);
			log.info("Artist Updated Successfully");
		} catch (Exception e) {
			log.error("Error Updating Artist", e);
		}
		return "artist/listArtist";
	}

	@PostMapping("/delete/{artistId}")
	public String deleteArtist(@PathVariable("artistId") Integer artistId, BindingResult result) {
		try {
			artistService.deleteArtist(artistId);
			log.info("Artist Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Artist", e);
		}
		return "artist/listArtist";
	}

}
