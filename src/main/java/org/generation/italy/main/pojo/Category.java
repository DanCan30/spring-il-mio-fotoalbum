package org.generation.italy.main.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "The name of teh category can't be empty")
	@NotNull(message = "The name of teh category can't be empty")
	@Column
	private String name;
	
	
	@ManyToMany(mappedBy = "categories")
	private List<Photo> photos;
	
	public Category() {};
	
	public Category(String name) {
		setName(name);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public List<Photo> getPhotos() {
		return this.photos;
	}
	
	@Override
	public int hashCode() {
		if(this.id != null)
			return getId();
		
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Category)) return false;
		return obj.hashCode() == hashCode();
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + getId() + ") - " + getName();
	}
}
