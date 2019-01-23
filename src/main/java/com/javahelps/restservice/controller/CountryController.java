package com.javahelps.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.javahelps.restservice.entity.Countries;
import com.javahelps.restservice.service.CountryService;
import com.javahelps.restservice.util.CountryNotFoundException;
import com.javahelps.restservice.util.MyExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/countries")
public class CountryController extends MyExceptionHandler{

	@Autowired
	private CountryService countryService; // Service which will do all data retrieval/manipulation work

	public static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	// -------------------Retrieve All Countries---------------------------------------------
    @GetMapping
    public ResponseEntity<?> listAllCountries(WebRequest request, @RequestParam("page")String page){
    	logger.info("Retrieve 10 Countries start with page: {}", page);
    	try {
    		Integer pageNumber = 0;
    		pageNumber = Integer.parseInt(page);
    		Page<Countries> countries = countryService.getAllCountries(pageNumber);
    		if (countries.getSize()==0) {
    			throw new CountryNotFoundException("CountryNotFoundException");
    		}
    		return new ResponseEntity<Page<Countries>>(countries, HttpStatus.OK);
    	}
    	catch(NumberFormatException e) {
    		return handleAnyException(new Exception("You are trying to convert an invalid String into Integer by passing (page=" + page 
                    + ")"), HttpStatus.BAD_REQUEST, request);
    	}
    	catch(IllegalArgumentException e) {
    		return handleAnyException(new Exception("Wrong passed request param. The URL with param (page=" + page 
                    + ") is not Integer."), HttpStatus.BAD_REQUEST, request);
    	}
    	catch(CountryNotFoundException e) {
    		return handleAnyException(new Exception("No countries found with page = " + page), HttpStatus.NOT_FOUND, request);
    	}
    	catch(Exception e) {
    		return handleAnyException(new Exception("Unexpected error."), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	}
	}

	
	// -------------------Retrieve Single Country------------------------------------------
	 
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> search(WebRequest request, @PathVariable("name") String name) {   
        try {
        	 logger.info("Fetching Country with id {}", name);
             Countries country = countryService.findByName(name);
             if (country == null) {
                 logger.error("Country with name {} not found.", name);
                 throw new CountryNotFoundException("CountryNotFoundException");               
             }
    		return new ResponseEntity<Countries>(country, HttpStatus.OK);
    	}
    	catch(IllegalArgumentException e) {
    		return handleAnyException(new Exception("Wrong passed request param. The URL with param (page=" + name 
                    + ") is not Integer."), HttpStatus.BAD_REQUEST, request);
    	}
    	catch(CountryNotFoundException e) {
    		return handleAnyException(new Exception("Country with name = " + name + " not found"), HttpStatus.NOT_FOUND, request);
    	}
    	catch(Exception e) {
    		return handleAnyException(new Exception("Unexpected error."), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	}
    }

}