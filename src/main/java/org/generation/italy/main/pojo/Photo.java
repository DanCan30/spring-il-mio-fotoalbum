package org.generation.italy.main.pojo;

import org.hibernate.validator.constraints.URL;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "The title can't be empty")
	@NotNull(message = "The title can't be empty")
	@Size(min = 4, max = 32, message= "The title's length must be between 4 and 32 characters")
	@Column(name = "title")
	private String title;
	
	@Lob
	@Column(name = "description")
	@Nullable
	private String description;
	
	@Lob
	@NotNull(message = "Please insert a valid image path")
	@NotBlank(message = "Please insert a valid image path")
	@URL(message = "The image path is not valid")
	@Column(name = "image_url")
	private String imageUrl;
	
	
	@Nullable
	@Column(name = "tag")
	private String tag;
	
	
	@Column(name = "is_visible", nullable = false, columnDefinition = "boolean default true")
	private boolean isVisible;
	
	
	public Photo() {}
	
	public Photo(String title, String description, String imageUrl, String tag, boolean isVisible) {
		setTitle(title);
		setDescription(description);
		setImageUrl(imageUrl);
		setTag(tag);
		setIsVisible(isVisible);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTag() {
		return this.tag;
	}
	
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public boolean getIsVisible() {
		return this.isVisible;
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ") - " + getTitle();
	}
}
