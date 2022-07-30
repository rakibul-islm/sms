package com.asl.marketing.crm.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsSetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;
	
	private String stemplate;
	private String stype;
	private String scontant;
	private String sword;
	private String schar;
	private String eventType;

}
