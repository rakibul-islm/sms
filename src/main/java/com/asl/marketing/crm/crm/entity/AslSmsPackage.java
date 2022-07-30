package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AslSmsPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long zid;
	
	private Long rid;
	private String paymentMethod;
	private Date startTime;
	private Date endTime;
	private int billingPeriod;
	private double balance;

}
