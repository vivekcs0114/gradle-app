package com.syn.gradleapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.syn.gradleapp.model.User;
import com.syn.gradleapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public Optional<User> getUser(int id) {
		return repository.findById(id);
	}

	public List<User> getAllUser() {
		return repository.findAll();
	}

	public User addUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user, int id) {
		User dbUser = repository.getOne(id);
		if (!StringUtils.isEmptyOrWhitespaceOnly(user.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(user.getName())) {
			dbUser.setName(user.getName());
		}
		return repository.save(dbUser);
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}

	public User getUserByName(String name) {
		return repository.getUserByName(name);
	}
}
