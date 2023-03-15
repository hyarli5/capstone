package com.perscholas.PersonalExpenses.service;

//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.perscholas.PersonalExpenses.entity.Expense;
import com.perscholas.PersonalExpenses.entity.Report;
import com.perscholas.PersonalExpenses.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	@Autowired
	private ReportRepository reportRepo;

//	@Autowired
//	private ExpenseService expenseServ;

	/*
	 * @Override public List<Expense> getExpensesByDateRange(LocalDate startDate,
	 * LocalDate endDate) { List<Expense> expenses = new ArrayList<>(); for (Report
	 * report : reportRepo.findAll()) { if
	 * (report.getStartDate().isAfter(startDate.minusDays(1)) &&
	 * report.getEndDate().isBefore(endDate.plusDays(1))) {
	 * expenses.addAll(report.getExpenses()); }
	 * 
	 * } return expenses; }
	 */

	/*
	 * @Override public List<Report> getAllReports() { List<Report> reports =
	 * reportRepo.findAll(); for (Report report : reports) { List<Expense> expenses
	 * = expenseServ.getExpensesByReport(report); report.setExpenses(expenses); }
	 * return reports; }
	 */

	@Override
	public void saveReport(Report report) {
		reportRepo.save(report);
	}

	@Override
	public List<Report> findAll() {

		return reportRepo.findAll();
	}

}
