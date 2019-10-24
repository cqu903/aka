package com.zerofinance.aka.core.utils;

import com.zerofinance.aka.core.entity.base.BaseEntity;

public class TreeListPageCodeBuilder implements CodeBuilder {

	@Override
	public void buildCode(Class<? extends BaseEntity> clazz) {
		System.out.println("TreeListPageCodeBuilder");
	}

}
