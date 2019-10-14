package com.waffle.todolist.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public NoteEntity insertNote(@RequestBody NoteEntity note) {
        return noteService.insertNote(note.getTitle());
    }

    @GetMapping
    public Iterable<NoteEntity> getAllNotes() {
        return noteService.getAllNotes();
    }
}
