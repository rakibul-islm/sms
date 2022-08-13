package com.asl.marketing.crm.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asl.marketing.crm.crm.dto.req.UserReqDto;
import com.asl.marketing.crm.crm.dto.res.UserResDto;
import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.mapper.UserMapper;
import com.asl.marketing.crm.crm.model.MyUserDetail;
import com.asl.marketing.crm.crm.service.UserService;
import com.asl.marketing.crm.crm.util.Response;

@Service
public class UserServiceImpl extends AbstractBaseService<UserResDto, UserReqDto>  implements UserDetailsService, UserService<UserResDto, UserReqDto>{
	
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

	@Override
	public Response<UserResDto> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<UserResDto> save(UserReqDto reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<UserResDto> update(UserReqDto reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<UserResDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<UserResDto> delete(UserReqDto reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
