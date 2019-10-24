package com.zerofinance.aka.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.zerofinance.aka.core.entity.base.BaseBasicData;
import com.zerofinance.aka.core.ui.TreeEditPage;
import com.zerofinance.aka.core.ui.TreeListPage;

@Entity
public class Organization extends BaseBasicData<Organization> {

	private Position managePosition;// 负责人职位

	private boolean company = false;// 是否公司

	private boolean virtualOrganization = false;// 是否虚拟组织

	@OneToOne
	private Organization parentOrganization;// 上级组织
	@OneToOne
	private Organization reportingOrganization;// 汇报组织

	@ManyToOne
	private OrganizationType organizationType;
	@OneToMany
	private List<Organization> upperOrganization;// 下级组织

	public Position getManagePosition() {
		return managePosition;
	}

	public void setManagePosition(Position managePosition) {
		this.managePosition = managePosition;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	public boolean isVirtualOrganization() {
		return virtualOrganization;
	}

	public void setVirtualOrganization(boolean virtualOrganization) {
		this.virtualOrganization = virtualOrganization;
	}

	public Organization getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}

	public Organization getReportingOrganization() {
		return reportingOrganization;
	}

	public void setReportingOrganization(Organization reportingOrganization) {
		this.reportingOrganization = reportingOrganization;
	}

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}

	public List<Organization> getUpperOrganization() {
		return upperOrganization;
	}

	public void setUpperOrganization(List<Organization> upperOrganization) {
		this.upperOrganization = upperOrganization;
	}

}
