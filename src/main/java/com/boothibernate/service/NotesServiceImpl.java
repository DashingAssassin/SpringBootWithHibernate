package com.boothibernate.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.boothibernate.exception.RepositoryException;
import com.boothibernate.model.Note;
import com.boothibernate.model.Response;
import com.boothibernate.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	private static final List<Note> EMPTY_LIST = Collections.emptyList();

	Logger logger = LoggerFactory.getLogger(NotesServiceImpl.class.toString());

	@Override
	public List<Note> getAllNotes() {
		try {
			logger.debug("Starting to get all Notes");
			List<Note> notes = this.notesRepository.findAll();
			logger.debug("Ending to get all Notes");
			return Optional.ofNullable(notes).isPresent() ? notes : EMPTY_LIST;
		} catch (Exception e) {
			logger.debug("Error Occurred");
			throw new RepositoryException(e);
		}
	}

	@Override
	public Response createNote(Note note) {
		Response response = null;
		try {
			logger.debug("Starting creating of Note note");
			this.notesRepository.save(note);
			logger.debug("End creating of Note note");
			response = new Response(200, "Operation Insert Completed Successfully");
		} catch (Exception e) {
			logger.debug("Error Occurred" + e.getMessage());
			response = new Response(500, "Operation Insert Failed due to techinical Difficulties");
		}
		return response;
	}

	@Override
	public Note getNoteById(long id) {
		Optional<Note> note = Optional.empty();
		try {
			note = this.notesRepository.findById(id);
		} catch (Exception e) {
			logger.debug("Exception occurred" + e.getMessage());
		}
		return note.isPresent() ? note.get() : null;
	}

	@Override
	public Response updateNote(Note note) {
		Response response = null;
		try {
			this.notesRepository.save(note);
			response = new Response(200, "Updating of entity is succesfull");
		} catch (Exception e) {
			logger.debug("Exception Occurred" + e.getMessage());
			response = new Response(500, "Error Occurred while updating the entity");
		}
		return response;
	}

	@Override
	public Response deleteNote(long id) {
		Response response = null;
		try {
			this.notesRepository.deleteById(id);
			response = new Response(200, "Delete  of entity is succesfull");
		} catch (Exception e) {
			logger.debug("Exception Occurred" + e.getMessage());
			response = new Response(500, "Error Occurred while deleting the entity");
		}
		return response;
	}

}
