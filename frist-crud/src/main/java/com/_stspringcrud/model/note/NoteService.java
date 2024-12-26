package com._stspringcrud.model.note;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public ResponseEntity<Object> createNote(Note note) {
        noteRepository.save(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    public List<Note> getAllNote() {
        List<Note> notes = noteRepository.findAll();
        return notes;
    }
}
