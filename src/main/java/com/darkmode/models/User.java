	package com.darkmode.models;

	import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {



		private @Id @GeneratedValue Long user_id;
		private String userName;
		private String pw;
		private String firstName;
		private String lastName;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="user_id")
		private List<Note> userNotes = new ArrayList<>();
		public Long getId() {
			return user_id;
		}
		public void setId(Long id) {
			this.user_id = id;
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
		public User() {
			super();
		}
		@Override
		public int hashCode() {
			return Objects.hash(firstName, user_id, lastName, pw, userName);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(firstName, other.firstName) && Objects.equals(user_id, other.user_id)
					&& Objects.equals(lastName, other.lastName) && Objects.equals(pw, other.pw)
					&& Objects.equals(userName, other.userName);
		}
		
		
		
		public void addNewNote(Note note) {
			userNotes.add(note);
		}
		public void removeNote(Note note) {
			userNotes.remove(note);
		}
		
	}

