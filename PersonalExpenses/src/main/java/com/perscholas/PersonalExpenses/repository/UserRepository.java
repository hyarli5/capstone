package com.perscholas.PersonalExpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.PersonalExpenses.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	 User findByEmail(String email);
}
