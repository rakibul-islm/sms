package com.asl.marketing.crm.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.asl.marketing.crm.crm.config.JwtUtil;
import com.asl.marketing.crm.crm.dto.req.AuthenticationReqDTO;
import com.asl.marketing.crm.crm.dto.res.AuthenticationResDTO;
import com.asl.marketing.crm.crm.service.AuthenticationService;
import com.asl.marketing.crm.crm.util.Response;

@Service
public class AuthenticationServiceImpl extends AbstractBaseService<AuthenticationResDTO, AuthenticationReqDTO> implements AuthenticationService<AuthenticationResDTO, AuthenticationReqDTO> {

	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtUtil jwtUtil;
	@Autowired private UserServiceImpl userService;

	@Override
	public Response<AuthenticationResDTO> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<AuthenticationResDTO> save(AuthenticationReqDTO reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<AuthenticationResDTO> update(AuthenticationReqDTO reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<AuthenticationResDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<AuthenticationResDTO> delete(AuthenticationReqDTO reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<AuthenticationResDTO> generateToken(AuthenticationReqDTO reqDto) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqDto.getUsername(), reqDto.getPassword()));
		} catch (BadCredentialsException e) {
			Response<AuthenticationResDTO> resDto = new Response<AuthenticationResDTO>();
			resDto.setSuccess(false);
			resDto.setMessage(e.getMessage());
			return resDto;
		}

		// if authentication success then generate token
		final UserDetails userDetails = userService.loadUserByUsername(reqDto.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
	
		Response<AuthenticationResDTO> response = new Response<AuthenticationResDTO>();
		response.setSuccess(true);
		response.setMessage("Token generated successfully");
		AuthenticationResDTO resDto = new AuthenticationResDTO(jwt);
		response.setObj(resDto);
		return response;
	}

	
}
