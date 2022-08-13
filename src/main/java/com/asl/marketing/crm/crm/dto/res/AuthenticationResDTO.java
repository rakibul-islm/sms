/**
 * 
 */
package com.asl.marketing.crm.crm.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author asl
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthenticationResDTO extends BaseResponseDTO<Object>{
	String token;
}
