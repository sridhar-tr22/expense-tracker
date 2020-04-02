/**
 * 
 */
package com.hackathon.etracker.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hackathon.etracker.entity.User;

/**
 * @author User1
 *
 */
public class ExpenseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long expenseId;

	@NotBlank
	private String eventName;

	@NotNull
	private LocalDate eventDate;

	@NotBlank
	private String expenseStatus;

	@NotBlank
	private String expenseRatio;

	@NotNull
	private User expenseCreatedBy;

	@NotNull
	private List<User> participants = new ArrayList<>();

	@NotNull
	private BigDecimal totalAmount;

	/**
	 * @return the expenseId
	 */
	public Long getExpenseId() {
		return expenseId;
	}

	/**
	 * @param expenseId the expenseId to set
	 */
	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDate
	 */
	public LocalDate getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the expenseStatus
	 */
	public String getExpenseStatus() {
		return expenseStatus;
	}

	/**
	 * @param expenseStatus the expenseStatus to set
	 */
	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}

	/**
	 * @return the expenseRatio
	 */
	public String getExpenseRatio() {
		return expenseRatio;
	}

	/**
	 * @param expenseRatio the expenseRatio to set
	 */
	public void setExpenseRatio(String expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	/**
	 * @return the expenseCreatedBy
	 */
	public User getExpenseCreatedBy() {
		return expenseCreatedBy;
	}

	/**
	 * @param expenseCreatedBy the expenseCreatedBy to set
	 */
	public void setExpenseCreatedBy(User expenseCreatedBy) {
		this.expenseCreatedBy = expenseCreatedBy;
	}

	/**
	 * @return the participants
	 */
	public List<User> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
