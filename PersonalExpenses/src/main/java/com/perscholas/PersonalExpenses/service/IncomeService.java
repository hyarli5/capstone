package com.perscholas.PersonalExpenses.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.perscholas.PersonalExpenses.entity.Income;

public interface IncomeService {

	BigDecimal getTotalIncome();

//	BigDecimal getTotalBudgetByDate(LocalDate startDate, LocalDate endDate);

//	BigDecimal getTotalIncomeByDate(LocalDate startDate, LocalDate endDate);

	List<Income> findByUserId(Long userId);

	List<Income> getAllIncomes();

	Income saveIncome(Income income);

	Income getIncomeById(Long id);

	Income updateIncome(Income income);

	void deleteIncomeById(Long id);

	void updateBudget(BigDecimal cost);

	BigDecimal getTotalBudget();

	BigDecimal getTotalSavings();
}
