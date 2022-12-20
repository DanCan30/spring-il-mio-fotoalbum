package org.generation.italy.main.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.main.pojo.Category;
import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String goToCategoryIndex(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "admin/category-index";
	}
	
	@GetMapping("/create")
	public String createCategory(Model model) {
		
		Category newCategory = new Category();
		
		model.addAttribute("category", newCategory);
		
		return "admin/category-create";
	}
	
	@PostMapping("/create")
	public String storeCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/categories/create" ;
		}
		
		categoryService.save(category);
		
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		
		Optional<Category> categoryOpt = categoryService.findById(id);
		
		if(categoryOpt.isEmpty())
			return "404";
		
		Category category = categoryOpt.get();
		
		model.addAttribute("category", category);
		
		return "admin/category-edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updateCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/categories/edit/" + category.getId() ;
		}
		
		categoryService.save(category);
		
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		
		Optional<Category> categoryOpt = categoryService.findById(id);
		
		if(categoryOpt.isEmpty())
			return "404";
		
		Category category = categoryOpt.get();
		
		List<Photo> categoryPhotos = category.getPhotos();
		
		for(Photo p : categoryPhotos) {
			p.getCategories().remove(category);
		}
		
		categoryService.delete(category);
		
		return "redirect:/admin/categories";
	}

}
