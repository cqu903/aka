package com.zerofinance.aka.core.entity.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseBill extends BaseEntity{
	private String billNo;
}
