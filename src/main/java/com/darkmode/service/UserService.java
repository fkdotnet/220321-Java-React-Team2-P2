/*This is a service class for the User Domain MODEL. This Class accesses the user CRUD Repository  
 * (included with Spring MVC) as a microservices platform to perform Database operations, the 
 * the common CRUD (Create,Read,Update,Delete) are included */


package com.darkmode.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmode.models.Note;
import com.darkmode.models.RevNoteUser;
import com.darkmode.models.exception.NoteAlreadyAssignedException;
import com.darkmode.models.exception.UserNotFoundException;
import com.darkmode.repositories.RevNoteUserRepository;

@Service
public class UserService {
private final RevNoteUserRepository userRepository;
private final noteService NoteService;
				
	@Autowired
	public UserService(RevNoteUserRepository userRepository, noteService NoteService){
	this.userRepository = userRepository;
	this.NoteService = NoteService; 
}
	
	public RevNoteUser addUser(RevNoteUser user) {
		return userRepository.save(user);
	}
	
	public List<RevNoteUser> getUsers(){
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public RevNoteUser getUserbyID(long id) {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	public RevNoteUser deleteUser(long id) {
		RevNoteUser user = getUserbyID(id);
		userRepository.delete(user);
		return user;
	}
	@Transactional
	public RevNoteUser addNoteToUserNotes(long user_id,long note_id) {
		RevNoteUser user = getUserbyID(user_id);
		Note note = NoteService.getNotebyID(note_id);
		if(Objects.nonNull(note.getUser())){throw new NoteAlreadyAssignedException(note_id,note.getUser().getId());
		}
		user.addNewNote(note);
		note.setUser(user);
		return user;
	}
	@Transactional
	public RevNoteUser deleteNote(long user_id, long note_id) {
		RevNoteUser user = getUserbyID(user_id);
		Note note = NoteService.getNotebyID(note_id);
		user.removeNote(note);
		return user;
		
		}
}
