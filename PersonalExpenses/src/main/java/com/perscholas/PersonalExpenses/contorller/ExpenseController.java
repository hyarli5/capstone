package com.perscholas.PersonalExpenses.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.PersonalExpenses.entity.Expense;
import com.perscholas.PersonalExpenses.repository.UserRepository;
import com.perscholas.PersonalExpenses.service.CategoryService;
import com.perscholas.PersonalExpenses.service.ExpenseService;
import com.perscholas.PersonalExpenses.service.IncomeService;

@Controller
public class ExpenseController {
	Logger log = LoggerFactory.getLogger(ExpenseController.class);

	@Autowired
	private ExpenseService expenseServ;
	
	@Autowired
	private IncomeService incomeServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private UserRepository userRepo;

	public ExpenseController(ExpenseService expenseServ) {
		super();
		this.expenseServ = expenseServ;
	}

	// handler method to handle Expenses and return model and view

	@GetMapping("/expenses")
	public String listExpenses(Model model) {
		log.info("listExpenses is called from controller");
		model.addAttribute("expenses", expenseServ.getAllExpenses());
		model.addAttribute("totalBudget", incomeServ.getTotalBudget());
		return "expenses";
	}

	// handler to add data

	@GetMapping("/expenses/new")
	public String createExpenseForm(Model model) {
		// create Expense object to hold expenses data

		Expense expense = new Expense();
		model.addAttribute("expense", expense);
		model.addAttribute("category", categoryServ.getAllCategories());
		return "create_expense";
	}

	@PostMapping("/expenses")
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		/*System.out.println(expense.toString());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = null;
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		     currentUserName = authentication.getName();
		    return currentUserName;
		}
		
		expense.setUser(userRepo.findByEmail(currentUserName));
		expenseServ.saveExpense(expense);*/
		return "redirect:/expenses";
	}

	@GetMapping("/expenses/edit/{id}")
	public String editExpenseForm(@PathVariable Long id, Model model) {

		model.addAttribute("expense", expenseServ.getExpenseById(id));
		return "edit_expense";
	}

	@PostMapping("/expenses/{id}")
	public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense, Model model) {
		// get expense from database by id

		Expense existingExpense = expenseServ.getExpenseById(id);
		existingExpense.setId(id);
		existingExpense.setExpenseName(expense.getExpenseName());
		existingExpense.setExpenseType(expense.getExpenseType());
		existingExpense.setExpenseAmount(expense.getExpenseAmount());
		existingExpense.setDateofExpense(expense.getDateofExpense());

		// save updated expense object

		expenseServ.updateExpense(existingExpense);
		return "redirect:/expenses";
	}

	// handler method to handle delete expense request

	@GetMapping("/expenses/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseServ.deleteExpenseById(id);
		return "redirect:/expenses";
	}

}
