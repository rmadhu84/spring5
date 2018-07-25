package com.springframework.spring5webapp.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5webapp.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
