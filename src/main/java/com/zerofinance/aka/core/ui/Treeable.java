package com.zerofinance.aka.core.ui;

import java.util.List;

public interface Treeable<T> {

	List<T> getChildres();
	
	T getParent();
}
