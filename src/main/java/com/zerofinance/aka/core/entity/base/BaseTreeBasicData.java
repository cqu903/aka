package com.zerofinance.aka.core.entity.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class BaseTreeBasicData<T> extends BaseBasicData<T>{
	
	@OneToOne
	private T parent;
}
