package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		User user = null;
		try {
			user = this.userService.getUser(userId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(),
				List.class);
		user.setContacts(contacts);

		return user;

	}

	@PostMapping("/post")
	public ResponseEntity addUser(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result.getFieldErrors().iterator().next().getDefaultMessage());
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		try {
			userService.updateUser(user);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
