package com.asl.marketing.crm.crm.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.asl.marketing.crm.crm.entity.Role;
import com.asl.marketing.crm.crm.entity.Users;

@Component
public interface UserService {
	
	public long createUser(Users user, Role role) throws Exception;

	public long update(Users users);
	
	public void delete(long uid);

	public List<Users> getAll();

	public Users findById(String uid);
	
	public Users findByUsername(String username);

}
