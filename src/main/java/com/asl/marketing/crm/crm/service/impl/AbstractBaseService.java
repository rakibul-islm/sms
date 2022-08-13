package com.asl.marketing.crm.crm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.asl.marketing.crm.crm.dto.res.UserAccountResDTO;
import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.service.CommonFunctions;
import com.asl.marketing.crm.crm.user.User;
import com.asl.marketing.crm.crm.util.Response;

public abstract class AbstractBaseService<R, E> implements CommonFunctions<R> {

	@Override
	public Response<R> getSuccessResponse(String message) {
		return getSuccessResponse(null, message);
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String message, R r) {
		return getSuccessResponse(null, message, r);
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, R r) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		response.setObj(r);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String message, List<R> list) {
		return getSuccessResponse(null, message, list);
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, List<R> list) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		response.setItems(list);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String message, Response<R> response) {
		return getSuccessResponse(null, message, response);
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, Response<R> response) {
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getErrorResponse(String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(false);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getErrorResponse(String code, String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(false);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getErrorResponse(String code, String message, Response<R> response) {
		response.setSuccess(false);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public UserAccountResDTO getSystemAdminUser() {
		UserAccountResDTO responseDto = new UserAccountResDTO();
		Users u = new Users();
		
		BeanUtils.copyProperties(u, responseDto);
		return responseDto;
	}
}
