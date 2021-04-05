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

import com.cinema.cinemaparadiso.model.Artist;

import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.Skill;
import com.cinema.cinemaparadiso.model.User;

import com.cinema.cinemaparadiso.model.Project;


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

	
	@PostMapping("/list")
	public String list(@ModelAttribute("artistsFiltered") Artist artistsFiltered,Model model) {
		List<Role> roles = Arrays.asList(Role.values());
		List<Artist> artists = artistService.list();
		
		model.addAttribute("artists", artists);
		model.addAttribute("artistsFiltered", artistsFiltered);

		List<Artist> artistasProFiltrados = artists.stream()
				.filter(a -> a.getPro()==true &&
							a.getName().toLowerCase().contains(artistsFiltered.getName().toLowerCase()) && 
							(!roles.contains(artistsFiltered.getRole()) || a.getRole().equals(artistsFiltered.getRole()))
				).collect(Collectors.toList());
		
		List<Artist> artistasNoProFiltrados = artists.stream()
				.filter(a -> a.getPro()==false &&
							a.getName().toLowerCase().contains(artistsFiltered.getName().toLowerCase()) && 
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
		//List<Project> projectHistory = artistService.projectHistory(artistId);
		model.addAttribute("artistUsername", artist.getUser().getUsername());
		model.addAttribute("artist", artist);
		//model.addAttribute("projectHistory",projectHistory);
		return "artists/showArtist";
	}


	@GetMapping(value = { "/myProjects" })
	public String myProjectsArtist(Model model) {
		Artist artist = artistService.getPrincipal();
		Integer artistId = artist.getId();
		List<Project> myProjects = artistService.findMyProjects(artistId);
		model.addAttribute("artistId", artistId);
		model.addAttribute("artist", artist);
		model.addAttribute("myProjects",myProjects);
		return "artists/myProjects";
	}
	

	@GetMapping("/create")
	public String initFormCreateArtist(Model model) {
		Artist artist = new Artist();
		User user = new User();
		List<Skill> skill = Arrays.asList(Skill.values());
		List<Role> role = Arrays.asList(Role.values());
    model.addAttribute("user",user);
		model.addAttribute("artist", artist);
		model.addAttribute("skill", skill);
		model.addAttribute("role", role);

		return "artists/createOrUpdateArtistForm";
	}

	@PostMapping("/create")
	public String createArtist(@Validated Artist artist, BindingResult result, Model model) {
		List<Skill> skill = Arrays.asList(Skill.values());
		List<Role> role = Arrays.asList(Role.values());

		model.addAttribute("role", role);
		model.addAttribute("skill", skill);
		try {
			artistService.createArtist(artist);
			log.info("Artist Created Successfully");
		} catch (Exception e) {
			log.info(artist.getUser().getUsername()+"/"+artist.getUser().getEmail()+"/"+artist.getUser().getPassword()+"/"+ artist.getUser().isEnabled());
			log.error("Error Create Artist", e);
		}
		return "index";
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

}
