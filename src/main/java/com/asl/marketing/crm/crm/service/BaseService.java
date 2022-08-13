package com.asl.marketing.crm.crm.service;

import com.asl.marketing.crm.crm.util.Response;

public interface BaseService<R, E> {

	public Response<R> find(String id);

	public Response<R> save(E reqDto);

	public Response<R> update(E reqDto);

	public Response<R> getAll();

	public Response<R> delete(E reqDto);
}
