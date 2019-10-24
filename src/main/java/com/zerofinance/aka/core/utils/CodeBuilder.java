package com.zerofinance.aka.core.utils;

import com.zerofinance.aka.core.entity.base.BaseEntity;

public interface CodeBuilder {
	/**
	 * 构建代码
	 * @param clazz
	 */
	void buildCode(Class<? extends BaseEntity> clazz);
}
