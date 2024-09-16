package com.sesi.login.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{

	   @GetMapping("/error")
	    public String handleError(HttpServletRequest request) {
		   Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());

	            if (statusCode == 404) {
	                return "error-404";
	            } else if (statusCode == 500) {
	                return "error-500";
	            }
	        }

	        return "error";  // Página genérica de erro
	    }
	   
	    public String getErrorPath() {
	        return "/error";
	    }
}
