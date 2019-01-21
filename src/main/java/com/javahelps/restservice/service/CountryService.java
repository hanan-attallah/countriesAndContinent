package com.javahelps.restservice.service;

import org.springframework.data.domain.Page;
import com.javahelps.restservice.entity.Countries;

public interface CountryService {
	
	Countries findByName(String name);
	
	Page<Countries> getAllCountries(String page);
	
	//List<Countries> getAllCountries(int pageNumber, int pageSize);

}
