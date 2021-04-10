package com.dgsystems.myexpenses.expense.repository;

import com.dgsystems.myexpenses.expense.core.Expense;
import com.dgsystems.myexpenses.expense.core.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenseRepositoryImpl implements ExpenseRepository { // this class should go away once we start using Spring Data
	private List<Expense>  expenses;
	
	public ExpenseRepositoryImpl() {
		expenses = new ArrayList<>();
	}

	public void save(Expense any) { // this method comes with Spring Data
		expenses.add(any);
	}

	public Expense expenseOfId(UUID newExpenseId) {
		return expenses.stream()
				.filter(e -> e.id().equals(newExpenseId))
				.findAny()
				.get();
	}

	public List<Expense> getExpenses() {
		return expenses;
	}
}