package org.generation.italy.main.service;

import java.util.List;

import org.generation.italy.main.pojo.Comment;
import org.generation.italy.main.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private CommentRepo commentRepo;
	
	public List<Comment> findAll() {
		return commentRepo.findAll();
	}
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
	public void delete(Comment comment) {
		commentRepo.delete(comment);
	}
}
