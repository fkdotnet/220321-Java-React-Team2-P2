package com.darkmode.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.darkmode.models.dto.NoteDTO;

@Entity
@Table(name = "notes", schema = "dark_mode")

public class Note{
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long note_id;
	private String Title;
	private String note_object;
	private String date_created;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	
	private RevNoteUser user;
	public Note() {
		
		
	}
	
	public static Note from(NoteDTO noteDTO) {
		Note note = new Note();
		note.setTitle(noteDTO.getNote_title());
		note.setTextObj(noteDTO.getNoteObject());
		return note;
		
	}
	public RevNoteUser getUser() {
		return user;
	}
	public void setUser(RevNoteUser user) {
		this.user = user;
	}
	public Note(Long note_id, String title, String textObj,String date_created) {
		super();
		this.note_id = note_id;
		this.Title = title;
		note_object = textObj;
		this.date_created = date_created;
		
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
		return note_object;
	}
	public void setTextObj(String textObj) {
		note_object = textObj;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	
}