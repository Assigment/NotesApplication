package org.gotprint.repositories;

import org.gotprint.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
	
	Note findByNoteId(final Long noteId);

}
