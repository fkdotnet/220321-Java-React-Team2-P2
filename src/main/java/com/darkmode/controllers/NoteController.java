package com.darkmode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.models.dto.NoteDTO;
import com.darkmode.service.*;
@RestController
@RequestMapping("/notes")
public class NoteController {
private final noteService NoteService;

@Autowired
public NoteController(noteService NoteService){
	this.NoteService = NoteService;
	
	
}
@PostMapping
public ResponseEntity<NoteDTO> addNote(@RequestBody final NoteDTO noteDTO){
	return null;
	
}
	
	
}
