package com.shop.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.shop.model.Product;
import com.shop.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	

	User findByUsername(String username);
	
	
	

}
