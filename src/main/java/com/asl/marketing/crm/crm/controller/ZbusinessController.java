package com.asl.marketing.crm.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.marketing.crm.crm.dto.req.ZbusinessReqDTO;
import com.asl.marketing.crm.crm.dto.res.ZbusinessResDTO;
import com.asl.marketing.crm.crm.entity.Zbusiness;
import com.asl.marketing.crm.crm.service.ZbusinessService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/sms/business")
@Api(tags = {"Business"}, description = "API", produces = "application/json", consumes = "application/json")
public class ZbusinessController extends AbstractBaseController<Zbusiness, ZbusinessResDTO, ZbusinessReqDTO> {
	
	private ZbusinessService<ZbusinessResDTO, ZbusinessReqDTO> zbusinessService;

	public ZbusinessController(ZbusinessService<ZbusinessResDTO, ZbusinessReqDTO> zbusinessService){
		super(zbusinessService);
		this.zbusinessService = zbusinessService;
	}
	
	//add zbusiness
//	@PostMapping("/")
//	public Response<ZbusinessResDTO> add(@RequestBody ZbusinessReqDTO reqDto) {
//		return zbusinessService.save(reqDto);
//	}
	
	//get zbusiness
//	@GetMapping("/")
//	public List<Zbusiness> getAll() {
//		return this.zbusinessService.getAll();
//	}
	
//	@PutMapping("/")
//	public Response<ZbusinessResDTO> update(@RequestBody ZbusinessReqDTO reqDto) {
//		return zbusinessService.update(reqDto);
//	}
//	
//	
//	@GetMapping("/{zid}")
//	public Zbusiness zbusiness(@PathVariable("zid") String zid) {
//		
//		return this.zbusinessService.findById(zid);
//	}

}
