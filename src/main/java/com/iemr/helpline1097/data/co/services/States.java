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
package com.iemr.helpline1097.data.co.services;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "m_state")
@Data
public class States
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	@Column(name = "StateName")
	@Expose
	private String stateName;
	@Column(name = "StateCode")
	@Expose
	private String stateCode;
	@Column(name = "CountryID")
	@Expose
	private Integer countryID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public States getDefaultContructor()
	{
		return this;
	}

	public States getStates(int StateID, String StateName)
	{
		this.stateID = StateID;
		this.stateName = StateName;
		return this;
	}

	public int getStateID()
	{
		return this.stateID.intValue();
	}

	public void setStateID(int stateID)
	{
		this.stateID = Integer.valueOf(stateID);
	}

	public String getStateIName()
	{
		return this.stateName;
	}

	public void setStateIName(String stateName)
	{
		this.stateName = stateName;
	}

	public String getStateCode()
	{
		return this.stateCode;
	}

	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}

	public int getCountryID()
	{
		return this.countryID.intValue();
	}

	public void setCountryID(int countryID)
	{
		this.countryID = Integer.valueOf(countryID);
	}

	public boolean isDeleted()
	{
		return this.deleted.booleanValue();
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getModifiedBy()
	{
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDate()
	{
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public Timestamp getLastModDate()
	{
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public String getStateName()
	{
		return this.stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
