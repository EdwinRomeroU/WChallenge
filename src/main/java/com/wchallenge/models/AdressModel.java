package com.wchallenge.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressModel {

	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private GeoModel geoModel;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public GeoModel getGeoModel() {
		return geoModel;
	}
	public void setGeoModel(GeoModel geoModel) {
		this.geoModel = geoModel;
	}
	
}
