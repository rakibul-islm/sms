package com.asl.marketing.crm.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asl.marketing.crm.crm.entity.Users;

@Mapper
public interface UserMapper {
	
	public long save(Users users);
	
	public long update(Users users);
	
	public void delete(long uid);
	
	public List<Users> getAll();
	
	public Users findById(String uid);
	
	public Users findByUsername(String username);

}
