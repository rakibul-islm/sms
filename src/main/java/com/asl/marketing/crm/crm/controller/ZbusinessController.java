package com.asl.marketing.crm.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.marketing.crm.crm.entity.Zbusiness;
import com.asl.marketing.crm.crm.service.ZbusinessService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/zbusiness")
public class ZbusinessController {
	
	@Autowired private ZbusinessService zbusinessService;
	
	//add zbusiness
	@PostMapping("/")
	public long add(@RequestBody Zbusiness zbusiness) {
	
		return this.zbusinessService.save(zbusiness);
	}
	
	//get zbusiness
	@GetMapping("/")
	public List<Zbusiness> getAll() {
		return this.zbusinessService.getAll();
	}
	
	@PutMapping("/")
	public  long update(@RequestBody Zbusiness zbusiness) {
		return this.zbusinessService.update(zbusiness);
	}
	
	
	@GetMapping("/{zid}")
	public Zbusiness zbusiness(@PathVariable("zid") String zid) {
		
		return this.zbusinessService.findById(zid);
	}

}
