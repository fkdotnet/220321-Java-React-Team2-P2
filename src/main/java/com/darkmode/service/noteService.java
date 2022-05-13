package com.darkmode.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmode.NoteRepository;
import com.darkmode.models.Note;
import com.darkmode.models.exception.*;

@Service
public class noteService {
	private final NoteRepository noteRepository;
@Autowired
public noteService(NoteRepository noteRepository) {
	this.noteRepository = noteRepository;

}
public Note addNote (Note note) {
	return noteRepository.save(note);
}
public List<Note> getNotes(){
	return StreamSupport
			.stream(noteRepository.findAll().spliterator(), false)
			.collect(Collectors.toList());
	
	
}
public Note getNotebyID(long id) {
	return noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
}

}