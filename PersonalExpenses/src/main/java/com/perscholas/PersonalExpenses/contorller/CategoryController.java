package com.perscholas.PersonalExpenses.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.service.CategoryService;
import com.perscholas.PersonalExpenses.service.CategoryServiceImpl;

@Controller
public class CategoryController {
	Logger log = LoggerFactory.getLogger(CategoryController.class);
	private CategoryService categoryServ;

	public CategoryController(CategoryService categoryServ) {
		super();
		this.categoryServ = categoryServ;
	}

	// handler method to handle list students and return model and view

	@GetMapping("/categories")
	public String listCategories(Model model) {
		log.info("listCategories is called from controller");
		model.addAttribute("categories", categoryServ.getAllCategories());
		
		return "categories";
	}

	@GetMapping("/categories/new")
	public String createCategoryForm(Model model) {
		// create Category object to hold category form data
		Category category = new Category();
		model.addAttribute("category", category);
		return "create_category";
	}

	@PostMapping("/categories")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryServ.saveCategory(category);
		return "redirect:/categories";
	}

	// handler to handle update

	@GetMapping("/categories/edit/{id}")
	public String editCategory(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryServ.getCategoryById(id));
		return "edit_category";

	}

	@PostMapping("/categories/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("category") Category category, Model model) {
		// get category from database by id
		Category existingCategory = categoryServ.getCategoryById(id);
		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setDescription(category.getDescription());
		// existingCategory.SetTotalExpense(category.getTotalExpense());
		// existingCategory.setCreationDate(null);
		existingCategory.setId(id);

		// save updated Category Object
		categoryServ.updateCategory(existingCategory);
		return "redirect:/categories";

	}

	// handler method to handle delete category request

	@GetMapping("/categories/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryServ.deleteCategoryById(id);
		return "redirect:/categories";
	}

}
