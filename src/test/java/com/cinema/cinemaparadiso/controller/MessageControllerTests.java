package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MessageController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class MessageControllerTests {

    @Autowired
    MockMvc mockMvc;

//
//    @MockBean
//    private MessageService messageService;
//    
//    @MockBean
//    private UserService userService;

//    @BeforeEach
//	void setup() {
//    	
//    	User user1 = new User ("newTestUser1", "newTestUser1", true);
//    	User user2 = new User ("newTestUser2", "newTestUser2", true);
//    	
//    	Message message1 = new Message("New Test Issue", "New Test Body", Date.from(Instant.now()), user1, user2);
//    	List <Message> list = new ArrayList();
//    	list.add(message1);
//    	
//    	when(messageService.findById(1)).thenReturn(message1);
//    	
//    	when(userService.getUserByUsername("newTestUser1")).thenReturn(user1);
//    	when(userService.getUserByUsername("newTestUser2")).thenReturn(user2);
//
//    	when(messageService.findById(1)).thenReturn(message1);
//    	when(messageService.findByUsername("newTestUser1")).thenReturn((Iterable)list);
//	
//    }

    // He metido estos test como prueba para ver si el contexto carga correctamente.

    //@WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void testInitial() throws Exception {
//		
//		mockMvc.perform(get("/"))
//                .andExpect(status().is4xxClientError());
//	}
//
//    @Test
//	void testInitial2() throws Exception {
///*
//		mockMvc.perform(get("/users/create"))
//                .andExpect(status().is4xxClientError())
//                .andExpect(model().attributeExists("user"))
//				.andExpect(view().name("users/createUserForm"));
//*/
//	}
//    /*
//    @Test
//    @WithMockUser(username="newTestUser1",authorities= {"admin"})
//    public void testMessageList() throws Exception {
//    	mockMvc.perform(get("/messages/list"))
//    	.andExpect(status().is2xxSuccessful())
//    	.andExpect(model().attributeExists("messages"))
//    	.andExpect(view().name("messages/listMessage"));
//    }
//    
//    @Test
//    @WithMockUser(username="newTestUser1",authorities= {"admin"})
//    public void testShowMessage() throws Exception {
//    	Integer testMessageId = 1;
//    	
//    	mockMvc.perform(get("/messages/show/"+testMessageId))
//    	.andExpect(status().is2xxSuccessful())
//    	.andExpect(model().attributeExists("message"))
//    	.andExpect(view().name("messages/showMessage"));
//    	
//    }*/
//    
//    @Test
//    @WithMockUser(username="newTestUser1",authorities= {"admin"})
//    public void testInitCreate() throws Exception {    	
//    	String testUserName = "newTestUser1";
//    	
//    	mockMvc.perform(get("/messages/create/"+testUserName))
//    	.andExpect(status().is2xxSuccessful())
//    	.andExpect(model().attributeExists("message"))
//    	.andExpect(model().attributeExists("Estado"))
//    	.andExpect(view().name("messages/createMessageForm"));
//    	
//    }
    /*
    @Test
    @WithMockUser(username="newTestUser1",authorities= {"admin"})
    public void testCreate() throws Exception {    	
    	String testUserName = "newTestUser2";
    	
    	Message messageNew = new Message("New Test Issue 2", "New Test Body 2", Date.from(Instant.now()), null, null);
    	
    	Map<String, String> message = new HashMap<String, String>();
    	message.put("issue", "New Test Issue");
    	message.put("body", "New Test Body");
    	message.put("messageDate", Date.from(Instant.now()).toString());
    	
    	mockMvc.perform(post("/messages/create/"+testUserName)
    			.param("issue", "New Test Issue")
    			.param("body", "New Test Body")
    			.param("messageDate", Date.from(Instant.now()).toString()))
    	.andExpect(status().is2xxSuccessful())
    	.andExpect(model().attributeExists("message"))
    	.andExpect(model().attributeExists("Estado"))
    	.andExpect(view().name("messages/createMessageForm"));
    	
    }*/
   
}
