package com.cinema.cinemaparadiso.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.UserService;
import com.cinema.cinemaparadiso.service.WriterService;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/writers")
@Slf4j
public class WriterController {

	@Autowired
	private WriterService writerService;

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Writer> writers = writerService.list();
		Writer writersFiltered = new Writer();
		model.addAttribute("writers", writers);
		model.addAttribute("writersDisabled", writerService.listDisabledWriter());
		model.addAttribute("writersFiltered",writersFiltered);
		return "/writers/listWriter";
	}
	
	@GetMapping("/desactivarWriter/{writerId}")
	public String desactivarWriter(@PathVariable("writerId") Integer writerId,Model model) {
           model.addAttribute("writerId",writerId);
		return "desactivar/desactivarWriter";
	}
	
	
	@PostMapping("/list")
	public String list(@ModelAttribute("writersFiltered") Writer writersFiltered,Model model) {
		List<Writer> writers = writerService.list();
		
		model.addAttribute("writers", writers);
		
		
		List<Writer> writersFiltrados = writers.stream()
				.filter(w->w.getUser().getUsername().toLowerCase().contains(writersFiltered.getUser().getUsername().toLowerCase())
				).collect(Collectors.toList());
		
		model.addAttribute("writers",writersFiltrados);
		model.addAttribute("writersDisabled", writerService.listDisabledWriter());
		
		return "/writers/listWriter";
	}
	
	@GetMapping(value = { "/show/{writerId}" })
	public String showWriter(@PathVariable("writerId") int writerId, Model model) {
		Writer writer = writerService.findWriterById(writerId);
		List<Story> stories = writerService.findMyStories(writerId);
		Boolean sameWriter = false;
		try {
			sameWriter = writerService.getPrincipal().getId().equals(writerId);
				}
		catch(Exception e) {}
		Boolean disabled = !writerService.findMyUser(writerId).isEnabled();
		
		model.addAttribute("writerId", writerId);
		model.addAttribute("writer", writer);
		model.addAttribute("stories",stories);
		model.addAttribute("sameWriter",sameWriter);
		model.addAttribute("writerUsername", writer.getUser().getUsername());
		model.addAttribute("userDisabled",disabled);
		model.addAttribute("isAdmin",userService.isAdmin());

		return "writers/showWriter";
	}
	@GetMapping("/create")
    public String initFormCreateWriter(Model model) {
		User user = new User();
        Writer writer = new Writer();
        model.addAttribute("writer", writer);
        model.addAttribute("user",user);
        model.addAttribute("isNew", true);
        return "/writers/createOrUpdateWriterForm";

    }

    @PostMapping("/create")
    public String createWriter(@RequestParam("file") MultipartFile file, Model model, @ModelAttribute("writer") @Valid Writer writer,
              BindingResult result) throws UserUniqueException{
  

          if(!result.hasErrors() && ((file.getSize()==0 && result.getFieldValue("photo").toString().length()!=0) || (file.getSize()!=0 && result.getFieldValue("photo").toString().length()==0 && file.getContentType().contains("image")))) {
			try{
				writer.setPhotoB(encodeFileToBase64Binary(file.getBytes()));
				this.writerService.createWriter(writer);
			}
			catch(UserUniqueException ex) {
				result.rejectValue("user.username", "unique", "Este usuario ya existe, pruebe con otro");
				return "writers/createOrUpdateWriterForm";
			} catch (IOException e) {
				this.writerService.createWriter(writer);
			}
			log.info("Writer Created Successfully");          
			}
          else {
              return "writers/createOrUpdateWriterForm";
          }
          return "redirect:/login";
      }
    
    @GetMapping("/update/{writerId}")
	public String initFormUpdateWriter(Model model, @PathVariable("writerId") Integer writerId) {
		if(!writerService.isActualWriter(writerId) && !userService.isAdmin()) {
			return "error/error-403";
		}
		Writer writer = writerService.findWriterById(writerId);
		model.addAttribute("writerId", writerId);
		model.addAttribute("writer", writer);
		return "writers/updateWriter";
	}

	@PostMapping("/update/{writerId}")
	public String updateWriter(@RequestParam("file") MultipartFile file, @ModelAttribute("writer") @Valid Writer writer,BindingResult result, Model model, @PathVariable("writerId") Integer writerId) {
		writer.setId(writerId);
		
		if(!writerService.isActualWriter(writerId) && !userService.isAdmin()) {
			return "error/error-403";
		}
		if(!result.hasErrors() && ((file.getSize()==0 && result.getFieldValue("photo").toString().length()!=0) || (file.getSize()!=0 && result.getFieldValue("photo").toString().length()==0 && file.getContentType().contains("image")))) {
			try {
				writer.setPhotoB(encodeFileToBase64Binary(file.getBytes()));
			} catch (IOException e) {
				return "artists/updateArtist";
			}
			writerService.editWriter(writer);
			return "redirect:/writers/show/{writerId}";
		} else {
			return "writers/updateWriter";
		}
 
  }
	

	@GetMapping("/delete/{writerId}")
	public String deleteWriter(@PathVariable("writerId") Integer writerId) {
		if(!writerService.isActualWriter(writerId) && !userService.isAdmin()) {
			return "error/error-403";
		}
		try {
			writerService.deleteWriter(writerId);
			if(userService.isAdmin())
				return "redirect:/writers/show/"+writerId;
			SecurityContextHolder.clearContext();
			log.info("Writer Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Writer", e);
		}
		return "redirect:/";
	}
	@GetMapping("/activate/{writerId}")
	public String activateWriter(@PathVariable("writerId") Integer writerId) {
		if(!userService.isAdmin()) {
			return "error/error-403";
		}
		try {
			writerService.activateWriter(writerId);
			if(!userService.isAdmin())
				SecurityContextHolder.clearContext();
			log.info("Writer Activated Successfully");
		} catch (Exception e) {
			log.error("Error Activating Writer", e);
		}
		return "redirect:/";
	}
	
	private static String encodeFileToBase64Binary(byte[] bytes){
        String encodedfile = null;
        encodedfile = new String(Base64.encodeBase64(bytes));

        return encodedfile;
    }

}