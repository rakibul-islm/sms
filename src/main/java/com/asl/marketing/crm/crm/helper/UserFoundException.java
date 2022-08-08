package com.asl.marketing.crm.crm.helper;

public class UserFoundException extends Exception{

	public UserFoundException() {
		super("Username is alreary exist !! Please try another or Login.");
	}

	public UserFoundException(String msg) {
		super(msg);
	}

}

