package com.waffle.todolist.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteDetailRepository noteDetailRepository;

    @Transactional
    public NoteEntity insertNote(String title) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setTitle(title);
        return noteRepository.save(noteEntity);
    }

    @Transactional
    public NoteEntity updateNote(long id, String title) {
        NoteEntity noteEntity = getNoteById(id);
        noteEntity.setTitle(title);
        return  noteEntity;
    }

    @Transactional
    public void deleteNoteById(long id){
        noteRepository.deleteById(id);
    }

    public NoteEntity getNoteById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Iterable<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    @Transactional
    public NoteDetailEntity insertNoteDetail(long noteId, NoteDetailEntity noteDetailEntity) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(noteId);
        noteDetailEntity.setNote(noteEntity);
        noteDetailEntity.setDone(false);
        return noteDetailRepository.save(noteDetailEntity);
    }

    public Iterable<NoteDetailEntity> getNoteDetails(long noteId) {
        return noteDetailRepository.findByNoteId(noteId);
    }
}
