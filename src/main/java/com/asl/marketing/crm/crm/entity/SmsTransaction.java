package com.asl.marketing.crm.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long zid;
	
	private Long sid;
	private Long schid;
	private String phoneno;
	private String status;

}
