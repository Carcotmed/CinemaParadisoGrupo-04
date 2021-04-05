package com.cinema.cinemaparadiso.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController  {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    System.out.println("status: "+status);
	    if (status != null) {
	    	Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	log.error("ERROR 404");
	            return "error/error-404";
	        }
	        else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	log.error("ERROR 403");
	            return "error/error-403";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	log.error("ERROR 500");
	            return "error/error-500";
	        }
	    }
    	log.error("ERROR");
	    return "error/error";
	}

}
