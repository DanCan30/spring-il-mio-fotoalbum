package org.generation.italy.main.api.controller;

import java.util.Collections;
import java.util.List;

import org.generation.italy.main.pojo.Comment;
import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.service.CommentService;
import org.generation.italy.main.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/1/comments")
public class CommentApiController {
	
	@Autowired
	private PhotoService photoService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/all/photo/{id}")
	public List<Comment> getCommentsPerPhoto(@PathVariable("id") int id) {
		
		Photo photo = photoService.findById(id).get();
		List<Comment> comments = photo.getComments();
		
		Collections.reverse(comments);
		return comments;
	}
	
	
	@PostMapping("/add/photo/{id}")
	public Comment addCommentsAtPhoto(@Valid @RequestBody Comment comment,
			@PathVariable("id") int id) {
		
		
		Photo photo = photoService.findById(id).get();
		
		Comment newComment = new Comment(comment.getText(), photo);
		
		commentService.save(newComment);
		
		List<Comment> comments = photo.getComments();
		
		comments.add(newComment);
	
		return newComment;
			
	}

}
