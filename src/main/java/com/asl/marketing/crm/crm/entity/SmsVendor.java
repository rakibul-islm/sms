package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsVendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vedId;
	
	private String vedName;
	private String vedContactPerson;
	private String vedContactNo;
	private String vedContactDep;
	private String vedAddress;

}
