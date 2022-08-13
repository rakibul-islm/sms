package com.asl.marketing.crm.crm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.asl.marketing.crm.crm.util.Response;

public interface BaseController<R, E> {

	public Response<R> getAll();

	public Response<R> save(@RequestBody E e);

	public Response<R> update(@RequestBody E e);

	public Response<R> find(@PathVariable String id);
	
	public Response<R> delete(@RequestBody E e);
}
