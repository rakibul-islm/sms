package com.asl.marketing.crm.crm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SmsVendorPaymentTranaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vedId;
	
	private Long pacId;
	private Date paymentDate;
	private double amount;

}
