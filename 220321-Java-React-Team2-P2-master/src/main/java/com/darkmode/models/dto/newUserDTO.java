package com.darkmode.models.dto;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.darkmode.models.RevNoteUser;

public class newUserDTO {
	//also implementable in case of user deleting all at somepoint?
	private Long user_id;
	private String userName;
	private String pw;
	private String firstName;
	private String lastName;
	private String email;
	
	public static newUserDTO from(RevNoteUser user) {
	newUserDTO NewUserDTO = new newUserDTO();
	NewUserDTO.setUser_id(user.getId());
	NewUserDTO.setUserName(user.getUserName());
	NewUserDTO.setPw(user.getPw());
	NewUserDTO.setFirstName(user.getFirstName());
	NewUserDTO.setLastName(user.getPw());
	NewUserDTO.setEmail(user.getEmail());
	
	return NewUserDTO;
}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}