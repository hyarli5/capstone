package com.perscholas.PersonalExpenses.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryRepository categoryRepo;

	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<Category> getAllCategories() {
		log.info("getAllCategories is called");

		return categoryRepo.findAll();
	}

	@Override
	public Category saveCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(Long id) {

		return categoryRepo.findById(id).get();
	}

	@Override
	public Category updateCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepo.deleteById(id);

	}

	/*
	 * @Override public List<Category> getAllCategoriesWithTotalExpense() {
	 * List<Category> categories = categoryRepo.findAll();
	 * categories.forEach(category ->
	 * category.SetTotalExpense(category.getTotalExpense())); return categories; }
	 */

}
