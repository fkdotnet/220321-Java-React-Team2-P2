package com.darkmode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.models.Note;
import com.darkmode.models.RevNoteUser;
import com.darkmode.models.dto.NoteDTO;
import com.darkmode.service.*;
@RestController
@RequestMapping("/notes")
public class NoteController {
private final noteService NoteService;
private final UserService userService;
@Autowired
public NoteController(noteService NoteService){
	this.NoteService = NoteService;
	this.userService = null;
	
	
}
@PostMapping
public ResponseEntity<NoteDTO> addNote(@RequestBody final NoteDTO noteDTO){
	Note note = NoteService.addNote(Note.from(noteDTO));
	return new ResponseEntity<>(NoteDTO.from(note),HttpStatus.OK);
	
}
	
	
}
