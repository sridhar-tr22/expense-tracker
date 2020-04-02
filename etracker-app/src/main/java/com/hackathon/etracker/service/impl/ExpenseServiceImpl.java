/**
 * 
 */
package com.hackathon.etracker.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.etracker.constant.ExpenseConstant;
import com.hackathon.etracker.dto.ExpenseDto;
import com.hackathon.etracker.dto.ExpenseResponse;
import com.hackathon.etracker.entity.Expense;
import com.hackathon.etracker.entity.ExpenseDetail;
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
	public ExpenseResponse addExpense(ExpenseDto expenseRequest) {
		log.info("New Expense request Event: {}, ", expenseRequest.getEventName());
		Expense preparedExpenseEntity = prepareExpenseEntity(expenseRequest);
		ExpenseResponse expenseResponse = new ExpenseResponse();
		
		Expense save = expenseRepository.save(preparedExpenseEntity);
		
		ExpenseDetail prepareExpenseDetailsForUser = prepareExpenseDetailsForUser(save, expenseRequest);
		
		List<ExpenseDetail> prepareExpenseDetailsForParticipants = prepareExpenseDetailsForParticipants(save, expenseRequest);
		
		BeanUtils.copyProperties(save, expenseResponse);
		
		return expenseResponse;
	}

	private Expense prepareExpenseEntity(ExpenseDto expenseRequest) {
		Objects.requireNonNull(expenseRequest);
		Expense expense = new Expense();

		expense.setEventName(expenseRequest.getEventName());
		expense.setEventDate(expenseRequest.getEventDate());
		expense.setExpenseCreatedBy(expenseRequest.getExpenseCreatedBy());
		expense.setExpenseRatio(ExpenseConstant.EXPENSE_SHARE_RATIO);
		expense.setExpenseStatus(ExpenseConstant.EXPENSE_STATUS_OPEN);
		expense.setTotalAmount(expenseRequest.getTotalAmount());
		expense.setParticipants(expenseRequest.getParticipants());

		// BeanUtils.copyProperties(expenseRequest, expense);
		return expense;
	}

	private ExpenseDetail prepareExpenseDetailsForUser(Expense expense, ExpenseDto expenseRequest) {
		ExpenseDetail expenseDetail = new ExpenseDetail();

		// 1. User Detail
		expenseDetail.setUser(expenseRequest.getExpenseCreatedBy());
		
		// 2. Status as CREATED for expense creator
		expenseDetail.setStatus("CREATED");
		
		// 3. Total Amount 
		expenseDetail.setTotalAmountPaid(expenseRequest.getTotalAmount());
		
		// 4. Amount Received
		expenseDetail.setAmountReceived(BigDecimal.ZERO);

		expenseDetail.setAmountOwes(BigDecimal.ZERO);
		
		return expenseDetail;

	}
	
	private List<ExpenseDetail> prepareExpenseDetailsForParticipants(Expense expense,ExpenseDto expenseRequest){
		List<ExpenseDetail> expenseDetailsList = new ArrayList<>();
		
		// creating ExpenseDetail for each participants 
				List<User> participants = expenseRequest.getParticipants();
				
				participants.forEach(participant -> {
					ExpenseDetail participantExpenseDetail = new ExpenseDetail();
					
					// 1. setting expenseId for participant
					participantExpenseDetail.setExpenseId(expense);
					
					// 2. Participant ID
					participantExpenseDetail.setUser(participant);
					
					// 3. Owes to user name
					participantExpenseDetail.setOwesTo(expenseRequest.getExpenseCreatedBy().getUserId());
					
					// 4. Amount Paid by each participant during expense creation will be ZERO. 
					participantExpenseDetail.setTotalAmountPaid(BigDecimal.ZERO);
					
					// 5. Status
					participantExpenseDetail.setStatus("YET_TO_PAY");
					
					// 6. Amount Received by each participant during expense creation will be ZERO.
					participantExpenseDetail.setAmountReceived(BigDecimal.ZERO);
					int calculateNumberOfParticipant = calculateNumberOfParticipant(expenseRequest);
					BigDecimal shareOfParticipant = calculateEachShareOfParticipant(calculateNumberOfParticipant, expenseRequest.getTotalAmount());
					
					// 7. Share Amount the participant owes
					participantExpenseDetail.setAmountOwes(shareOfParticipant);
					
				});
		
		return expenseDetailsList;
	}

	private int calculateNumberOfParticipant(ExpenseDto expenseRequest) {
		// considering the expense creation user.
		int totalNumberOfParticipants = 1;
		BigDecimal totalAmount = expenseRequest.getTotalAmount();
		expenseRequest.getExpenseCreatedBy();
		List<User> participants = expenseRequest.getParticipants();
	   for (User user : participants) {
		   totalNumberOfParticipants = totalNumberOfParticipants + 1;
	    }
		return totalNumberOfParticipants;
	}

	private BigDecimal calculateEachShareOfParticipant(long numberOfParticipants, BigDecimal totalAmount) {
		BigDecimal eachShare = totalAmount.divide(BigDecimal.valueOf(numberOfParticipants));
		return eachShare;
	}
	

}
