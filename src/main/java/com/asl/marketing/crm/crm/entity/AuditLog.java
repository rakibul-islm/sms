package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long auId;
	
	private Long zid;
	private String messgae;
	private Date messageDateTime;
	private String status;
	private String macId;
	private String ip;

}
