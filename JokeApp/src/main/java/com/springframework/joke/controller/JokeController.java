/**
 * 
 */
package com.springframework.joke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.joke.service.JokeService;

/**
 * @author Madhu
 *
 */
@Controller
public class JokeController {
	
	private JokeService jokeService;

	/**
	 * @param jokeService
	 */
	@Autowired
	public JokeController(JokeService jokeService) {
		super();
		this.jokeService = jokeService;
	}

	@RequestMapping({"/", ""})
	public String getQuote(Model model) {
		model.addAttribute("joke", jokeService.getJoke());
		return "chucknorris";
	}
}
