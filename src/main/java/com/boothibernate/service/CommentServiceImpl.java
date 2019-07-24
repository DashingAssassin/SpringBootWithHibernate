package com.boothibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boothibernate.model.Comment;
import com.boothibernate.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getCommentsByTopicId(long id) {
		return this.commentRepository.findAllByTopicId(id);
	}

	@Override
	public Comment addComments(Comment comment) {
		return this.commentRepository.save(comment);
	}

}
