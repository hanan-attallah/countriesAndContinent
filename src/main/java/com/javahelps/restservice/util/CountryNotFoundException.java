package com.javahelps.restservice.util;

@SuppressWarnings("serial")
public class CountryNotFoundException extends Exception{

	public CountryNotFoundException (String message){
		super(message);
	}
}
