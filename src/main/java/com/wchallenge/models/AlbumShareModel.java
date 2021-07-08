package com.wchallenge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Album_User")
public class AlbumShareModel {

	public static String grantREAD = "READ";
	public static String grantWRITE = "WRITE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable=false)
	private Integer id;
	
	private Integer idUser;
	private Integer idAlbum;
	private String userGrant;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
