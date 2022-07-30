package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long schid;
	
	private Long zid;
	private Long sid;
	private Date eventDate;
	private Date eventTime;
	private String eventType;
	
}
