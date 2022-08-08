package com.asl.marketing.crm.crm.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.asl.marketing.crm.crm.entity.Role;

@Mapper
public interface RoleMapper {
	
	public long save(Role role);

	public long update(Role role);
	
	public void delete(long rid);

	public List<Role> getAll();

	public Role findById(String rid);

}
