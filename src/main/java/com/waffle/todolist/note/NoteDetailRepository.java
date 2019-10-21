package com.waffle.todolist.note;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDetailRepository extends PagingAndSortingRepository<NoteDetailEntity, Long> {
    List<NoteDetailEntity> findByNoteId(long noteId);
}
