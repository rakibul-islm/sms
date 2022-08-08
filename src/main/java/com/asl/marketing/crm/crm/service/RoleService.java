package com.asl.marketing.crm.crm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.asl.marketing.crm.crm.entity.Role;

@Component
public interface RoleService {
		
	public long save(Role role);

	public long update(Role role);
	
	public void delete(long rid);

	public List<Role> getAll();

	public Role findById(String rid);

}
