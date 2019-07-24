package com.boothibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boothibernate.model.Comment;

@Service
public interface CommentService {

	public List<Comment> getCommentsByTopicId(long id);

	public Comment addComments(Comment comment);

}
