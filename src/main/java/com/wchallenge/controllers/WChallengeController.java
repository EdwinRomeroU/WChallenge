package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wchallenge.models.AlbumModel;
import com.wchallenge.models.AlbumShareModel;
import com.wchallenge.models.CommentModel;
import com.wchallenge.models.PhotoModel;
import com.wchallenge.models.UserModel;
import com.wchallenge.services.WChallengeService;

@RestController
@RequestMapping("/wchallenge")
public class WChallengeController {

	@Autowired
	private WChallengeService wchallengeService;
	
	@GetMapping("/photos")
	public List<PhotoModel> getPhotos(){
		return wchallengeService.getPhotos();
	}
	
	@GetMapping("/photosByUser/{id}")
	public List<PhotoModel> getPhotosByUserId(@PathVariable("id") Integer id){
		return wchallengeService.getPhotosByUserId(id);
	}
	
	@GetMapping("/users")
	public List<UserModel> getUsers(){
		return wchallengeService.getUsers();
	}
	
	@GetMapping("/comments")
	public List<CommentModel> getComments(){
		return wchallengeService.getComments();
	}
	
	@GetMapping("/comments/{name}")
	public List<CommentModel> getAlbumsByUserId(@PathVariable("name") String name){
		return wchallengeService.getCommentsByName(name);
	}

	@GetMapping("/albums")
	public List<AlbumModel> getAlbums(){
		return wchallengeService.getAlbums();
	}

	@GetMapping("/albums/{id}")
	public List<AlbumModel> getAlbumsByUserId(@PathVariable("id") Integer id){
		return wchallengeService.getAlbumsByUser(id);
	}
	
	@GetMapping("/commentsByUser/{userId}")
	public List<CommentModel> getPostByUserId(@PathVariable("userId") Integer userId){
		return wchallengeService.getCommentsByUser(userId);
	}
	
	//Local API Controller
	@PostMapping("/save")
	public AlbumShareModel saveAlbumShare(@RequestBody AlbumShareModel albumShare) {
		return this.wchallengeService.saveAlbumShare(albumShare);
	}
	
	@GetMapping("/albumShare/{idAlbum}/{userGrant}")
	public List<AlbumShareModel> getAlbumShareByAlbumGrant(@PathVariable("idAlbum") Integer id, @PathVariable("userGrant") String grant){
		return this.wchallengeService.getAlbumShareByAlbumGrant(id, grant);
	}
	
}
