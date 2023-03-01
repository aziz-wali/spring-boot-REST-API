package com.shop.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.model.Role;
import com.shop.model.User;
import com.shop.repo.UserRepo;


@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;



		
	
	
	public void  saveToDB(String username,String email,String password) {
		User u= new User();
		u.setUsername(username);
		
		u.setEmail(email);
		
		
		
		
	}


	public void updateUser(Long id, String username) {
		User u = new User();
		u = userRepo.findById(id).get();
		
		u.setUsername(username);
       
    
        
        userRepo.save(u);
		
	}


	public User add(User user) {
		// TODO Auto-generated method stub#
		Role role= new Role(2);
		user.addRole(role);
		
		 return userRepo.save(user);
	}


	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}


	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	
}
