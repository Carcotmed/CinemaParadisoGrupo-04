package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.cinema.cinemaparadiso.model.Skill;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.WriterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/writers")
@Slf4j
public class WriterController {

	@Autowired
	private WriterService writerService;

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Writer> writers = writerService.list();
		Writer writersFiltered = new Writer();
		model.addAttribute("writers", writers);
		model.addAttribute("writersFiltered",writersFiltered);
		return "/writers/listWriter";
	}
	
	@PostMapping("/list")
	public String list(@ModelAttribute("writersFiltered") Writer writersFiltered,Model model) {
		List<Writer> writers = writerService.list();
		
		model.addAttribute("writers", writers);
		
		
		List<Writer> writersFiltrados = writers.stream()
				.filter(w->w.getUser().getUsername().toLowerCase().contains(writersFiltered.getUser().getUsername().toLowerCase())
				).collect(Collectors.toList());
		
		model.addAttribute("writers",writersFiltrados);
		
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
		catch(Exception e) {
		}
		model.addAttribute("writerId", writerId);
		model.addAttribute("writer", writer);
		model.addAttribute("stories",stories);
		model.addAttribute("sameWriter",sameWriter);
		model.addAttribute("writerUsername", writer.getUser().getUsername());

		return "writers/showWriter";
	}
	@GetMapping("/create")
    public String initFormCreateWriter(Model model) {
		User user = new User();
        Writer writer = new Writer();
        List<Skill> skill = Arrays.asList(Skill.values());
        model.addAttribute("writer", writer);
        model.addAttribute("user",user);
        model.addAttribute("isNew", true);
        model.addAttribute("skill", skill);
        return "/writers/createOrUpdateWriterForm";

    }

    @PostMapping("/create")
    public String createWriter(Model model, @ModelAttribute("writer") @Valid Writer writer,
              BindingResult result) {
  
    	List<Skill> skill = Arrays.asList(Skill.values());
    	model.addAttribute("skill", skill);
          if(!result.hasErrors()) {
              writerService.createWriter(writer);
          }else {
              return "writers/createOrUpdateWriterForm";
          }
          return "index";
      }
    
    @GetMapping("/update/{writerId}")
	public String initFormUpdateWriter(Model model, @PathVariable("writerId") Integer writerId) {
		if(!writerService.isActualWriter(writerId)) {
			return "error/error-403";
		}
		Writer writer = writerService.findWriterById(writerId);
		List<Skill> skill = Arrays.asList(Skill.values());
		model.addAttribute("writerId", writerId);
		model.addAttribute("writer", writer);
		model.addAttribute("skill", skill);
		return "writers/updateWriter";
	}

	@PostMapping("/update/{writerId}")
	public String updateWriter(@ModelAttribute("writer") @Valid Writer writer,BindingResult result, Model model, @PathVariable("writerId") Integer writerId) {
		writer.setId(writerId);
		
		if(!writerService.isActualWriter(writerId)) {
			return "error/error-403";
		}
		List<Skill> skill = Arrays.asList(Skill.values());
		model.addAttribute("skill", skill);
		if(!result.hasErrors()) {
			writerService.editWriter(writer);
			return "redirect:/writers/show/{writerId}";
		} else {
			return "writers/updateWriter";
		}
 
  }
	

	@GetMapping("/delete/{writerId}")
	public String deleteWriter(@PathVariable("writerId") Integer writerId) {
		if(!writerService.isActualWriter(writerId)) {
			return "error/error-403";
		}
		try {
			writerService.deleteWriter(writerId);
			SecurityContextHolder.clearContext();
			log.info("Writer Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Writer", e);
		}
		return "redirect:/";
	}

}