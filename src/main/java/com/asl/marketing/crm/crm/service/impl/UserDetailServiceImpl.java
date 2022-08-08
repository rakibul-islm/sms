package com.asl.marketing.crm.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.mapper.UserMapper;
import com.asl.marketing.crm.crm.model.MyUserDetail;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = this.userMapper.findByUsername(username);
		
		if (user == null) {
			System.out.println("User not found !!");
			throw new UsernameNotFoundException("No User found !!");
		}

		return new MyUserDetail(user);
	}

}
