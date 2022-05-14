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

import com.darkmode.UserRepository;
import com.darkmode.models.Note;
import com.darkmode.models.User;
import com.darkmode.models.exception.NoteAlreadyAssignedException;
import com.darkmode.models.exception.UserNotFoundException;

@Service
public class UserService {
private final UserRepository userRepository;
				noteService NoteService;
	@Autowired
	public UserService(UserRepository userRepository) {
	
	this.userRepository = userRepository;
}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public User getUserbyID(long id) {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	public User deleteUser(long id) {
		User user = getUserbyID(id);
		userRepository.delete(user);
		return user;
	}
	@Transactional
	public User addNoteToUserNotes(long user_id,long note_id) {
		User user = getUserbyID(user_id);
		Note note = NoteService.getNotebyID(note_id);
		if(Objects.nonNull(note.getUser())){throw new NoteAlreadyAssignedException(note_id,note.getUser().getId());
		}
		user.addNewNote(note);
		note.setUser(user);
		return user;
	}
	@Transactional
	public User deleteNote(long user_id, long note_id) {
		User user = getUserbyID(user_id);
		Note note = NoteService.getNotebyID(note_id);
		user.removeNote(note);
		return user;
		
		}
}
