package com.hackathon.etracker.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.entity.User;
import com.hackathon.etracker.service.ExpenseService;

@RestController
@RequestMapping("/eTracker")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/expenses/new")
	public void addExpense(@RequestBody ExpenseDto expenseRequest) {
		expenseService.addExpense(expenseRequest);
	}
	
	@GetMapping("/sample")
	public ResponseEntity<ExpenseDto> sampleRequest() {
		ExpenseDto dto = new ExpenseDto();
		dto.setEventName("Movie");
		User user = new User();
		user.setUserId(1L);
		dto.setExpenseCreatedBy(user);
		
		dto.setExpenseRatio("EQUALLY");
		dto.setTotalAmount(BigDecimal.valueOf(1000.00));
		dto.setEventDate(LocalDate.of(2020, 03, 25));
		dto.setExpenseStatus("OPEN");
		
		User participant1 = new User();
			participant1.setUserId(2L);
				
		User participant2 = new User();
			participant2.setUserId(3L);
		dto.setParticipants(Arrays.asList(participant1, participant2));
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}

