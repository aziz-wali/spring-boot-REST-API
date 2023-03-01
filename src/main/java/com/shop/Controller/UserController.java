package com.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Product;
import com.shop.model.User;
import com.shop.repo.UserRepo;
import com.shop.service.UserService;



import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.security.MessageDigest; 


@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	
	
	
	  @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllProducts () {
	        List<User> users = userService.findAllUsers();
	        //products.forEach(s->{System.out.print(s.getName());});
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	  
	  
	  
	@PostMapping("/registr")
	public void registerUser(@RequestParam("user") String user) throws JsonMappingException, JsonProcessingException {
		
		
		User user1= new ObjectMapper().readValue(user,User.class);
				
       user1.setPassword(hashPassword(user1.getPassword()));

		userService.add(user1);
	}
	
	
	public String hashPassword(String password) {
		  try   
	        {  
	            /* MessageDigest instance for MD5. */  
	            MessageDigest m = MessageDigest.getInstance("MD5");  
	              
	            /* Add plain-text password bytes to digest using MD5 update() method. */  
	            m.update(password.getBytes());  
	              
	            /* Convert the hash value into bytes */   
	            byte[] bytes = m.digest();  
	              
	            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
	            StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	              
	            return s.toString();
	        }   
	        catch (NoSuchAlgorithmException e)   
	        {  
	            e.printStackTrace();  
	        }  
		  
		return null;
	}
	
	
	@GetMapping("/login")
	public void loginUser(@RequestParam("username") String user) throws JsonMappingException, JsonProcessingException {
		
		
	}
}
