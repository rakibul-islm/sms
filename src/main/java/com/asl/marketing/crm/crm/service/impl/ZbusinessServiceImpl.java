package com.asl.marketing.crm.crm.service.impl;

import java.util.List;

import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asl.marketing.crm.crm.dto.req.ZbusinessReqDTO;
import com.asl.marketing.crm.crm.dto.res.ZbusinessResDTO;
import com.asl.marketing.crm.crm.entity.Zbusiness;
import com.asl.marketing.crm.crm.mapper.ZbusinessMapper;
import com.asl.marketing.crm.crm.service.ZbusinessService;
import com.asl.marketing.crm.crm.util.Response;

@Service
public class ZbusinessServiceImpl extends AbstractBaseService<ZbusinessResDTO, ZbusinessReqDTO> implements ZbusinessService<ZbusinessResDTO, ZbusinessReqDTO>{
	
	@Autowired private ZbusinessMapper zbusinessMapper;

	@Override
	public Response<ZbusinessResDTO> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transient
	@Override
	public Response<ZbusinessResDTO> save(ZbusinessReqDTO reqDto) {
		
		Zbusiness z = new Zbusiness();
		BeanUtils.copyProperties(reqDto, z);
		
		long id = zbusinessMapper.save(z);
		if(id < 0) return getErrorResponse("Can't save");

		return getSuccessResponse("Saved successfully", new ZbusinessResDTO(z));
	}

	@Override
	public Response<ZbusinessResDTO> update(ZbusinessReqDTO reqDto) {
		Zbusiness z = new Zbusiness();
		BeanUtils.copyProperties(source, target);
		return null;
	}

	@Override
	public void delete(ZbusinessReqDTO reqDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Response<ZbusinessResDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Transactional
//	@Override
//	public long save(Zbusiness zbusiness) {
//		if(zbusiness == null) return 0;
//		
//		return zbusinessMapper.save(zbusiness);
//	}
//
//	@Transactional
//	@Override
//	public long update(Zbusiness zbusiness) {
//		if(zbusiness == null) return 0;
//		
//		return zbusinessMapper.update(zbusiness);
//	}
//
//	@Transactional
//	@Override
//	public void delete(long zid) {
//		
//		this.zbusinessMapper.delete(zid);
//	
//	}
//
//	@Override
//	public List<Zbusiness> getAll() {
//		
//		return zbusinessMapper.getAll();
//	}
//
//	@Override
//	public Zbusiness findById(String zid) {
//		if (StringUtils.isBlank(zid)) return null;
//		
//		return zbusinessMapper.findById(zid);
//	}

}
