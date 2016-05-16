package org.gotprint.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.gotprint.exception.NoteNotFoundException;
import org.gotprint.model.Note;
import org.gotprint.model.User;
import org.gotprint.repositories.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usernotes")
public class NoteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteRepository noteRepository;

	// -------------------Create a
	// Note--------------------------------------------------------

	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public ResponseEntity<Void> createNote(@RequestBody Note note,
			UriComponentsBuilder ucBuilder) {
		LOGGER.info("Creating Note " + note.getTitle());
		noteRepository.save(note);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/note/{id}")
				.buildAndExpand(note.getNoteId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Note 
	// --------------------------------------------------------

	@RequestMapping(value = "/note/{noteId}", method = RequestMethod.PUT)
	public ResponseEntity<Note> updateNote(@PathVariable("noteId") long noteId,
			@RequestBody Note note) {
		LOGGER.info("Updating Note " + noteId);

		Note currentNote = noteRepository.findByNoteId(noteId);

		if (currentNote == null) {
			System.out.println("Note with id " + noteId + " not found");
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}

		currentNote.setTitle(note.getTitle());
		currentNote.setNoteText(note.getNoteText());
		currentNote.setLastUpdatedTime(getConvertedDateFormat(new Date()));

		noteRepository.save(currentNote);
		return new ResponseEntity<Note>(currentNote, HttpStatus.OK);
	}

	// ------------------- Delete a Note
	// --------------------------------------------------------

	@RequestMapping(value = "/note/{noteId}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteNote(@PathVariable("noteId") long noteId) {
		LOGGER.info("Fetching & Deleting Note with noteId " + noteId);

		Note note = noteRepository.findByNoteId(noteId);
		if (note == null) {
			System.out.println("Unable to delete. Note with id " + noteId
					+ " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		noteRepository.delete(noteId);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Note
	// --------------------------------------------------------

	@RequestMapping(value = "/note/", method = RequestMethod.DELETE)
	public ResponseEntity<Note> deleteAllNotes() {
		LOGGER.info("Deleting All Notes");

		noteRepository.deleteAll();
		return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
	}
	
	// ------------------- Get a Note 
	// --------------------------------------------------------

	@RequestMapping(value = "/note/{noteId}", method = RequestMethod.GET)
	public ResponseEntity<Note> getNote(@PathVariable("noteId") long noteId) throws NoteNotFoundException {
		LOGGER.info("Getting Note " + noteId);

		Note currentNote = noteRepository.findByNoteId(noteId);

		if (currentNote == null) {
			System.out.println("Note with id " + noteId + " not found");
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Note>(currentNote, HttpStatus.OK);
	}
	
	
    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFoundException(NoteNotFoundException ex) {
        LOGGER.debug("handling 404 error on a Note entry");
    }
    
    /** 
     * @param date
     * @return
     */
    public String getConvertedDateFormat(Date date)
    {
    	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        
        //to convert Date to String, use format method of SimpleDateFormat class.
        
        return dateFormat.format(date);
    }

}
