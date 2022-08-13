package com.asl.marketing.crm.crm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.marketing.crm.crm.config.JwtUtil;
import com.asl.marketing.crm.crm.dto.req.AuthenticationReqDTO;
import com.asl.marketing.crm.crm.dto.res.AuthenticationResDTO;
import com.asl.marketing.crm.crm.entity.Users;
import com.asl.marketing.crm.crm.service.impl.UserDetailServiceImpl;
import com.asl.marketing.crm.crm.util.Response;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/sms/v2/authenticate")
@Api(tags = {"Authentication"}, description = "API", produces = "application/json", consumes = "application/json")
public class AuthenticateController {
	
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private UserDetailServiceImpl detailServiceImpl;
	@Autowired private JwtUtil jwtUtil;
	
	// generate token
	@PostMapping("/token")
	public Response<AuthenticationResDTO> generateToken(@RequestBody AuthenticationReqDTO reqDto) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqDto.getUsername(), reqDto.getPassword()));
		} catch (BadCredentialsException e) {
			Response<AuthenticationResDTO> resDto = new Response<AuthenticationResDTO>();
			resDto.setSuccess(false);
			resDto.setMessage(e.getMessage());
			return resDto;
		}

		// if authentication success then generate token
		final UserDetails userDetails = detailServiceImpl.loadUserByUsername(reqDto.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
	
		Response<AuthenticationResDTO> response = new Response<AuthenticationResDTO>();
		response.setSuccess(true);
		response.setMessage("Token generated successfully");
		AuthenticationResDTO resDto = new AuthenticationResDTO(jwt);
		response.setObj(resDto);
		return response;
	}

	private void authenticate(String username, String password) throws Exception {

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("USER DISABLED " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials " + e.getMessage());
		}
	}

	// return the details of current user
	@GetMapping("/current-user")
	public Users getCurrentUser(Principal principal) {
		return ((Users) this.detailServiceImpl.loadUserByUsername(principal.getName()));

	}

}
