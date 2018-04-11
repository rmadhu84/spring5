package com.springframework.spring5webapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5webapp.models.Authors;

public interface AuthorsRepository extends CrudRepository<Authors, Long> {

}
