package com.asl.marketing.crm.crm.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
//		if(id==null)
		User user=service.findOne(id);
		if (user==null)
			throw new UserNotFoundException("id"+id);
		
		 EntityModel<User> model= EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}

	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
//		if(id==null)
		User user=service.deleteById(id);
		if (user==null)
			throw new UserNotFoundException("id"+id);
		
		//return user;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid  @RequestBody User user)
	{
		User Saveduser=service.save(user);
		
		URI location=ServletUriComponentsBuilder.
		fromCurrentRequest().path("{/id}").
		buildAndExpand(Saveduser.getId()).
		toUri();
		//created
		return ResponseEntity.created(location).build();
	}

}
