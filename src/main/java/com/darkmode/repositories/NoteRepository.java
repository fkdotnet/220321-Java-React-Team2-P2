package com.darkmode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darkmode.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long> {
@Query( value = "SELECT n FROM Note n WHERE n.user.user_id= ?1")
List <Note> findUsersNote(long user_id);
}