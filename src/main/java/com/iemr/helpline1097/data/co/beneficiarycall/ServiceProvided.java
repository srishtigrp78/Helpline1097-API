package com.iemr.helpline1097.data.co.beneficiarycall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

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
