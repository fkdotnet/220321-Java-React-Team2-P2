package com.darkmode.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkmode.models.Note;
import com.darkmode.models.exception.*;
import com.darkmode.repositories.NoteRepository;

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

@Transactional
public Note editNote(long id, Note note) {
	Note noteToEdit = getNotebyID(id);
	noteToEdit.setTitle(note.getTitle());
	noteToEdit.setTextObj(note.getTextObj());
	noteToEdit.setDate_created(note.getDate_created());
	
	return noteToEdit;
	
}
public Note deleteNote(long id, long noteid) {
	Note noteToRem = getNotebyID(id);
	noteRepository.delete(noteToRem);
	return noteToRem;
}

}