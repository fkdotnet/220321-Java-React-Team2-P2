package com.darkmode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darkmode.models.*;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long> {

}
