package com.boothibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boothibernate.model.Topic;
import com.boothibernate.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getTopics() {
		return this.topicRepository.findAll();
	}

	@Override
	public Topic createTopic(Topic topic) {
		return this.topicRepository.save(topic);

	}

}
