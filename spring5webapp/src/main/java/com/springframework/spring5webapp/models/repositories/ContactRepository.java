package com.springframework.spring5webapp.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5webapp.models.ContactDto;

public interface ContactRepository extends CrudRepository<ContactDto, Long>{

}
