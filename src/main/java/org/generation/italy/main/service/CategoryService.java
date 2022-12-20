package org.generation.italy.main.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.main.pojo.Category;
import org.generation.italy.main.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	public void save(Category category) {
		categoryRepo.save(category);
	}
	public void delete(Category category) {
		categoryRepo.delete(category);
	}
	
	public Optional<Category> findById(int id) {
		return categoryRepo.findById(id);
	}
	
}
