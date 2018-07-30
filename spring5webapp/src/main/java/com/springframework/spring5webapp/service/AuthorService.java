package com.springframework.spring5webapp.service;

import java.util.List;

import com.springframework.spring5webapp.dto.AuthorDto;


public interface AuthorService {
	public List<AuthorDto>  getAllAuthors();
	public AuthorDto getAuthorByName(String firstName, String lastName);
	public List<AuthorDto> getAuthorByLastName(String lastName);

}
