package org.generation.italy.main.api.controller;

import java.util.List;

import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/1/photo")
public class PhotoApiController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/all")
	public List<Photo> getAll() {
		return photoService.findAll();
	}
	
	@GetMapping("/search")
	public List<Photo> searchByNameOrTag(@RequestParam(name = "query", required = false) String query) {

		List<Photo> photos = (query == "" || query == null) ? photos = photoService.findAll() : photoService.findByNameOrTag(query);
		
		return photos;
	}
	
}
