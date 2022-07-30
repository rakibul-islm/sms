package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsRateSetup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rid;
	
	private Date start;
	private Date end;
	private double rate;
	private String type;
	private String status;
	private Date startTime;
	private Date endTime;

}
