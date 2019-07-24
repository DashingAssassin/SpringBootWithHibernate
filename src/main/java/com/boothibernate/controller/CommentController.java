package com.boothibernate.controller;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boothibernate.model.Comment;
import com.boothibernate.model.Response;
import com.boothibernate.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping(value = { "/comments/{topicId}" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public List<Comment> getCommentByTopicId(@PathVariable("topicId") long topicId) {
		return this.commentService.getCommentsByTopicId(topicId);
	}

	@PostMapping(value = { "/addComments" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Response addComment(@RequestBody Comment comment) {
		Comment result = this.commentService.addComments(comment);
		if(Objects.isNull(result)) {
			return createResponse(500, "Cannot Add the entity due to error");
		}
		
		return createResponse(200, "Entity Created Successfully");
	}

	private Response createResponse(int code, String message) {
		return new Response(code, message);
	}

}
