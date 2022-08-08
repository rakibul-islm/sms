package com.asl.marketing.crm.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.asl.marketing.crm.crm.entity.Role;
import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.helper.UserFoundException;
import com.asl.marketing.crm.crm.service.UserService;

@SpringBootApplication
public class CrmApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("starting code..");
			
			  Users user = new Users(); 
			  user.setU_id(100L);
			  user.setEmail("asl@gmail.com");
			  user.setPhone("01956458454"); 
			  user.setUsername("admin");
			  user.setPassword(this.bCryptPasswordEncoder.encode("123"));
			  
			  Role role1 = new Role(); 
			  role1.setRid(50L); 
			  role1.setRname("ADMIN");
			  
			  
			  long user1 = this.userService.createUser(user, role1);
			  System.out.println(user.getUsername());
			 
			
		    } catch (UserFoundException e) {
	            //e.printStackTrace();
	            System.out.println("User is found !!");
	        }
		
	}
	

}
