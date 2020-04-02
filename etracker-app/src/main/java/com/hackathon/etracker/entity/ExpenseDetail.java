/**
 * 
 */
package com.hackathon.etracker.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author User1
 *         <p>
 *         Payment entity
 */
@Entity
public class ExpenseDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long expenseDetailId;

	private Long expenseId;

	private Long user;

	private BigDecimal amountOwes;

	private BigDecimal totalAmountPaid;

	private String status;

	private BigDecimal amountReceived;

	private Long owesTo;

	public ExpenseDetail() {
	}

	/**
	 * @return the expenseDetailId
	 */
	public Long getExpenseDetailId() {
		return expenseDetailId;
	}

	/**
	 * @param expenseDetailId the expenseDetailId to set
	 */
	public void setExpenseDetailId(Long expenseDetailId) {
		this.expenseDetailId = expenseDetailId;
	}

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
	 * @return the user
	 */
	public Long getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Long user) {
		this.user = user;
	}

	/**
	 * @return the amountOwes
	 */
	public BigDecimal getAmountOwes() {
		return amountOwes;
	}

	/**
	 * @param amountOwes the amountOwes to set
	 */
	public void setAmountOwes(BigDecimal amountOwes) {
		this.amountOwes = amountOwes;
	}

	/**
	 * @return the totalAmountPaid
	 */
	public BigDecimal getTotalAmountPaid() {
		return totalAmountPaid;
	}

	/**
	 * @param totalAmountPaid the totalAmountPaid to set
	 */
	public void setTotalAmountPaid(BigDecimal totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the amountReceived
	 */
	public BigDecimal getAmountReceived() {
		return amountReceived;
	}

	/**
	 * @param amountReceived the amountReceived to set
	 */
	public void setAmountReceived(BigDecimal amountReceived) {
		this.amountReceived = amountReceived;
	}

	/**
	 * @return the owesTo
	 */
	public Long getOwesTo() {
		return owesTo;
	}

	/**
	 * @param owesTo the owesTo to set
	 */
	public void setOwesTo(Long owesTo) {
		this.owesTo = owesTo;
	}

}
