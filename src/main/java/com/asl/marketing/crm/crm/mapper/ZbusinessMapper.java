package com.asl.marketing.crm.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asl.marketing.crm.crm.entity.Zbusiness;

@Mapper
public interface ZbusinessMapper {
	
	public long save(Zbusiness zbusiness);
	
	public long update(Zbusiness zbusiness);
	
	public void delete(long zid);
	
	public List<Zbusiness> getAll();
	
	public Zbusiness findById(String zid);

}
