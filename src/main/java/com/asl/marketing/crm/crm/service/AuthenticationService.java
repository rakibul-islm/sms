package com.asl.marketing.crm.crm.service;

import com.asl.marketing.crm.crm.dto.req.AuthenticationReqDTO;
import com.asl.marketing.crm.crm.dto.res.AuthenticationResDTO;
import com.asl.marketing.crm.crm.util.Response;

public interface AuthenticationService <R, E> extends BaseService<R, E> {

	public Response<AuthenticationResDTO> generateToken(AuthenticationReqDTO reqDto);
}
