package com.wchallenge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserAlbumGrant")
public class UserAlbumGrant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable=false)
	private Integer id;
	
	private Integer userOwnerId;
	private Integer albumId;
	private Integer userId;
	private String grant;
	
	public Integer getUserOwnerId() {
		return userOwnerId;
	}
	public void setUserOwnerId(Integer userOwnerId) {
		this.userOwnerId = userOwnerId;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getGrant() {
		return grant;
	}
	public void setGrant(String grant) {
		this.grant = grant;
	}
	
}
