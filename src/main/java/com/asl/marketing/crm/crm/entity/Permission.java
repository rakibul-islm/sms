package com.asl.marketing.crm.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	
	private Long mid;
	private Long rid;
	private String accessType;
	
}
