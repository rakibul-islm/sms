/**
 * 
 */
package com.asl.marketing.crm.crm.dto.res;

import org.springframework.beans.BeanUtils;

import com.asl.marketing.crm.crm.entity.Users;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author asl
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserResDto extends BaseResponseDTO<Users> {

	public UserResDto(Users u) {
		BeanUtils.copyProperties(u, this);
	}

	private Long u_id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;
}
