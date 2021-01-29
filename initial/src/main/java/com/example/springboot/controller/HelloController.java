package com.example.springboot.controller;

import com.example.springboot.dto.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/{id}")
	public String getUser(@PathVariable long id ) {
		return "Greetings from " + userService.getUser(id).getUsername();
	}

	@PostMapping("/login")
	public User authenticate(@RequestBody User user){
		user.setStatus(userService.authorize(user));
		return user;
	}

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

}
