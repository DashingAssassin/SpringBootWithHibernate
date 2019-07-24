package com.boothibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boothibernate.model.Topic;

@Service
public interface TopicService {

	public List<Topic> getTopics();

	public Topic createTopic(Topic topic);

}
