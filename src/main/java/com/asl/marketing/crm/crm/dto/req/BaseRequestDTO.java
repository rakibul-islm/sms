package com.asl.marketing.crm.crm.dto.req;

import com.asl.marketing.crm.crm.dto.BaseDTO;

import lombok.Data;

@Data
public abstract class BaseRequestDTO<E> implements BaseDTO<E> {

	public abstract E getBean();

}
