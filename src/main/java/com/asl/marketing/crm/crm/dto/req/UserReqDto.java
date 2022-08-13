package com.asl.marketing.crm.crm.dto.req;

import org.springframework.beans.BeanUtils;

import com.asl.marketing.crm.crm.entity.Users;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserReqDto extends BaseRequestDTO<Users> {
	
	private Long u_id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
	
	@Override
	public Users getBean() {
		Users u = new Users();
		BeanUtils.copyProperties(this, u);
		return u;
	}

	
}
