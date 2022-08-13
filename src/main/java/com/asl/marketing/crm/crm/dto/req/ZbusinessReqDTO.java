package com.asl.marketing.crm.crm.dto.req;

import org.springframework.beans.BeanUtils;

import com.asl.marketing.crm.crm.entity.Zbusiness;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ZbusinessReqDTO extends BaseRequestDTO<Zbusiness> {

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
	private byte[] ximage;
	private boolean zactive;

	@Override
	public Zbusiness getBean() {
		Zbusiness z = new Zbusiness();
		BeanUtils.copyProperties(this, z);
		return z;
	}

	
}
