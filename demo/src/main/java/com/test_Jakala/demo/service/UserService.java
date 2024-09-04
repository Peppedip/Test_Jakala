package com.test_Jakala.demo.service;

import com.test_Jakala.demo.model.User;
import com.test_Jakala.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

	public User updateUser(Long id, @Valid User userDetails) {
		
		 User user = getUserById(id);
	        user.setName(userDetails.getName());
	        user.setEmail(userDetails.getEmail());
	        return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		
		User user = getUserById(id);
        userRepository.delete(user);
	}
}
