package com.darkmode.models.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.darkmode.models.RevNoteUser;

public class UserDTO {
private long user_id;
private String first_name;
private String last_name;
private String userName;
private String passwrd;
private String email;
private String imgurl;


public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}
private List <NoteDTO> notesDTO = new ArrayList<>();


public List<NoteDTO> getNotesDTO() {
	return notesDTO;
}



public void setNotesDTO(List<NoteDTO> notesDTO) {
	this.notesDTO = notesDTO;
}



public static UserDTO from(RevNoteUser user) {
	UserDTO userDTO = new UserDTO();
	userDTO.setUser_id(user.getId());
	userDTO.setUserName(user.getUserName());
	userDTO.setFirst_name(user.getFirstName());
	userDTO.setLast_name(user.getLastName());
	userDTO.setPasswrd(user.getPw());
	userDTO.setEmail(user.getEmail());
	userDTO.setImgurl(user.getImgURL());
	userDTO.setNotesDTO(user.getUserNotes().stream().map(NoteDTO::from).collect(Collectors.toList()));
	return userDTO;
}



public String getImgurl() {
	return imgurl;
}



public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}



public long getUser_id() {
	return user_id;
}
@Override
public int hashCode() {
	return Objects.hash(first_name, last_name, passwrd, userName, user_id);
}
public UserDTO() {
	super();
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	UserDTO other = (UserDTO) obj;
	return Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name)
			&& Objects.equals(passwrd, other.passwrd) && Objects.equals(userName, other.userName)
			&& user_id == other.user_id;
}
public UserDTO(long user_id, String first_name, String last_name, String userName, String passwrd, String email) {
	super();
	this.user_id = user_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.userName = userName;
	this.passwrd = passwrd;
	this.email = email;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPasswrd() {
	return passwrd;
}
public void setPasswrd(String passwrd) {
	this.passwrd = passwrd;
}
}
