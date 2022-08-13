package com.asl.marketing.crm.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
		Zbusiness z = zbusinessMapper.findById(id);
		if(z == null) return getErrorResponse("Business not found");
		return getSuccessResponse("Business found", new ZbusinessResDTO(z));
	}

	@Transactional
	@Override
	public Response<ZbusinessResDTO> save(ZbusinessReqDTO reqDto) {

		Zbusiness z = reqDto.getBean();
		long id = zbusinessMapper.save(z);
		if(id == 0) return getErrorResponse("Can't save");

		return getSuccessResponse("Saved successfully", new ZbusinessResDTO(z));
	}

	@Transactional
	@Override
	public Response<ZbusinessResDTO> update(ZbusinessReqDTO reqDto) {
		Zbusiness z = reqDto.getBean();
		
		long id = zbusinessMapper.update(z);
		if(id == 0) return getErrorResponse("Can't update");

		return getSuccessResponse("Updated successfully", new ZbusinessResDTO(z));
	}

	@Override
	public Response<ZbusinessResDTO> delete(ZbusinessReqDTO reqDto) {
		Zbusiness z = reqDto.getBean();
		
		long id = zbusinessMapper.delete(z.getZid());
		if(id == 0) return getErrorResponse("Can't Delete");

		return getSuccessResponse("Delete successfully");
	}

	@Override
	public Response<ZbusinessResDTO> getAll() {
		List<Zbusiness> list = zbusinessMapper.getAll();
		if(list == null || list.isEmpty()) return getErrorResponse("Business list not found");
		return getSuccessResponse("Found Zbusiness", list.stream().map(data -> new ModelMapper().map(data, ZbusinessResDTO.class)).collect(Collectors.toList()));
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
