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
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ExpenseName", nullable = false)
	private String expenseName;

	@Column(name = "ExpenseType")
	private String expenseType;

	@Column(name = "Amount", nullable = false)
	private BigDecimal expenseAmount;

	@Column(name = "Date", nullable = false)
	private LocalDate dateofExpense = LocalDate.now();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	public Expense() {

	}

	public Expense(String expenseName, String expenseType, BigDecimal expenseAmount, LocalDate dateofExpense) {
		super();
		this.expenseName = expenseName;
		this.expenseType = expenseType;
		this.expenseAmount = expenseAmount;
		this.dateofExpense = dateofExpense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public LocalDate getDateofExpense() {
		return dateofExpense;
	}

	public void setDateofExpense(LocalDate dateofExpense) {
		this.dateofExpense = dateofExpense;
	}

	/*
	 * @Column private LocalDate startDate;
	 * 
	 * @Column private LocalDate endDate;
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
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "user_id", nullable = false) private User user;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "category_id", nullable = false) private Category
	 * category;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "income_id") private Income income;
	 */

	
	  public User getUser() { return user; }
	 
	  public void setUser(User user) { this.user = user; }
	  
	  public Category getCategory() { return category; }
	  
	  public void setCategory(Category category) { this.category = category; }
	/* 
	 * public Income getIncome() { return income; }
	 * 
	 * public void setIncome(Income income) { this.income = income; }
	 */
	  

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseName=" + expenseName + ", expenseType=" + expenseType
				+ ", expenseAmount=" + expenseAmount + ", dateofExpense=" + dateofExpense + ", user=" + user
				+ ", category=" + category + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return Objects.equals(id, other.id);
	}

}
