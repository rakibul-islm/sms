package com.asl.marketing.crm.crm.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String msg;
	private String details;
	
	public ExceptionResponse(Date timestamp, String msg, String details) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public String getDetails() {
		return details;
	}

	

}
