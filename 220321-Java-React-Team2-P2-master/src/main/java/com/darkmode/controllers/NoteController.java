package com.darkmode.controllers;
///cors enabled
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkmode.models.Note;
import com.darkmode.models.RevNoteUser;
import com.darkmode.models.dto.NoteDTO;
import com.darkmode.service.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/notes")
public class NoteController {
private final noteService NoteService;

@Autowired
public NoteController(noteService NoteService){
	this.NoteService = NoteService;

	
	
}
@PostMapping
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 
public ResponseEntity<NoteDTO> addNote(@RequestBody final NoteDTO noteDTO){
	Note note = NoteService.addNote(Note.from(noteDTO));
	return new ResponseEntity<>(NoteDTO.from(note),HttpStatus.OK);
	
}
	
@DeleteMapping("{noteid}")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 
public ResponseEntity<NoteDTO> deleteItem(@PathVariable final long noteid){
	Note note = NoteService.deleteNote(noteid);
	return new ResponseEntity<>(NoteDTO.from(note),HttpStatus.OK);
}
@GetMapping("/byUser/{user_id}")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 
public ResponseEntity <List<NoteDTO>> getAllByUser_ID(@PathVariable final long user_id) {
	List<Note> retNotes = NoteService.getNotesbyUserID(user_id);
	List<NoteDTO> retNoteDTO = retNotes.stream().map(NoteDTO::from).collect(Collectors.toList());
	return new ResponseEntity<>(retNoteDTO,HttpStatus.OK);
	
}
	
@PutMapping("{id}")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public ResponseEntity <NoteDTO> updateItem(@PathVariable final long id, @RequestBody NoteDTO noteDTO){
		Note note = NoteService.editNote(id, Note.from(noteDTO));
		return new ResponseEntity<NoteDTO>(NoteDTO.from(note),HttpStatus.OK);
}


@GetMapping()
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public ResponseEntity <List<NoteDTO>> getAll(){
		List <Note> retNotes = NoteService.getNotes();
		List<NoteDTO> retNoteDTO = retNotes.stream().map(NoteDTO::from).collect(Collectors.toList());

		return new ResponseEntity<>(retNoteDTO,HttpStatus.OK);}


@GetMapping("{id}")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public ResponseEntity <NoteDTO> getByID(@PathVariable final long id){
		Note retNotes = NoteService.getNotebyID(id);
		
		return new ResponseEntity<>(NoteDTO.from(retNotes),HttpStatus.OK);
}

}


