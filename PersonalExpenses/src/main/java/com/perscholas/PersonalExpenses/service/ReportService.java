package com.perscholas.PersonalExpenses.service;

import java.time.LocalDate;
import java.util.List;

import com.perscholas.PersonalExpenses.entity.Expense;
import com.perscholas.PersonalExpenses.entity.Report;

public interface ReportService {
	
	//List<Report> getAllReports();

	List<Report> findAll();
//	List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate);

	void saveReport(Report report);
}
