package com.asl.marketing.crm.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mid;
	
	private String mname;
	private String mlink;
	private String lang;
	
}
