/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.helpline1097.data.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
// @Table(name = "m_1097servicesmaster")
@Table(name = "m_subservice")
@Data
public class SubServices
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubServiceID")
	@Expose
	private Integer subServiceID;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "servicesMaster1097", fetch = FetchType.LAZY)
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;

	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "servicesMaster1097", fetch = FetchType.LAZY)
	private List<CategoryDetails> categoryDetails;

	@Column(name = "SubServiceName")
	@Expose
	private String subServiceName;

	@Column(name = "SubServiceDesc")
	@Expose
	private String subServiceDesc;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;

	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;

	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	public Integer getSubServiceID()
	{
		return this.subServiceID;
	}

	public SubServices()
	{
	}

	public SubServices(Integer subServiceID, String subServiceName, String subServiceDesc, Boolean deleted)
	{
		this.subServiceID = subServiceID;
		this.subServiceName = subServiceName;
		this.subServiceDesc = subServiceDesc;
		this.deleted = deleted;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
