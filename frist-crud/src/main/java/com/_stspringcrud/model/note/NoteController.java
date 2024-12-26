package com._stspringcrud.model.note;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNote(@RequestBody Note newNote) {
        return noteService.createNote(newNote);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.FOUND);
    }
    
    
}
