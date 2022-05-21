package com.darkmode.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.models.RevNoteUser;
import com.darkmode.models.User;
import com.darkmode.models.dto.UserDTO;
import com.darkmode.service.UserService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users/")
public class UserController {
	private final UserService userService;
	
@Autowired
UserController(UserService userService){
	this.userService = userService;
	
}
@PostMapping
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 

public ResponseEntity<UserDTO> addUser(@RequestBody final UserDTO userDTO){
	RevNoteUser user = userService.addUser(RevNoteUser.from(userDTO));
	return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);


}
@GetMapping
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 

public ResponseEntity<List<UserDTO>> getUsers(){
	List<RevNoteUser> retUsers = userService.getUsers();
	List<UserDTO> retUsersDto = retUsers.stream().map(UserDTO::from).collect(Collectors.toList());
	return new ResponseEntity<>(retUsersDto,HttpStatus.OK);
}
@GetMapping(value= "{id}")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 

public ResponseEntity<UserDTO> getUser(@PathVariable final Long id) {
RevNoteUser user = userService.getUserbyID(id);
return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);
}


@PostMapping(value="{user_id}/notes/{note_id}/add")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

public ResponseEntity<UserDTO> addNotetoUser(@PathVariable final long user_id, 
												@PathVariable final long note_id){
		RevNoteUser user = userService.addNoteToUserNotes(user_id, note_id);
		return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
		
		
	
}
}


