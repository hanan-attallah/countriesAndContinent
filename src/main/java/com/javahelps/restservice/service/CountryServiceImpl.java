package com.javahelps.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.javahelps.restservice.entity.Countries;
import com.javahelps.restservice.repository.CountryRepository;



@Service("CountryService")
public class CountryServiceImpl implements CountryService{
		
	@Autowired
	private CountryRepository countryRepository;


	@Override
	public Page<Countries> getAllCountries(String page) {
		return countryRepository.findAll(new PageRequest(Integer.parseInt(page), 10, Sort.Direction.ASC, "name"));
	}
	
	@Override
	public Countries findByName(String name) {
		return countryRepository.findByName(name);
	}

//	@Override
//	public List<Countries> getAllCountries(int pageNumber, int pageSize) {
//		return countryRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
//	}

}
