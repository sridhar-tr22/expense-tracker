package com.hackathon.etracker.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.dto.ExpenseResponse;
import com.hackathon.etracker.service.ExpenseService;

@WebMvcTest
@AutoConfigureMockMvc
class ExpenseControllerTest {

	@Autowired
	private ExpenseController expenseController;

	@MockBean
	private ExpenseService expenseService;

	@Autowired
	private MockMvc mockMvc;
	
	private ExpenseDto expenseDto;
	private ExpenseResponse expenseResponse;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
		
		
		expenseResponse = new ExpenseResponse();
	}

	@Test
	void testAddExpense_WhenRequestPresent() {
		Mockito.when(expenseService.addExpense(Mockito.any(ExpenseDto.class))).thenReturn(expenseResponse);
	}

	@Test
	void testSampleRequest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/eTracker/sample")).andDo(print());
	}

}
