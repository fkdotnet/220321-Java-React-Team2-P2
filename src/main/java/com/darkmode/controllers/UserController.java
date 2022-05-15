package com.darkmode.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.models.User;
import com.darkmode.models.dto.UserDTO;
import com.darkmode.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserController {
	private final UserService userService;
	
@Autowired
UserController(UserService userService){
	this.userService = userService;
	
}
@PostMapping
public ResponseEntity<UserDTO> addUser(@RequestBody final UserDTO userDTO){
	User user = userService.addUser(User.from(userDTO));
	return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);


}
@GetMapping
public ResponseEntity<List<UserDTO>> getUsers(){
	List<User> retUsers = userService.getUsers();
	List<UserDTO> retUsersDto = retUsers.stream().map(UserDTO::from).collect(Collectors.toList());
	return new ResponseEntity<>(retUsersDto,HttpStatus.OK);
}
@GetMapping(value= "{id}")
public ResponseEntity<UserDTO> getUser(@PathVariable final Long id) {
User user = userService.getUserbyID(id);
return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);
}

	
}


