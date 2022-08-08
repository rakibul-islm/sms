package com.asl.marketing.crm.crm.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asl.marketing.crm.crm.entity.Role;
import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.helper.UserFoundException;
import com.asl.marketing.crm.crm.mapper.RoleMapper;
import com.asl.marketing.crm.crm.mapper.UserMapper;
import com.asl.marketing.crm.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired private UserMapper userMapper;
	@Autowired private RoleMapper roleMapper;


	@Transactional
	@Override
	public long update(Users users) {
		if(users == null) return 0;
		
		return userMapper.update(users);
	}

	@Transactional
	@Override
	public void delete(long uid) {
		
		this.userMapper.delete(uid);
	
	}

	@Override
	public List<Users> getAll() {
		
		return userMapper.getAll();
	}

	@Override
	public Users findById(String uid) {
		if (StringUtils.isBlank(uid)) return null;
		
		return userMapper.findById(uid);
	}



	@Override
	public Users findByUsername(String username) {
		if (StringUtils.isBlank(username)) return null;
		
		return userMapper.findByUsername(username);
	}

	@Override
	public long createUser(Users user, Role role) throws Exception {
		Users local = this.userMapper.findByUsername(user.getUsername());

		if (local != null) {
			System.out.println("User is already there !!");
			throw new UserFoundException();
		} else {
			// user create
			roleMapper.save(role);

			//local = userMapper.save(user);
		}

		return userMapper.save(user);
	}

}
