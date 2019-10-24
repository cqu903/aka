package com.zerofinance.aka.core.entity;

import javax.persistence.Entity;

import com.zerofinance.aka.core.entity.base.BaseBasicData;
import com.zerofinance.aka.core.ui.BaseEditPage;
import com.zerofinance.aka.core.ui.BaseListPage;

@Entity
public class OrganizationType extends BaseBasicData<OrganizationType> implements BaseListPage,BaseEditPage{
	
}
