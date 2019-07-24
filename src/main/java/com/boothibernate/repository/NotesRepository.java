package com.boothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boothibernate.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

}
