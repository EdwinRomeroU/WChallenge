package com.wchallenge.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private Integer id;
	private String name;
	private String username;
	private String email;
	private AdressModel adressModel;
	private String phone;
	private String website;
	private CompanyModel companyModel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AdressModel getAdressModel() {
		return adressModel;
	}
	public void setAdressModel(AdressModel adressModel) {
		this.adressModel = adressModel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public CompanyModel getCompanyModel() {
		return companyModel;
	}
	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}
	
}
