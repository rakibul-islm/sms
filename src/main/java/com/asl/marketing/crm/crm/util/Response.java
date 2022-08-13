/**
 * 
 */
package com.asl.marketing.crm.crm.util;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import lombok.Data;

/**
 * @author asl
 *
 */
@Data
public class Response<R> {

	private boolean success = true;
	private boolean info = false;
	private boolean warning = false;
	private boolean valid = false;

	private String code;
	private String message;

	private Map<String, R> model;
	private List<R> items;
	private R obj;
	private Page<R> page;
}
