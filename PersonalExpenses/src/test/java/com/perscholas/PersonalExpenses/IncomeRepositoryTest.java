package com.perscholas.PersonalExpenses;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.perscholas.PersonalExpenses.entity.Income;
import com.perscholas.PersonalExpenses.repository.IncomeRepository;

public class IncomeRepositoryTest {
	@Autowired
	private IncomeRepository incomeRepotest;
	
	@Test
	public void testfindByUserId(Long userId)
	{
		final Long ID1 = (long) 10;
		
		List<Income> actualIncome = incomeRepotest.findByUserId(ID1);
		
		Assertions.assertNotNull(actualIncome);
		
	}

}
