/**
 * 
 */
package com.asl.marketing.crm.crm.dto.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author asl
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticationReqDTO extends BaseRequestDTO<Object> {
	String username;
	String password;

	@Override
	public Object getBean() {
		// TODO Auto-generated method stub
		return null;
	}
}
