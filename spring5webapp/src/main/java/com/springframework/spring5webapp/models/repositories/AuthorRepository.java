package com.springframework.spring5webapp.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5webapp.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	 public Author findOneByFirstNameAndLastName(String firstName, String lastName);
	 public List<Author> findByLastName(String lastName);

}
