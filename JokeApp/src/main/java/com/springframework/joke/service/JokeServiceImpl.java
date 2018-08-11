/**
 * 
 */
package com.springframework.joke.service;

import org.springframework.stereotype.Service;

import com.springframework.joke.service.JokeService;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

/**
 * @author Madhu
 *
 */
@Service
public class JokeServiceImpl implements JokeService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;
	
	public JokeServiceImpl() {
		super();
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}

	@Override
	public String getJoke() {
		// TODO Auto-generated method stub
		return chuckNorrisQuotes.getRandomQuote();
	}

}
