/**
 * 
 */
package com.hackathon.etracker.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.entity.Expense;
import com.hackathon.etracker.entity.User;
import com.hackathon.etracker.repository.ExpenseDetailRepository;
import com.hackathon.etracker.repository.ExpenseRepository;
import com.hackathon.etracker.service.ExpenseService;

import lombok.extern.log4j.Log4j2;

/**
 * @author User1
 *
 */
@Log4j2
@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private ExpenseDetailRepository expenseDetailRepository;

	@Override
	public void addExpense(ExpenseDto expenseRequest) {
		Expense prepareExpenseEntity = prepareExpenseEntity(expenseRequest);
		
		
	}
	
	private Expense prepareExpenseEntity(ExpenseDto expenseRequest) {
		Expense expense = new Expense();
		BeanUtils.copyProperties(expenseRequest, expense);
		expense.setExpenseStatus("OPEN");
		return expense;
	}
	
}
