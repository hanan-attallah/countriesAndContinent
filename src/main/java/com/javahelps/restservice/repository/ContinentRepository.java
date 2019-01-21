package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.javahelps.restservice.entity.Continents;

@RestResource(exported = false)
public interface ContinentRepository extends JpaRepository<Continents, String> {
	public Continents findByName(String name); 
}