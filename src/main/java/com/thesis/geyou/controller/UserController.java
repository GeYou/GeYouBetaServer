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

import com.thesis.geyou.entity.User;
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
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public User createUser(@RequestBody User u) {
		System.out.println("User object: " + u);

		return userService.createUser(u);
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public int deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}

	@RequestMapping(value = "/validateEmail", method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean checkEmail(@RequestParam(value = "email") String email) {
		return userService.checkEmail(email);
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User checkCredentials(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		return userService.checkCredentials(email, password);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
	}
	
	@RequestMapping(value = "/getByEmail", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User getUserByEmail(@RequestParam(value = "email") String email) {
		return userService.getByEmail(email);
	}
}