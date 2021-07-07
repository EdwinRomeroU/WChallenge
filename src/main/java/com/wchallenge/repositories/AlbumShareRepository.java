package com.wchallenge.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wchallenge.models.AlbumShareModel;

@Repository
public interface AlbumShareRepository extends CrudRepository <AlbumShareModel, Integer> {
	
	public abstract ArrayList<AlbumShareModel> findByUserGrant(String userGrant);
	
	public abstract ArrayList<AlbumShareModel> findByIdUser(Integer idUser);
	
	public abstract ArrayList<AlbumShareModel> findByIdAlbum(Integer idAlbum);
	
	public abstract ArrayList<AlbumShareModel> findByIdAlbumAndUserGrant(Integer idAlbum, String userGrant);
	
}
