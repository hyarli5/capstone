package com.perscholas.PersonalExpenses.repository;

//import java.time.LocalDate;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.perscholas.PersonalExpenses.entity.Category;
import com.perscholas.PersonalExpenses.entity.Expense;
//import com.perscholas.PersonalExpenses.entity.Income;
//import com.perscholas.PersonalExpenses.entity.Report;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// List<Expense> findByReport(Report report);
	// List<Expense> findByCategory(Category category);

	// List<Income> findByUserId(Long userId);

	// List<Expense> findByDateofExpenseBetween(LocalDate startDate, LocalDate
	// endDate);

}
