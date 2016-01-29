package com.thesis.geyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thesis.geyou.entities.User;
import com.thesis.geyou.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/get/all", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getAllUsers(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return userService.getAll(page, size);
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createUser(@RequestBody User u) {
		System.out.println("User object: " + u);
		userService.createUser(u);
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public int deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}

	@RequestMapping(value = "/validateEmail", method = { RequestMethod.GET })
	public Boolean checkEmail(@RequestParam(value = "email") String email) {
		return userService.checkEmail(email);
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public Boolean checkCredentials(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		return userService.checkCredentials(email, password);
	}
}
