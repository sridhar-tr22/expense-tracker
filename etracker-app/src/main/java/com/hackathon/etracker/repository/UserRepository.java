package com.hackathon.etracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.etracker.entity.User;

/**
 * @author User1
 * 
 * <p> User Repository </p>
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
