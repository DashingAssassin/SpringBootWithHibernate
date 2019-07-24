package com.boothibernate.controller;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boothibernate.model.Note;
import com.boothibernate.model.Response;
import com.boothibernate.service.NotesService;

@RestController
public class NotesController {

	@Autowired
	private NotesService notesService;

	@GetMapping(value = { "/getNotes" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public List<Note> getAllNotes() {
		List<Note> notesList = this.notesService.getAllNotes();
		return (null == notesList) ? Collections.emptyList() : notesList;
	}

	@GetMapping(value = { "/getNotes/{id}" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Note getNodeById(@PathVariable("id") long id) {
		return this.notesService.getNoteById(id);
	}

	@PostMapping(value = { "/create" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Response createNote(@RequestBody Note note) {
		return this.notesService.createNote(note);
	}
	@PostMapping(value = { "/update" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Response updateNote(@RequestBody Note note) {
		return this.notesService.updateNote(note);
	}

	@PostMapping(value = { "/delete/{id}" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Response updateNote(@PathVariable("id") long id) {
		return this.notesService.deleteNote(id);
	}

}
