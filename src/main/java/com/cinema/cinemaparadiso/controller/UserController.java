package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model){
        Iterable<User> users = userService.list();
        model.addAttribute("users", users);
        log.info("Listing Users..."+users.toString());
        return "users/listUser";
    }

    @GetMapping("/create")
    public String initFormCreateUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        Writer writer = new Writer();
        model.addAttribute("writer", writer);
        model.addAttribute("tipoUser", "artist");
        return "users/createUserForm";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult result){
        try{
            userService.createUser(user);
            log.info("User Created Successfully");
        }catch(Exception e){
            log.error("Error Create User", e);
        }
        return "index";
    }
}
