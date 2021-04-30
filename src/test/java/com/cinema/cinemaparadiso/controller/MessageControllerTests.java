package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.UserService;

@WebMvcTest(controllers = MessageController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class MessageControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private MessageService messageService;

	@MockBean
	private UserService userService;
	
	User user1 = new User("user1", "password1", "email1@gmail.com");
	User user2 = new User("user2", "password2", "email2@gmail.com");
	User user3 = new User("user3", "password3", "email3@gmail.com");

	Message message1 = new Message("Issue 1", "body 1", Date.from(Instant.now()), user1, user2);
	Message message2 = new Message("Issue 2", "body 2", Date.from(Instant.now()), user1, user2);
	
	Message message3 = new Message("Issue 3", "body 3", Date.from(Instant.now()), false, user1, user2, 1);
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
    public void listSendTest() throws Exception{
		BDDMockito.given(messageService.findByEmisorUsername("user1")).willReturn(Arrays.asList(message1, message2));
		
		mockMvc.perform(get("/messages/listSend"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("messages"))
		.andExpect(model().attributeExists("tipo"))

		.andExpect(model().attribute("messages", Arrays.asList(message1, message2)))
		.andExpect(model().attribute("tipo", "send"))

		.andExpect(view().name("messages/listMessage"));
		
    }

//	@WithMockUser(username = "user1", authorities = { "artist" })
//	@Test
//	public void checkTest() throws Exception{
//		BDDMockito.given(messageService.checkMessage("user1")).willReturn(true);
//
//		mockMvc.perform(get("/messages/check"))
//		.andExpect(status().is2xxSuccessful())
//
//		.andExpect(content().json("{'res':'true'}"));
//    	
//    }
    
	@WithMockUser(username = "user2", authorities = { "artist" })
	@Test
    @GetMapping("/listReceived")
    public void listReceivedTest() throws Exception{
		BDDMockito.given(messageService.findByReceptorUsername("user2")).willReturn(Arrays.asList(message1, message2));

		mockMvc.perform(get("/messages/listReceived"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("messages"))
		.andExpect(model().attributeExists("tipo"))

		.andExpect(model().attribute("messages", Arrays.asList(message1, message2)))
		.andExpect(model().attribute("tipo", "received"))

		.andExpect(view().name("messages/listMessage"));
    }

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
    public void showTest() throws Exception{
		Integer messageId = 1;
    	BDDMockito.given(messageService.findById(messageId)).willReturn(message1);
    	BDDMockito.given(userService.getPrincipal()).willReturn(user1);
    	BDDMockito.given(userService.findArtistByUserUsername("user1")).willReturn(Optional.of(new Artist()));
    	BDDMockito.given(userService.findProducerByUserUsername("user1")).willReturn(Optional.empty());
    	BDDMockito.given(userService.findWriterByUserUsername("user1")).willReturn(Optional.empty());

    	mockMvc.perform(get("/messages/show/"+messageId))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("isRequest"))
		.andExpect(model().attributeExists("isWriter"))
		.andExpect(model().attributeExists("isArtist"))
		.andExpect(model().attributeExists("isProducer"))
		.andExpect(model().attributeExists("message"))


		.andExpect(model().attribute("isRequest", false))
		.andExpect(model().attribute("isWriter", false))
		.andExpect(model().attribute("isArtist", true))
		.andExpect(model().attribute("isProducer", false))
		.andExpect(model().attribute("message", message1))


		.andExpect(view().name("messages/showMessage"));
    	
    }
	
	@WithMockUser(username = "user3", authorities = { "artist" })
	@Test
    public void showTestUnauthorized() throws Exception{
		Integer messageId = 1;
    	BDDMockito.given(messageService.findById(messageId)).willReturn(message1);
    	BDDMockito.given(userService.getPrincipal()).willReturn(user3);
    	BDDMockito.given(userService.findArtistByUserUsername("user3")).willReturn(Optional.of(new Artist()));
    	BDDMockito.given(userService.findProducerByUserUsername("user3")).willReturn(Optional.empty());
    	BDDMockito.given(userService.findWriterByUserUsername("user3")).willReturn(Optional.empty());

    	mockMvc.perform(get("/messages/show/"+messageId))
		.andExpect(status().is2xxSuccessful())

		.andExpect(view().name("error/error-403"));
    	
    }
	    
	@WithMockUser(username = "user3", authorities = { "artist" })
	@Test
    public void showAcceptStoryTest() throws Exception{
        Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/acceptRequestStory"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived"));
       
    }

	@WithMockUser(username = "user3", authorities = { "artist" })
	@Test
	public void showAcceptArtist() throws Exception{
		Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/acceptRequestArtist"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived"));
    	
    }
	
	@WithMockUser(username = "user3", authorities = { "artist" })
	@Test
	public void showAcceptProducer() throws Exception{
		Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/acceptRequestProducer"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived"));
    	
    }
	
	@WithMockUser(username = "user3", authorities = { "artist" })
	@Test
    public void showRejectStoryTest() throws Exception{
    	Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/rejectRequestStory"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived")); 
    	
     }

    @WithMockUser(username = "user3", authorities = { "artist" })
	@Test
    public void showRejectArtistTest() throws Exception{
    	Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/rejectRequestArtist"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived"));
    	
    }
    
    @WithMockUser(username = "user3", authorities = { "artist" })
	@Test
    public void showRejectProducerTest() throws Exception{
    	Integer messageId = 3;
    	
        mockMvc.perform(get("/messages/show/"+messageId+"/rejectRequestProducer"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/messages/listReceived"));
    	
    }

    @WithMockUser(username = "user3", authorities = { "artist" })
	@Test
	public void initFormCreateMessage() throws Exception{
    	String username = "user1";
    	mockMvc.perform(get("/messages/create/"+username))
		.andExpect(status().is2xxSuccessful())
		
		.andExpect(model().attributeExists("message", "userName", "Estado"))
		.andExpect(model().attribute("message", new Message()))
		.andExpect(model().attribute("userName", user1.getUsername()))
		.andExpect(model().attribute("Estado", "Exito"))

		
		.andExpect(view().name("messages/createMessageForm"));
    	
    }

    @WithMockUser(username = "user2", authorities = { "artist" })
	@Test
    @PostMapping("/create/{userName}")
    public String create(@PathVariable("userName") String userName, @Validated @ModelAttribute("message") Message message, BindingResult result, Model model){
		String username1 = "user1";
		String username2 = "user2";
    	BDDMockito.given(userService.getUserByUsername(username1)).willReturn(user1);
    	BDDMockito.given(userService.getUserByUsername(username2)).willReturn(user2);

    	
    	
    	if(!result.hasErrors()) {
    		String emisor_username = SecurityContextHolder.getContext().getAuthentication().getName();
    		message.setEmisor(userService.getUserByUsername(emisor_username));
    		message.setReceptor(userService.getUserByUsername(userName));
    		message.setMessageDate(Date.from(Instant.now()));
    		messageService.create(message);
    		model.addAttribute("Estado", "Exito");
            return "redirect:/messages/listSend";
    	}else {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
    		model.addAttribute(message);
            return "messages/createMessageForm";
		}
    }

    @WithMockUser(username = "user1", authorities = { "artist" })
	@Test
    public void initDelete() throws Exception{
    	Integer messageId = 3;
    	BDDMockito.given(messageService.findById(messageId)).willReturn(message1);
    	BDDMockito.given(userService.getPrincipal()).willReturn(user1);
    	
    	mockMvc.perform(get("/messages/delete/"+messageId))
		.andExpect(status().is3xxRedirection())
		
		.andExpect(model().attributeExists("Estado"))
		.andExpect(model().attribute("Estado", "Exito"))

		.andExpect(view().name("redirect:/messages/listReceived"));
    }
}
