package com.wchallenge.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumModel {

	private Integer userId;
	private Integer id;
	private String tittle;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	
	
}
