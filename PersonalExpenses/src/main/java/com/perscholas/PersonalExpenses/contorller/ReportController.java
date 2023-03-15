package com.perscholas.PersonalExpenses.contorller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perscholas.PersonalExpenses.service.ReportService;

@Controller
public class ReportController {
	Logger log = LoggerFactory.getLogger(ReportController.class);

/*	@Autowired
	private IncomeService incomeServ;

	@Autowired
	private ExpenseService expenseServ;*/

	@Autowired
	private ReportService reportServ;

	@GetMapping("/report")
	public String getReport(Model model) {
		log.info("listReport is called from controller");
	//	model.addAttribute("report", new Report());
	//	model.addAttribute("incomes", incomeServ.getAllIncomes());
	//	model.addAttribute("expenses", expenseServ.getAllExpenses());
	//	model.addAttribute("totalBudget", incomeServ.getTotalBudget());
		return "report";
	}

/*	@PostMapping("/report")
	public String generateReport(@ModelAttribute("report") Report report, Model model) {
		//BigDecimal totalIncome = incomeServ.getTotalIncomeByDate(report.getStartDate(), report.getEndDate());
		// BigDecimal totalExpense =
		// expenseServ.getTotalExpenseByDate(report.getStartDate(),
		// report.getEndDate());
	/*	BigDecimal totalBudget = incomeServ.getTotalBudgetByDate(report.getStartDate(), report.getEndDate());
		String chartColor = getChartColor(totalBudget);
		report.setTotalIncome(totalIncome);
		// report.setTotalExpenses(totalExpense);
		report.setTotalBudget(totalBudget);
		report.setChartColor(chartColor);
		reportServ.saveReport(report);
		model.addAttribute("incomes", incomeServ.getAllIncomes());
		model.addAttribute("expenses", expenseServ.getAllExpenses());
		model.addAttribute("totalBudget", incomeServ.getTotalBudget());
		return "reports";
	}*/

	private String getChartColor(BigDecimal totalBudget) {
		if (totalBudget.compareTo(BigDecimal.valueOf(2000.0)) <= 0) {
			return "red";
		} else if (totalBudget.compareTo(BigDecimal.valueOf(5000.0)) <= 0) {
			return "yellow";

		} else {
			return "green";
		}
	}
}
