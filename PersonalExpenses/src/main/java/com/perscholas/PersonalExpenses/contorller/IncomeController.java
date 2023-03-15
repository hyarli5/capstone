package com.perscholas.PersonalExpenses.contorller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.PersonalExpenses.entity.Income;
import com.perscholas.PersonalExpenses.service.IncomeService;

@Controller
public class IncomeController {
	Logger log = LoggerFactory.getLogger(IncomeController.class);

	private IncomeService incomeServ;

	public IncomeController(IncomeService incomeServ) {
		
		super();
		this.incomeServ = incomeServ;
	}

	// handler method to handle list of incomes and return model and view

	@GetMapping("/incomes")
	public String listIncomes(Model model) {
		log.info("listIncomes is called from controller");
		model.addAttribute("incomes", incomeServ.getAllIncomes());
		return "incomes";

	}

	@GetMapping("/incomes/new")
	public String createIncomeForm(Model model) {
		// create Income object to hold income data
		Income income = new Income();
		model.addAttribute("income", income);
		return "create_income";
	}

	@PostMapping("/incomes")
	public String saveIncome(@ModelAttribute("income") Income income, Model model) {
		if (income.getIncomeAmount() == null) {
			income.setIncomeAmount(BigDecimal.ZERO);

		}
		if (income.getSavingsAmount() == null) {
			income.setSavingsAmount(BigDecimal.ZERO);

		}
		incomeServ.saveIncome(income);
		model.addAttribute("incomes", incomeServ.getAllIncomes());
		model.addAttribute("totalBudget", incomeServ.getTotalBudget());
		model.addAttribute("totalSavings", incomeServ.getTotalSavings());
		incomeServ.saveIncome(income);
		return "redirect:/incomes";

	}

	// handler for update request

	@GetMapping("/incomes/edit/{id}")
	public String editIncomeForm(@PathVariable Long id, Model model) {
		model.addAttribute("income", incomeServ.getIncomeById(id));
		return "edit_income";
	}

	@PostMapping("/incomes/{id}")
	public String UpdateIncome(@PathVariable Long id, @ModelAttribute("income") Income income, Model model) {
		// get Income from database by id

		Income existingIncome = incomeServ.getIncomeById(id);
		existingIncome.setId(id);
		existingIncome.setIncomeType(income.getIncomeType());
		existingIncome.setIncomeAmount(income.getIncomeAmount());
		existingIncome.setSavingsAmount(income.getSavingsAmount());
		existingIncome.setBudget(income.getBudget());
		existingIncome.setCreatedAt(income.getCreatedAt());

		// save updated income object
		incomeServ.updateIncome(existingIncome);
		return "redirect:/incomes";

	}

	// handler method to handle delete income request

	@GetMapping("/incomes/{id}")
	public String deleteIncome(@PathVariable Long id) {
		incomeServ.deleteIncomeById(id);
		return "redirect:/incomes";
	}

	

}
