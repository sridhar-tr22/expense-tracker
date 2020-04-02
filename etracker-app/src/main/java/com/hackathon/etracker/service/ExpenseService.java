package com.hackathon.etracker.service;

import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.dto.ExpenseResponse;

/**
 * @author User1
 *
 *         <p>
 *         Service for Expenses
 *         </p>
 */
public interface ExpenseService {

	public ExpenseResponse addExpense(ExpenseDto expenseRequest);
}
