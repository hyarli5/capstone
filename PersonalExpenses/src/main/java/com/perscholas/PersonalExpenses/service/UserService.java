package com.perscholas.PersonalExpenses.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.perscholas.PersonalExpenses.entity.User;
import com.perscholas.PersonalExpenses.repository.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	User save(UserRegistrationDto registration);

}
