package com.wchallenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.models.AlbumModel;
import com.wchallenge.models.AlbumShareModel;
import com.wchallenge.models.CommentModel;
import com.wchallenge.models.PhotoModel;
import com.wchallenge.models.PostModel;
import com.wchallenge.models.UserModel;
import com.wchallenge.repositories.AlbumShareRepository;

@Service
public class WChallengeService {

	private RestTemplate restTemplate;
	
	private static String url = "https://jsonplaceholder.typicode.com/";
			
	//External API manager
	
	@Autowired
	public WChallengeService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<PhotoModel> getPhotos(){
		ResponseEntity<List<PhotoModel>> responseEntity = restTemplate.exchange(url+"photos/", HttpMethod.GET, null, new ParameterizedTypeReference<List<PhotoModel>>(){});
		List<PhotoModel> allPhotos = responseEntity.getBody();
		return allPhotos;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserModel> getUsers(){
		return restTemplate.exchange(url+"users/", HttpMethod.GET, null, List.class).getBody();
	}
	
	public List<CommentModel> getComments(){
		ResponseEntity<List<CommentModel>> responseEntity = restTemplate.exchange(url+"comments/", HttpMethod.GET, null, new ParameterizedTypeReference<List<CommentModel>>(){});
		List<CommentModel> allComments = responseEntity.getBody();
		return allComments;
	}
	
	public List<CommentModel> getCommentsByName(String name){
		ResponseEntity<List<CommentModel>> responseEntity = restTemplate.exchange(url+"comments?name="+name, HttpMethod.GET, null, new ParameterizedTypeReference<List<CommentModel>>(){});
		List<CommentModel> commentsByName = responseEntity.getBody();
		return commentsByName;
	}
	
	public List<AlbumModel> getAlbums(){
		ResponseEntity<List<AlbumModel>> responseEntity = restTemplate.exchange(url+"albums/", HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumModel>>(){});
		List<AlbumModel> allAlbums = responseEntity.getBody();
		return allAlbums;
	}
	
	public List<AlbumModel> getAlbumsByUser(Integer userId){
		String urlAlbum = url+"albums?userId="+userId;
		ResponseEntity<List<AlbumModel>> responseEntity = restTemplate.exchange(urlAlbum, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumModel>>(){});
		List<AlbumModel> albumsByUser = responseEntity.getBody();
		return albumsByUser;
	}
	
	public List<PhotoModel> getPhotosByUserId(Integer userId){
		List<PhotoModel> allPhotos = getPhotos();
		List<AlbumModel> albumsByUser = getAlbumsByUser(userId);
		List<PhotoModel> photosByUser = new ArrayList<PhotoModel>();
		
		for (AlbumModel albumLoop : albumsByUser) {
			for (PhotoModel photoLoop : allPhotos) {
				if (photoLoop.getAlbumId().equals(albumLoop.getId())) {
					PhotoModel newPhoto = photoLoop;
					photosByUser.add(newPhoto);
				}
			}
		}
		return photosByUser;
	}
	
	public List<CommentModel> getCommentsByUser(Integer userId){
		String urlPost = url+"posts?userId="+userId;
		
		ResponseEntity<List<PostModel>> responseEntity = restTemplate.exchange(urlPost, HttpMethod.GET, null, new ParameterizedTypeReference<List<PostModel>>(){});
		List<PostModel> postByUser = responseEntity.getBody();
		List<CommentModel> allComments = getComments();
		List<CommentModel> commentsByUser = new ArrayList<CommentModel>();
		
		for (PostModel postIterate : postByUser) {
			for (CommentModel commentIterate : allComments) {
				if (postIterate.getId().equals(commentIterate.getPostId())) {
					CommentModel newComment = commentIterate;
					commentsByUser.add(newComment);
				}
			}
		}
		return commentsByUser;
	}
	
	
	//Local API Manager
	
	@Autowired
	AlbumShareRepository albumShareRepository;
	
	public AlbumShareModel saveAlbumShare(AlbumShareModel albumShare) {
		/*
		//Validate Album Exists
		List<AlbumModel> albums = getAlbums();
		List<AlbumModel> existAlbum = new ArrayList<>();
		existAlbum = albums.stream().filter(a -> a.getId().equals(albumShare.getIdAlbum())).collect(Collectors.toList());
				
		//Validate Album Exists
		List<UserModel> users = getUsers();
		List<UserModel> existUser = new ArrayList<>();
		existUser = users.stream().filter(a -> a.getId().equals(albumShare.getIdUser())).collect(Collectors.toList());
				
		if (existAlbum.isEmpty() || existUser.isEmpty()) {
			return new AlbumShareModel();
		}
		*/
		return albumShareRepository.save(albumShare);
	}
	
	public Optional<AlbumShareModel> getAlbumShareById(Integer id){
		return albumShareRepository.findById(id);
	}

	public List<AlbumShareModel> getAlbumShareByGrant(String userGrant){
		return albumShareRepository.findByUserGrant(userGrant);
	}
	
	public List<AlbumShareModel> getAlbumShareByUserId(Integer userId){
		return albumShareRepository.findByIdUser(userId);
	}
	
	public List<AlbumShareModel> getAlbumShareByAlbumId(Integer albumId){
		return albumShareRepository.findByIdAlbum(albumId);
	}
	
	public List<AlbumShareModel> getAlbumShareByAlbumGrant(Integer albumId, String userGrant){
		return albumShareRepository.findByIdAlbumAndUserGrant(albumId,userGrant);
		
	}
}
