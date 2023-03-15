package com.perscholas.PersonalExpenses.service;

import java.util.List;

import com.perscholas.PersonalExpenses.entity.Category;

public interface CategoryService {

	//List<Category> getAllCategoriesWithTotalExpense();

	List<Category> getAllCategories();

	Category saveCategory(Category category);

	Category getCategoryById(Long id);

	Category updateCategory(Category category);

	void deleteCategoryById(Long id);
}
