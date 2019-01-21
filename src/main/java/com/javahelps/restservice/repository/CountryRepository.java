package com.javahelps.restservice.repository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javahelps.restservice.entity.Countries;

@RestResource(exported = false)
public interface CountryRepository extends JpaRepository<Countries, String> {
	public Countries findByName(String name);  
    
}