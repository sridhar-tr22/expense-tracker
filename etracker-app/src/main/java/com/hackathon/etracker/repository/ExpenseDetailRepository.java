/**
 * 
 */
package com.hackathon.etracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.etracker.entity.ExpenseDetail;

/**
 * @author User1
 *
 */
@Repository
public interface ExpenseDetailRepository extends JpaRepository<ExpenseDetail, Long>{

}
