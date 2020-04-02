package com.hackathon.etracker.dto;

import java.io.Serializable;

/**
 * @author User1
 *
 */
public class ExpenseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private ExpenseDto response;
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
	 * @return the response
	 */
	public ExpenseDto getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(ExpenseDto response) {
		this.response = response;
	}
	
}
