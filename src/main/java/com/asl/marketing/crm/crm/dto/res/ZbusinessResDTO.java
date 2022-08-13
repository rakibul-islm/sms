package com.asl.marketing.crm.crm.dto.res;

import org.springframework.beans.BeanUtils;

import com.asl.marketing.crm.crm.entity.Zbusiness;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ZbusinessResDTO extends BaseResponseDTO<Zbusiness>{

	public ZbusinessResDTO(Zbusiness zbusiness) {
		BeanUtils.copyProperties(zbusiness, this);
	}

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
}
