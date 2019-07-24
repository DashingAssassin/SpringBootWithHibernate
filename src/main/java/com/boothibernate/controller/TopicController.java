package com.boothibernate.controller;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boothibernate.model.Response;
import com.boothibernate.model.Topic;
import com.boothibernate.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping(value = { "/getTopics" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public List<Topic> getTopics() {
		return this.topicService.getTopics();
	}

	@PostMapping(value = { "/createTopic" }, produces = { MediaType.APPLICATION_JSON }, consumes = {
			MediaType.APPLICATION_JSON })
	public Response createTopic(@RequestBody Topic topic) {
		Topic result= this.topicService.createTopic(topic);
		if(Objects.isNull(result)) {
			return createResponse(500, "Cannot Add the entity due to error");
		}
		return createResponse(200, "Entity Created Successfully");
	}
	
	private Response createResponse(int code, String message) {
		return new Response(code, message);
	}
}
