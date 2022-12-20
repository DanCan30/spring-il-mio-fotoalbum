package org.generation.italy.main.pojo;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "The title can't be empty")
	@NotNull(message = "The title can't be empty")
	@Column(name = "title")
	private String title;
	
	@Lob
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "Please insert a valid image path")
	@URL(message = "The image path is not valid" )
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "is_visible")
	private boolean isVisible;
	
	
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
