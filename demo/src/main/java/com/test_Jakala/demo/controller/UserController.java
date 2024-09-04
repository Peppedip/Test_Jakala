package com.test_Jakala.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_Jakala.demo.model.User;
import com.test_Jakala.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	    private final UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping
	    public User createUser(@RequestBody @Valid User user) {
	        return userService.createUser(user);
	    }

	    @GetMapping("/{id}")
	    public User getUser(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }
	    
	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
	        return userService.updateUser(id, user);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }

}
