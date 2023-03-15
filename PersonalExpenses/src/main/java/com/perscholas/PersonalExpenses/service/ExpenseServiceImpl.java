package com.perscholas.PersonalExpenses.service;

//import java.math.BigDecimal;
//import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.entity.Expense;
//import com.perscholas.PersonalExpenses.entity.Income;
//import com.perscholas.PersonalExpenses.entity.Report;
import com.perscholas.PersonalExpenses.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	Logger log = LoggerFactory.getLogger(ExpenseServiceImpl.class);

	@Autowired
	private ExpenseRepository expenseRepo;

	public ExpenseServiceImpl(ExpenseRepository expenseRepo) {
		super();
		this.expenseRepo = expenseRepo;
	}

	@Override
	public List<Expense> getAllExpenses() {

		return expenseRepo.findAll();
	}

	@Override
	public Expense saveExpense(Expense expense) {

		return expenseRepo.save(expense);
	}

	@Override
	public Expense getExpenseById(Long id) {

		return expenseRepo.findById(id).get();
	}

	@Override
	public Expense updateExpense(Expense expense) {

		return expenseRepo.save(expense);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);

	}

	@Override
	public List<Expense> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<Income> findByUserId(Long userId) {

		return expenseRepo.findByUserId(userId);
	}

	@Override
	public BigDecimal getTotalExpenseByDate(LocalDate startDate, LocalDate endDate) {
		List<Expense> expenses = expenseRepo.findByDateofExpenseBetween(startDate, endDate);
		BigDecimal totalExpense = BigDecimal.ZERO;
		for (Expense expense : expenses) {
			totalExpense = totalExpense.add(expense.getCost());
		}
		return totalExpense;
	}*/

	/*
	 * @Override public List<Expense> getExpensesByReport(Report report) {
	 * 
	 * return expenseRepo.findByReport(report); }
	 */

}
