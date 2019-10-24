package com.zerofinance.aka.core.ui;

import com.zerofinance.aka.core.annoations.Builder;
import com.zerofinance.aka.core.utils.TreeListPageCodeBuilder;

@Builder(TreeListPageCodeBuilder.class)
public interface TreeListPage<T> extends Treeable<T> {

}
