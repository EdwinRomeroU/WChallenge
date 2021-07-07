package com.wchallenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//cart
@Entity
@Table(name = "Album_User")
public class AlbumShareModel {

	public static String grantREAD = "READ";
	public static String grantWRITE = "WRITE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer idUser;
	private Integer idAlbum;
	private String userGrant;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getUserGrant() {
		return userGrant;
	}
	public void setUserGrant(String userGrant) {
		this.userGrant = userGrant;
	}
	
}
