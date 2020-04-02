package com.hackathon.etracker.service;

import com.hackathon.etracker.dto.ExpenseDto;

/**
 * @author User1
 *
 *         <p>
 *         Service for Expenses
 *         </p>
 */
public interface ExpenseService {

	void addExpense(ExpenseDto expenseRequest);
}
