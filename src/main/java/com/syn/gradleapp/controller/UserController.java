package com.syn.gradleapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syn.gradleapp.model.User;
import com.syn.gradleapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/{id}")
	public Optional<User> get(@PathVariable("id") Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping()
	public List<User> gets() {
		return userService.getAllUser();
	}

	@PostMapping()
	public User add(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/{id}")
	public User put(@PathVariable("id") Integer id, @RequestBody User user) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return "User deleted";
	}
	
	@RequestMapping("/name")
	public User getUserByName(@RequestParam("name") String name) {
		return userService.getUserByName(name);
	}
}
