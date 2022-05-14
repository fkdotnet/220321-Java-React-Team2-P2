package com.darkmode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserController {
	private final UserService userService;
	
@Autowired
UserController(UserService userService){
	this.userService = userService;
	
}

}
