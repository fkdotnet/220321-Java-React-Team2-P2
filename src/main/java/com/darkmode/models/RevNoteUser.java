	package com.darkmode.models;

	import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.darkmode.models.dto.UserDTO;

@Entity
@Table(name = "revnotes_users", schema = "dark_mode")
public class RevNoteUser {



		public RevNoteUser( long user_id,String username, String passwrd, String first_name, String last_name, String email,
			String imgurl, List<Note> userNotes) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.passwrd = passwrd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.imgurl = imgurl;
		this.userNotes = userNotes;
	}
		private @Id @GeneratedValue Long user_id;
		private String username;
		private String passwrd;
		private String first_name;
		private String last_name;
		private String email;
		private String imgurl;
		public String getImgURL() {
			return imgurl;
		}
		public void setImgURL(String imgURL) {
			this.imgurl = imgURL;
		}
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
		private List<Note> userNotes = new ArrayList<>();

	
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public List<Note> getUserNotes() {
			return userNotes;
		}
		public void setUserNotes(List<Note> userNotes) {
			this.userNotes = userNotes;
		}
		
		public Long getId() {
			return user_id;
		}
		public void setId(Long id) {
			this.user_id = id;
		}
		public String getUserName() {
			return username;
		}
		public void setUserName(String userName) {
			this.username = userName;
		}
		public String getPw() {
			return passwrd;
		}
		public void setPw(String pw) {
			this.passwrd = pw;
		}
		public String getFirstName() {
			return first_name;
		}
		public void setFirstName(String firstName) {
			this.first_name = firstName;
		}
		public String getLastName() {
			return last_name;
		}
		public void setLastName(String lastName) {
			this.last_name = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
		
		
		
		
		
		
		public RevNoteUser() {
			super();
		}
		@Override
		public int hashCode() {
			return Objects.hash(first_name, user_id, last_name, passwrd, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RevNoteUser other = (RevNoteUser) obj;
			return Objects.equals(first_name, other.first_name) && Objects.equals(user_id, other.user_id)
					&& Objects.equals(last_name, other.last_name) && Objects.equals(passwrd, other.passwrd)
					&& Objects.equals(username, other.username);
		}
		
		
		
		public void addNewNote(Note note) {
			userNotes.add(note);
		}
		public void removeNote(Note note) {
			userNotes.remove(note);
		}
		public static RevNoteUser from(UserDTO userDTO) {
			RevNoteUser user = new RevNoteUser();
			user.setUser_id(userDTO.getUser_id());
			user.setFirstName(userDTO.getFirst_name());
			user.setLastName(userDTO.getLast_name());
			user.setUserName(userDTO.getUserName());
			user.setPw(userDTO.getPasswrd());
			user.setEmail(userDTO.getEmail());
			user.setImgURL(userDTO.getImgurl());
			return user;
			
		}
	}

