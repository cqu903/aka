package com.zerofinance.aka.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.zerofinance.aka.core.entity.base.BaseBasicData;

@Entity
public class Position extends BaseBasicData<Position> {

	@ManyToOne(optional = false)
	private Organization belongsOrganization;

	private String description;
	@OneToOne
	private Position adminPosition;// 上级职位

	@OneToOne
	private Position reportingPostion;// 汇报职位

	public Organization getBelongsOrganization() {
		return belongsOrganization;
	}

	public void setBelongsOrganization(Organization belongsOrganization) {
		this.belongsOrganization = belongsOrganization;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Position getAdminPosition() {
		return adminPosition;
	}

	public void setAdminPosition(Position adminPosition) {
		this.adminPosition = adminPosition;
	}

	public Position getReportingPostion() {
		return reportingPostion;
	}

	public void setReportingPostion(Position reportingPostion) {
		this.reportingPostion = reportingPostion;
	}

}
