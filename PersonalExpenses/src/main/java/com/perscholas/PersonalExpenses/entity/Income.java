package com.perscholas.PersonalExpenses.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incomes")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IncomeName", nullable = false)
	private String incomeType;

	@Column(name = "Amount", nullable = false)
	private BigDecimal incomeAmount;

	@Column(name = "Savings")
	private BigDecimal savingsAmount;

	@Column(name = "Budget", nullable = false)
	private BigDecimal budget;

	@Column(name = "Date", nullable = false)
	private LocalDate createdAt = LocalDate.now();

	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "category_id")
	    private Category category;
	/*
	 * @Column(nullable = false) private LocalDate startDate;
	 * 
	 * @Column(nullable = false) private LocalDate endDate;
	 * 
	 * public LocalDate getStartDate() { return startDate; }
	 * 
	 * public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	 * 
	 * public LocalDate getEndDate() { return endDate; }
	 * 
	 * public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	 */

	

	/*
	 * @OneToMany(mappedBy = "income", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Expense> expenses = new ArrayList<>();
	 * 
	 * public List<Expense> getExpenses() { return expenses; }
	 * 
	 * public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * public List<Expense> getExpenses() { return expenses; }
	 * 
	 * public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
	 */

	public Income() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Income other = (Income) obj;
		return Objects.equals(id, other.id);
	}

	public Income(String incomeType, BigDecimal incomeAmount, BigDecimal savingsAmount, LocalDate createdAt,
			BigDecimal budget) {
		super();
		this.incomeType = incomeType;
		this.incomeAmount = incomeAmount;
		this.savingsAmount = savingsAmount;
		this.createdAt = createdAt;
		this.budget = budget;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public BigDecimal getSavingsAmount() {
		return savingsAmount;
	}

	public void setSavingsAmount(BigDecimal savingsAmount) {
		this.savingsAmount = savingsAmount;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

}
