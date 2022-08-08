package com.asl.marketing.crm.crm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Zbusiness {
	
	@Id
	@Basic(optional = false)
	private Long zid;
	
	private String name;
	private String address;
	private String email;
	private String contactno;
	private String xcity;
	private String zuuserid;
	private String xcountry;
	private String xcur;
	private String xsignatory;
	private String xtin;
	private String xurl;
	private String xvatregno;
	private String zorg;
	private String xdsep;
	private String xshopno;
	private String xresource;
	private String customertype;
	private String xbimage;
	
	@Column(nullable = true)
	private byte[] ximage;
	
	@Column(nullable = true)
	private boolean zactive;

}
