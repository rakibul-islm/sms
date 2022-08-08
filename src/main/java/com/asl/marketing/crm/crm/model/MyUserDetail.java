/**
 * 
 */
package com.asl.marketing.crm.crm.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.asl.marketing.crm.crm.entity.Role;
import com.asl.marketing.crm.crm.entity.Users;

import lombok.Data;

/**
 * @author asl
 *
 */
@Data
public class MyUserDetail implements UserDetails {

	private Long u_id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	
	private Set<Role> userRoles = new HashSet<>();
	
	public MyUserDetail(Users user){
		this.u_id = user.getU_id();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.phone = user.getPhone();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> set = new HashSet<>();
		this.userRoles.forEach(userRole->{
			set.add(new Authority(userRole.getRname()));
		});
		
		return set;
	}

	@Override
	public String getPassword() {
		
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
