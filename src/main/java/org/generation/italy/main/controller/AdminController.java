package org.generation.italy.main.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.main.pojo.Photo;
import org.generation.italy.main.service.PhotoService;
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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public String getPhotoIndex(Model model) {
		
		List<Photo> photos = photoService.findAll();
		
		model.addAttribute("photos", photos);
		
		return "admin/photo-index";
	}
	
	@GetMapping("/create")
	public String createPhoto(Model model) {
		Photo newPhoto = new Photo();
		
		model.addAttribute("photo", newPhoto);
		
		return "admin/photo-create";
	}
	
	@PostMapping("/create")
	public String savePhoto(@Valid @ModelAttribute("photo") Photo photo,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/create";
		}
		
		photoService.save(photo);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/edit/{id}")
	public String editPhoto(@PathVariable("id") int id, Model model) {
		Optional<Photo> photoOpt = photoService.findById(id);
		
		if(photoOpt.isEmpty())
			return "404";
		
		Photo photo = photoOpt.get(); 
		
		model.addAttribute("photo", photo);
		
		return "admin/photo-edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updatePhoto(@Valid @ModelAttribute("photo") Photo photo,
				BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/edit/" + photo.getId() ;
		}
		
		photoService.save(photo);
		
		return "redirect:/admin";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePhoto(@PathVariable("id") int id) {
		
		Optional<Photo> photoOpt = photoService.findById(id);
		
		if(photoOpt.isEmpty())
			return "404";
		
		Photo photo = photoOpt.get();
		
		photoService.delete(photo);
		
		return "redirect:/admin";
	}
}
