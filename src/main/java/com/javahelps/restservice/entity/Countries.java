package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Countries {

    @Id
    private String code;
    private String name;
    private String fullName;
    private String iso3;
    private String number;
    
    @ManyToOne
	@JoinColumn (name="continent_code")
    private Continents continent;

    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Continents getContinentCode() {
		return continent;
	}
	public void setContinentCode(Continents continent) {
		this.continent = continent;
	}
	
	
	@Override
    public String toString() {
        return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", iso3='" + iso3 + '\''
                + ", number='" + number + '\'' + "continent=" +continent.toString() + '}';
    }
}