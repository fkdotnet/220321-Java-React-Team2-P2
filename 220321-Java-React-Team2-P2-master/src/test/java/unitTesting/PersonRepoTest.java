package unitTesting;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.darkmode.Launcher;
import com.darkmode.controllers.UserController;
import com.darkmode.models.Note;
import com.darkmode.models.RevNoteUser;
import com.darkmode.repositories.NoteRepository;
import com.darkmode.repositories.RevNoteUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertFalse;
 

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Launcher.class)
public class PersonRepoTest {
 
    @Autowired
    private RevNoteUserRepository personRepo;
    
    @Autowired
    private NoteRepository NoteRepo;
 
    @Test
  public void isPersonExitsById() {
        long testid = 11;
    	RevNoteUser person = new RevNoteUser(2,"userame", "password", "jakes", "tests", "jakestests@mail.com", null, null);
        personRepo.save(person);
        Boolean actualResult = personRepo.findById(testid).isPresent();
        assertThat(actualResult).isTrue();
    }
    @Test
    public void notesavTest() {
    	long testid = 5;
    	Note testNote = new Note(testid, "test", "BBOXtesting", "5/23/2022");
    	 NoteRepo.save(testNote);
    	Boolean actualNote = NoteRepo.findById(testid).isPresent();
    	assertThat(actualNote).isTrue();
    }
    @Test
    public void noteTestIntegrity() {
    	long badnumber = 13;
    	Boolean actualNote = NoteRepo.findById(badnumber).isPresent();
    	assertFalse(actualNote);
    }
    
    
    
}