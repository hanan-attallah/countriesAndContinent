package com.javahelps.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.javahelps.restservice.entity.Countries;
import com.javahelps.restservice.repository.CountryRepository;

@Service
public class CountryService {
		
	@Autowired
	private CountryRepository countryRepository;


	public Page<Countries> getAllCountries(Integer page) {
		return countryRepository.findAll(new PageRequest(page, 10, Sort.Direction.ASC, "name"));
	}
	
	public Countries findByName(String name) {
		return countryRepository.findByName(name);
	}

}
