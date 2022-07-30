package com.asl.marketing.crm.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asl.marketing.crm.crm.entity.Zbusiness;
import com.asl.marketing.crm.crm.mapper.ZbusinessMapper;
import com.asl.marketing.crm.crm.service.ZbusinessService;

@Service
public class ZbusinessServiceImpl implements ZbusinessService{
	
	@Autowired private ZbusinessMapper zbusinessMapper;

	@Transactional
	@Override
	public long save(Zbusiness zbusiness) {
		if(zbusiness == null) return 0;
		
		return zbusinessMapper.save(zbusiness);
	}

	@Transactional
	@Override
	public long update(Zbusiness zbusiness) {
		if(zbusiness == null) return 0;
		
		return zbusinessMapper.update(zbusiness);
	}

	@Transactional
	@Override
	public long delete(Zbusiness zbusiness) {
		if(zbusiness==null) return 0;
		
		long count = zbusinessMapper.delete(zbusiness);		
		return count;
	}

	@Override
	public List<Zbusiness> getAll() {
		
		return zbusinessMapper.getAll();
	}

	@Override
	public Zbusiness findById(String zid) {
		if (StringUtils.isBlank(zid)) return null;
		
		return zbusinessMapper.findById(zid);
	}

}
