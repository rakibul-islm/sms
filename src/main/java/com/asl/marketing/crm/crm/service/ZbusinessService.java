package com.asl.marketing.crm.crm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.asl.marketing.crm.crm.entity.Zbusiness;

@Component
public interface ZbusinessService {
	
	public long save(Zbusiness zbusiness);

	public long update(Zbusiness zbusiness);
	
	public void delete(long zid);

	public List<Zbusiness> getAll();

	public Zbusiness findById(String zid);

}
