package com.asl.marketing.crm.crm.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.asl.marketing.crm.crm.service.BaseService;
import com.asl.marketing.crm.crm.util.Response;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractBaseController<P, R, E> implements BaseController<R, E> {

	protected final BaseService<R, E> service;
	
	@GetMapping
	@ApiOperation(value = "Get All")
	@Override
	public Response<R> getAll() {
		return service.getAll();
	}

	@PostMapping
	@ApiOperation(value = "Save")
	@Override
	public Response<R> save(@RequestBody E e) {
		return service.save(e);
	}

	@PutMapping
	@ApiOperation(value = "Update")
	@Override
	public Response<R> update(@RequestBody E e) {
		return service.update(e);
	}

	@GetMapping("/{id}")
	@Override
	public Response<R> find(@PathVariable String id) {
		return service.find(id);
	}
	
	@DeleteMapping
	@ApiOperation(value = "Delete")
	@Override
	public Response<R> delete(@RequestBody E e) {
		return service.delete(e);
	}

}
