
package com.iemr.helpline1097.data.co.beneficiary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Author: Neeraj Kumar (298657) Date: 02-06-2017
 * 
 */

@Entity
@Table(name = "t_Feedback")
public class T_Feedback
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long FeedbackID;
	@Expose
	private Integer InstitutionID;
	@Expose
	private Integer DesignationID;
	@Expose
	private Integer SeverityID;
	@Expose
	private Integer FeedbackTypeID;
	@Expose
	private Integer FeedbackStatusID;
	@Expose
	private String Feedback;
	@Expose
	private Long BeneficiaryRegID;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer ServiceID;
	@Expose
	private Integer UserID;
	@Expose
	private String SMSPhoneNo;
	@Expose
	private Timestamp ServiceAvailDate;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	private String ModifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp LastModDate;

	public T_Feedback(Long feedbackID, Integer institutionID, Integer designationID, Integer severityID,
			Integer feedbackTypeID, Integer feedbackStatusID, String feedback, Long beneficiaryRegID, Integer serviceID,
			Integer userID, String sMSPhoneNo, Timestamp serviceAvailDate, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		super();
		FeedbackID = feedbackID;
		InstitutionID = institutionID;
		DesignationID = designationID;
		SeverityID = severityID;
		FeedbackTypeID = feedbackTypeID;
		FeedbackStatusID = feedbackStatusID;
		Feedback = feedback;
		BeneficiaryRegID = beneficiaryRegID;
		ServiceID = serviceID;
		UserID = userID;
		SMSPhoneNo = sMSPhoneNo;
		ServiceAvailDate = serviceAvailDate;
		Deleted = deleted;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		ModifiedBy = modifiedBy;
		LastModDate = lastModDate;
	}

	public Long getFeedbackID()
	{
		return FeedbackID;
	}

	public void setFeedbackID(Long feedbackID)
	{
		FeedbackID = feedbackID;
	}

	public Integer getInstitutionID()
	{
		return InstitutionID;
	}

	public void setInstitutionID(Integer institutionID)
	{
		InstitutionID = institutionID;
	}

	public Integer getDesignationID()
	{
		return DesignationID;
	}

	public void setDesignationID(Integer designationID)
	{
		DesignationID = designationID;
	}

	public Integer getSeverityID()
	{
		return SeverityID;
	}

	public void setSeverityID(Integer severityID)
	{
		SeverityID = severityID;
	}

	public Integer getFeedbackTypeID()
	{
		return FeedbackTypeID;
	}

	public void setFeedbackTypeID(Integer feedbackTypeID)
	{
		FeedbackTypeID = feedbackTypeID;
	}

	public Integer getFeedbackStatusID()
	{
		return FeedbackStatusID;
	}

	public void setFeedbackStatusID(Integer feedbackStatusID)
	{
		FeedbackStatusID = feedbackStatusID;
	}

	public String getFeedback()
	{
		return Feedback;
	}

	public void setFeedback(String feedback)
	{
		Feedback = feedback;
	}

	public Long getBeneficiaryRegID()
	{
		return BeneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID)
	{
		BeneficiaryRegID = beneficiaryRegID;
	}

	public Integer getServiceID()
	{
		return ServiceID;
	}

	public void setServiceID(Integer serviceID)
	{
		ServiceID = serviceID;
	}

	public Integer getUserID()
	{
		return UserID;
	}

	public void setUserID(Integer userID)
	{
		UserID = userID;
	}

	public String getSMSPhoneNo()
	{
		return SMSPhoneNo;
	}

	public void setSMSPhoneNo(String sMSPhoneNo)
	{
		SMSPhoneNo = sMSPhoneNo;
	}

	public Timestamp getServiceAvailDate()
	{
		return ServiceAvailDate;
	}

	public void setServiceAvailDate(Timestamp serviceAvailDate)
	{
		ServiceAvailDate = serviceAvailDate;
	}

	public Boolean getDeleted()
	{
		return Deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		Deleted = deleted;
	}

	public String getCreatedBy()
	{
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy)
	{
		CreatedBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		CreatedDate = createdDate;
	}

	public String getModifiedBy()
	{
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		ModifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return LastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		LastModDate = lastModDate;
	}

	@Override
	public String toString()
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls();
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
