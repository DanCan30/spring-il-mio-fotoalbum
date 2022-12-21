package org.generation.italy.main.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Lob
	@NotNull
	@Column
	private String text;
	
	@ManyToOne
	private Photo photo;
	
	public Comment() {}
	
	public Comment(String text, Photo photo) {
		setText(text);
		setPhoto(photo);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Photo getPhoto() {
		return this.photo;
	}
}
