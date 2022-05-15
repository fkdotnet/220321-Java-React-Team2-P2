package com.darkmode.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note{
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long note_id;
	private String Title;
	private String TextObj;
	@ManyToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Note(Long note_id, String title, String textObj) {
		super();
		this.note_id = note_id;
		Title = title;
		TextObj = textObj;
	}
	public Long getNote_id() {
		return note_id;
	}
	public void setNote_id(Long note_id) {
		this.note_id = note_id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTextObj() {
		return TextObj;
	}
	public void setTextObj(String textObj) {
		TextObj = textObj;
	}
	
	
}