package com.boothibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boothibernate.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	public List<Comment> findAllByTopicId(long topicId);
}
