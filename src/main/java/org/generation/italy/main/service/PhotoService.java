package org.generation.italy.main.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepo photoRepo;
	
	public List<Photo> findAll() {
		return photoRepo.findAll();
	}
	
	public void save(Photo photo) {
		photoRepo.save(photo);
	}
	public void delete(Photo photo) {
		photoRepo.delete(photo);
	}
	
	public Optional<Photo> findById(int id) {
		
		return photoRepo.findById(id);
	}
}
