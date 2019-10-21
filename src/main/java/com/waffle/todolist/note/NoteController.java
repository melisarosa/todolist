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

    @PostMapping("/{id}/details")
    public NoteDetailEntity insertNoteDetail(@PathVariable("id") long noteId, @RequestBody NoteDetailEntity noteDetail) {
        return noteService.insertNoteDetail(noteId, noteDetail);
    }

    @GetMapping
    public Iterable<NoteEntity> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}/details")
    public Iterable<NoteDetailEntity> getNoteDetails(@PathVariable("id") long noteId){
        return  noteService.getNoteDetails(noteId);
    }

    @GetMapping("/{id}")
    public NoteEntity getNoteById(@PathVariable("id") long id){
        return noteService.getNoteById(id);
    }

    @PutMapping("/{id}")
    public NoteEntity updateNote(@PathVariable("id") long id, @RequestBody NoteEntity note){
        return noteService.updateNote(id, note.getTitle());
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") long id){
        noteService.deleteNoteById(id);
    }
}
