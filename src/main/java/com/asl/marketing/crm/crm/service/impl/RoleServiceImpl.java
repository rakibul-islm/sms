package com.asl.marketing.crm.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asl.marketing.crm.crm.entity.Role;
import com.asl.marketing.crm.crm.mapper.RoleMapper;
import com.asl.marketing.crm.crm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired private RoleMapper roleMapper;

	@Transactional
	@Override
	public long save(Role role) {
		if(role == null) return 0;
		
		return roleMapper.save(role);
	}

	@Transactional
	@Override
	public long update(Role role) {
		if(role == null) return 0;
		
		return roleMapper.update(role);
	}

	@Transactional
	@Override
	public void delete(long rid) {
		
		this.roleMapper.delete(rid);
	
	}

	@Override
	public List<Role> getAll() {
		
		return roleMapper.getAll();
	}

	@Override
	public Role findById(String rid) {
		if (StringUtils.isBlank(rid)) return null;
		
		return roleMapper.findById(rid);
	}

}
