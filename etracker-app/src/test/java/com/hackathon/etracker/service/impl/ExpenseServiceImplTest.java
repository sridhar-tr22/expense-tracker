/**
 * 
 */
package com.hackathon.etracker.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.entity.Expense;
import com.hackathon.etracker.repository.ExpenseRepository;

/**
 * @author User1
 *
 */
class ExpenseServiceImplTest {
	
	@Autowired
	private ExpenseServiceImpl expenseServiceImpl;
	
	@MockBean
	private ExpenseRepository expenseRepository;
	
	private Expense expense;
	private ExpenseDto expenseDto;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		expense = new Expense();
		
		expenseDto = new ExpenseDto();
	}

	/**
	 * Test method for {@link com.hackathon.etracker.service.impl.ExpenseServiceImpl#addExpense()}.
	 */
	@Test
	void testAddExpense() {
		Mockito.when(expenseRepository.save(Mockito.any(Expense.class))).thenReturn(expense);
		
		expenseServiceImpl.addExpense(expenseDto);
		
	}

}
