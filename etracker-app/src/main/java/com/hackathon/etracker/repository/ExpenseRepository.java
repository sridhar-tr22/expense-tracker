package com.hackathon.etracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.etracker.entity.Expense;

/**
 * @author User1
 * 
 * <p> Expense Repository </p>
 *
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
