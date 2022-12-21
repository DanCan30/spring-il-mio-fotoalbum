package org.generation.italy.main.pojo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@Size(max = 255, message = "The description is too long")
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
	
	@Nullable
	@ManyToMany
	private Set<Category> categories;
	
	@Nullable
	@OneToMany(mappedBy = "photo", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Comment> comments;
	
	
	public Photo() {}
	
	public Photo(String title, String description, String imageUrl, String tag, boolean isVisible) {
		setTitle(title);
		setDescription(description);
		setImageUrl(imageUrl);
		setTag(tag);
		setIsVisible(isVisible);
	}
	
	public Photo(String title, String description, String imageUrl, String tag, boolean isVisible, Category...categories) {
		this(title, description, imageUrl, tag, isVisible);
		setCategories(new HashSet<>(Arrays.asList(categories)));
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
	
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Set<Category> getCategories() {
		return this.categories;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Comment> getComments() {
		return this.comments;
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ") - " + getTitle();
	}
}
