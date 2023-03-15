package com.perscholas.PersonalExpenses.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perscholas.PersonalExpenses.entity.Income;
import com.perscholas.PersonalExpenses.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService {
	Logger log = LoggerFactory.getLogger(IncomeServiceImpl.class);

	@Autowired
	private IncomeRepository incomeRepo;

	@Override
	public List<Income> getAllIncomes() {

		return incomeRepo.findAll();
	}

	@Override
	public Income saveIncome(Income income) {
		// TODO Auto-generated method stub
		if (income.getIncomeAmount() == null) {
			income.setIncomeAmount(BigDecimal.ZERO);
		}
		if (income.getSavingsAmount() == null) {
			income.setSavingsAmount(BigDecimal.ZERO);
		}
		BigDecimal budget = income.getIncomeAmount().subtract(income.getSavingsAmount());
		if (budget.compareTo(BigDecimal.ZERO) < 0) {
			budget = BigDecimal.ZERO;

		}
		income.setBudget(budget);
		return incomeRepo.save(income);
	}

	@Override
	public Income getIncomeById(Long id) {
		// TODO Auto-generated method stub
		return incomeRepo.findById(id).get();
	}

	@Override
	public Income updateIncome(Income income) {

		return incomeRepo.save(income);
	}

	@Override
	public void deleteIncomeById(Long id) {
		incomeRepo.deleteById(id);

	}

	@Override
	public List<Income> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return incomeRepo.findByUserId(userId);
	}

	@Override
	public void updateBudget(BigDecimal cost) {
		BigDecimal totalBudget = getTotalBudget().subtract(cost);
		if (totalBudget.compareTo(BigDecimal.ZERO) < 0) {
			totalBudget = BigDecimal.ZERO;
		}
		List<Income> incomes = getAllIncomes();
		for (Income income : incomes) {
			income.setBudget(income.getIncomeAmount().subtract(income.getSavingsAmount()).subtract(totalBudget));

			incomeRepo.save(income);
		}

	}

	@Override
	public BigDecimal getTotalBudget() {
		List<Income> incomes = getAllIncomes();
		BigDecimal totalBudget = BigDecimal.ZERO;
		for (Income income : incomes) {
			totalBudget = totalBudget.add(income.getBudget());
		}
		return totalBudget;
	}

	@Override
	public BigDecimal getTotalSavings() {
		List<Income> incomes = getAllIncomes();
		BigDecimal totalSavings = BigDecimal.ZERO;
		for (Income income : incomes) {
			totalSavings = totalSavings.add(income.getSavingsAmount());

		}
		return totalSavings;

	}

/*	@Override
	public BigDecimal getTotalIncomeByDate(LocalDate startDate, LocalDate endDate) {
		List<Income> incomes = incomeRepo.findByDateBetween(startDate, endDate);
		BigDecimal total = BigDecimal.ZERO;
		for (Income income : incomes) {
			total = total.add(income.getIncomeAmount());
		}
		return total;
	}  */

	@Override
	public BigDecimal getTotalIncome() {
		List<Income> incomes = incomeRepo.findAll();
		BigDecimal total = BigDecimal.ZERO;
		for (Income income : incomes) {
			total = total.add(income.getIncomeAmount());
		}
		return total;
	}

/*	@Override
	public BigDecimal getTotalBudgetByDate(LocalDate startDate, LocalDate endDate) {
		List<Income> incomes = incomeRepo.findByDateBetween(startDate, endDate);
		BigDecimal totalBudget = BigDecimal.ZERO;
		for (Income income : incomes) {
			totalBudget = totalBudget.add(income.getBudget());
		}
		return totalBudget;
	}*/
}
