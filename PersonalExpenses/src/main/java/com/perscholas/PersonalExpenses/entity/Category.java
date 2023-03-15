package com.perscholas.PersonalExpenses.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "categoryName"))
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categoryName", nullable = false)
	private String categoryName;

	@Column(name = "Description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "category")
	private List<Income> incomes;

	/*
	 * @Column(name = "totalExpense") private BigDecimal totalExpense;
	 * 
	 * @Column(name = "creationDate", nullable = false) private LocalDate
	 * creationDate = LocalDate.now();
	 */

	/*
	 * @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Expense> expenses = new ArrayList<>();
	 * 
	 * public List<Expense> getExpenses() { return expenses; }
	 * 
	 * public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
	 */

	public Category() {

	}

	// , LocalDate creationDate

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		// this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public LocalDate getCreationDate() { return creationDate; }
	 * 
	 * public void setCreationDate(LocalDate creationDate) { this.creationDate =
	 * creationDate; }
	 */

	/*
	 * public BigDecimal getTotalExpense() { return
	 * expenses.stream().map(Expense::getCost).reduce(BigDecimal.ZERO,
	 * BigDecimal::add); }
	 * 
	 * public void SetTotalExpense(BigDecimal totalExpense) { this.totalExpense =
	 * totalExpense; }
	 */

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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", description=" + description + ", user="
				+ user + ", incomes=" + incomes + "]";
	}

	
}
