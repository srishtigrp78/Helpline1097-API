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

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "m_serviceprovided")
@Data
public class ServiceProvided
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long ServiceID;

	@Expose
	private String InformationService;
	@Expose
	private String CounsellingService;
	@Expose
	private String ReferralService;
	@Expose
	private String FeedbackSystem;

	public ServiceProvided()
	{
		super();
	}

	public ServiceProvided(Long serviceID, String informationService, String counsellingService, String referralService,
			String feedbackSystem)
	{
		super();
		ServiceID = serviceID;
		InformationService = informationService;
		CounsellingService = counsellingService;
		ReferralService = referralService;
		FeedbackSystem = feedbackSystem;
	}

	public Long getServiceID()
	{
		return ServiceID;
	}

	public void setServiceID(Long serviceID)
	{
		ServiceID = serviceID;
	}

	public String getInformationService()
	{
		return InformationService;
	}

	public void setInformationService(String informationService)
	{
		InformationService = informationService;
	}

	public String getCounsellingService()
	{
		return CounsellingService;
	}

	public void setCounsellingService(String counsellingService)
	{
		CounsellingService = counsellingService;
	}

	public String getReferralService()
	{
		return ReferralService;
	}

	public void setReferralService(String referralService)
	{
		ReferralService = referralService;
	}

	public String getFeedbackSystem()
	{
		return FeedbackSystem;
	}

	public void setFeedbackSystem(String feedbackSystem)
	{
		FeedbackSystem = feedbackSystem;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
