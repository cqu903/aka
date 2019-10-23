package com.zerofinance.aka.core.entity.base;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.zerofinance.aka.core.entity.User;

/**
 * 基础数据抽象类
 * 
 * @author roy
 *
 * @param <T>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseBasicData<T> extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String code;

	@CreatedBy
	private User createdBy;

	@LastModifiedBy
	private User LastModifiedBy;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
