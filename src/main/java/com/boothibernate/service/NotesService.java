package com.boothibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boothibernate.model.Note;
import com.boothibernate.model.Response;

@Service
public interface NotesService {

	public List<Note> getAllNotes();

	public Response createNote(Note note);

	public Response updateNote(Note note);

	public Response deleteNote(long id);

	Note getNoteById(long id);

}
