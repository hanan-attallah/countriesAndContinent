package com.javahelps.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javahelps.restservice.entity.Countries;
import com.javahelps.restservice.service.CountryService;
import com.javahelps.restservice.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path="/countries")
public class CountryController {

    @Autowired
    private CountryService countryService; //Service which will do all data retrieval/manipulation work
    
    public static final Logger logger = LoggerFactory.getLogger(CountryController.class);


	// -------------------Retrieve All Countries---------------------------------------------
    @GetMapping
    public ResponseEntity<Page<Countries>> listAllCountries(@RequestParam("page")String page) {
    	logger.info("Retrieve 10 Countries start with page: {}", page);
		Page<Countries> countries = countryService.getAllCountries(page);
		if (countries == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Page<Countries>>(countries, HttpStatus.OK);
	}

	
	// -------------------Retrieve Single Country------------------------------------------
	 
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> search(@PathVariable("name") String name) {
        logger.info("Fetching Country with id {}", name);
        Countries country = countryService.findByName(name);
        if (country == null) {
            logger.error("Country with name {} not found.", name);
            return new ResponseEntity(new CustomErrorType("Country with id " + name 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Countries>(country, HttpStatus.OK);
    }

}