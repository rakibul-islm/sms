package com.asl.marketing.crm.crm.service;

import java.util.List;

import com.asl.marketing.crm.crm.dto.res.UserAccountResDTO;
import com.asl.marketing.crm.crm.util.Response;

public interface CommonFunctions<R> {
	Response<R> getSuccessResponse(String message);

	Response<R> getSuccessResponse(String code, String message);

	Response<R> getSuccessResponse(String message, R r);

	Response<R> getSuccessResponse(String code, String message, R r);

	Response<R> getSuccessResponse(String message, List<R> list);

	Response<R> getSuccessResponse(String code, String message, List<R> list);

	Response<R> getSuccessResponse(String message, Response<R> response);

	Response<R> getSuccessResponse(String code, String message, Response<R> response);

	Response<R> getErrorResponse(String message);

	Response<R> getErrorResponse(String code, String message);

	Response<R> getErrorResponse(String code, String message, Response<R> response);

	UserAccountResDTO getSystemAdminUser();
}
