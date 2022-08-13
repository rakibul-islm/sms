package com.asl.marketing.crm.crm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.marketing.crm.crm.dto.req.AuthenticationReqDTO;
import com.asl.marketing.crm.crm.dto.res.AuthenticationResDTO;
import com.asl.marketing.crm.crm.service.AuthenticationService;
import com.asl.marketing.crm.crm.user.User;
import com.asl.marketing.crm.crm.util.Response;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/sms/authenticate")
@Api(tags = {"Authentication"}, description = "API", produces = "application/json", consumes = "application/json")
public class AuthenticateController extends AbstractBaseController<User, AuthenticationResDTO, AuthenticationReqDTO> {
	
	private AuthenticationService<AuthenticationResDTO, AuthenticationReqDTO> authservice;

	public AuthenticateController(AuthenticationService<AuthenticationResDTO, AuthenticationReqDTO> authservice) {
		super(authservice);
		this.authservice = authservice;
	}
	
	// generate token
	@PostMapping("/token")
	public Response<AuthenticationResDTO> generateToken(@RequestBody AuthenticationReqDTO reqDto) throws Exception {
		return authservice.generateToken(reqDto);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResDTO> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResDTO> save(AuthenticationReqDTO e) {
		// TODO Auto-generated method stub
		return super.save(e);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResDTO> update(AuthenticationReqDTO e) {
		// TODO Auto-generated method stub
		return super.update(e);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResDTO> find(String id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResDTO> delete(AuthenticationReqDTO e) {
		// TODO Auto-generated method stub
		return super.delete(e);
	}

	

}
