package com.perscholas.PersonalExpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perscholas.PersonalExpenses.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
