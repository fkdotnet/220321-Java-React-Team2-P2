package com.darkmode.models.dto;

import java.util.Objects;

import com.darkmode.models.Note;

public class NoteDTO {
private long note_id;
private String note_title;
private String noteObject;
private int userID;
private newUserDTO newUserDTO;

public static NoteDTO from(Note note) {
	NoteDTO noteDto = new NoteDTO();
	newUserDTO NewUserDTO = new newUserDTO();
	noteDto.setNote_id(note.getNote_id());
	noteDto.setNote_title(note.getTitle());
	noteDto.setNoteObject(note.getTitle());
	if(Objects.nonNull(note.getUser())) {
		noteDto.setNewUserDTO(NewUserDTO.from(note.getUser()));
	}
	
	
	
	return noteDto;
	
}

public NoteDTO(long note_id, String note_title, String noteObject, int userID,
		com.darkmode.models.dto.newUserDTO newUserDTO) {
	super();
	this.note_id = note_id;
	this.note_title = note_title;
	this.noteObject = noteObject;
	this.userID = userID;
	this.newUserDTO = newUserDTO;
}

public NoteDTO() {
	super();
}

public long getNote_id() {
	return note_id;
}

public void setNote_id(long note_id) {
	this.note_id = note_id;
}

public String getNote_title() {
	return note_title;
}

public void setNote_title(String note_title) {
	this.note_title = note_title;
}

public String getNoteObject() {
	return noteObject;
}

public void setNoteObject(String noteObject) {
	this.noteObject = noteObject;
}

public int getUserID() {
	return userID;
}

public void setUserID(int userID) {
	this.userID = userID;
}

public newUserDTO getNewUserDTO() {
	return newUserDTO;
}

public void setNewUserDTO(newUserDTO newUserDTO) {
	this.newUserDTO = newUserDTO;
}




}
