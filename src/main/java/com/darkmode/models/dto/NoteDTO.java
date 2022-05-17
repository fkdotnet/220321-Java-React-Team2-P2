package com.darkmode.models.dto;

import java.util.Objects;

import com.darkmode.models.Note;

public class NoteDTO {
private long note_id;
private String note_title;
private String note_object;
private long user_id;
private newUserDTO newUserDTO;
private String date_created;

public static NoteDTO from(Note note) {
	NoteDTO noteDto = new NoteDTO();
	newUserDTO NewUserDTO = new newUserDTO();
	noteDto.setNote_id(note.getNote_id());
	noteDto.setNote_title(note.getTitle());
	noteDto.setNoteObject(note.getTextObj());
	noteDto.setDate_created(note.getDate_created());
	if(Objects.nonNull(note.getUser())) {
		noteDto.setNewUserDTO(NewUserDTO.from(note.getUser()));
		noteDto.setUserID(note.getUser().getId());
	}
	
	
	
	return noteDto;
	
}

public NoteDTO(long note_id, String note_title, String noteObject, int userID,
		com.darkmode.models.dto.newUserDTO newUserDTO) {
	super();
	this.note_id = note_id;
	this.note_title = note_title;
	this.note_object = noteObject;
	this.user_id = userID;
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
	return note_object;
}

public void setNoteObject(String noteObject) {
	this.note_object = noteObject;
}

public long getUserID() {
	return user_id;
}

public void setUserID(Long long1) {
	this.user_id = long1;
}

public newUserDTO getNewUserDTO() {
	return newUserDTO;
}

public void setNewUserDTO(newUserDTO newUserDTO) {
	this.newUserDTO = newUserDTO;
}

public String getDate_created() {
	return date_created;
}

public void setDate_created(String date_created) {
	this.date_created = date_created;
}




}
