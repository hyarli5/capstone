package com.perscholas.PersonalExpenses.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perscholas.PersonalExpenses.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {

	List<Income> findByUserId(Long userId);

	// List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
