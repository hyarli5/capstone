package com.perscholas.PersonalExpenses.service;

//import java.math.BigDecimal;
//import java.time.LocalDate;
import java.util.List;

import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.entity.Expense;
//import com.perscholas.PersonalExpenses.entity.Income;
//import com.perscholas.PersonalExpenses.entity.Report;

public interface ExpenseService {

	// List<Expense> getExpensesByReport(Report report);

	// BigDecimal getTotalExpenseByDate(LocalDate startDate, LocalDate endDate);

//	List<Income> findByUserId(Long userId);

	List<Expense> findByCategory(Category category);

	List<Expense> getAllExpenses();

	Expense saveExpense(Expense expense);

	Expense getExpenseById(Long id);

	Expense updateExpense(Expense expense);

	void deleteExpenseById(Long id);
}
