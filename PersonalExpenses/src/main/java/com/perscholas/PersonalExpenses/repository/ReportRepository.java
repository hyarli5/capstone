package com.perscholas.PersonalExpenses.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.PersonalExpenses.entity.Expense;
import com.perscholas.PersonalExpenses.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

	// List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate);

	List<Report> findAll();

}
