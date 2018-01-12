package com.iemr.helpline1097.data.co.feedback;

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

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_feedback")
public class FeedbackDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	// @JsonIgnore
	// @OneToMany(mappedBy = "feedbackDetails", fetch = FetchType.LAZY)
	// @Transient
	// private List<BenCallServicesMappingHistory>
	// benCallServicesMappingHistories;

	@Column(name = "InstitutionID")
	@Expose
	private Long institutionID;
	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@Column(name = "SeverityID")
	@Expose
	private Short severityID;
	@Column(name = "FeedbackTypeID")
	@Expose
	private Short feedbackTypeID;
	@Column(name = "FeedbackStatusID")
	@Expose
	private Short feedbackStatusID;
	@Column(name = "Feedback")
	@Expose
	private String feedback;
	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer serviceID;
	@Column(name = "UserID")
	@Expose
	private Integer userID;
	@Column(name = "SMSPhoneNo")
	@Expose
	private String sMSPhoneNo;
	@Column(name = "ServiceAvailDate")
	@Expose
	private Timestamp serviceAvailDate;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	@Expose
	private Long benCallID;

	@Transient
	@Expose
	private Integer subServiceID;

	public FeedbackDetails()
	{

	}

	public FeedbackDetails(Long feedbackID, Long institutionID, Integer designationID, Short severityID,
			Short feedbackTypeID, Short feedbackStatusID, String feedback, Long beneficiaryRegID, Integer serviceID,
			Integer userID, String sMSPhoneNo, Timestamp serviceAvailDate, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		super();
		this.feedbackID = feedbackID;
		this.institutionID = institutionID;
		this.designationID = designationID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.beneficiaryRegID = beneficiaryRegID;
		this.serviceID = serviceID;
		this.userID = userID;
		this.sMSPhoneNo = sMSPhoneNo;
		this.serviceAvailDate = serviceAvailDate;
		this.deleted = deleted;
		this.createdBy = createdBy;
		CreatedDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public FeedbackDetails(Long feedbackID, Short severityID, Short feedbackTypeID, Short feedbackStatusID,
			String feedback, String createdBy)
	{
		this.feedbackID = feedbackID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.createdBy = createdBy;
	}

	public Long getFeedbackID()
	{
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID)
	{
		this.feedbackID = feedbackID;
	}

	public Long getInstitutionID()
	{
		return institutionID;
	}

	public void setInstitutionID(Long institutionID)
	{
		this.institutionID = institutionID;
	}

	public Integer getDesignationID()
	{
		return designationID;
	}

	public void setDesignationID(Integer designationID)
	{
		this.designationID = designationID;
	}

	public Short getSeverityID()
	{
		return severityID;
	}

	public void setSeverityID(Short severityID)
	{
		this.severityID = severityID;
	}

	public Short getFeedbackTypeID()
	{
		return feedbackTypeID;
	}

	public void setFeedbackTypeID(Short feedbackTypeID)
	{
		this.feedbackTypeID = feedbackTypeID;
	}

	public Short getFeedbackStatusID()
	{
		return feedbackStatusID;
	}

	public void setFeedbackStatusID(Short feedbackStatusID)
	{
		this.feedbackStatusID = feedbackStatusID;
	}

	public String getFeedback()
	{
		return feedback;
	}

	public void setFeedback(String feedback)
	{
		this.feedback = feedback;
	}

	public Long getBeneficiaryRegID()
	{
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID)
	{
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Integer getServiceID()
	{
		return serviceID;
	}

	public void setServiceID(Integer serviceID)
	{
		this.serviceID = serviceID;
	}

	public Integer getUserID()
	{
		return userID;
	}

	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}

	public String getsMSPhoneNo()
	{
		return sMSPhoneNo;
	}

	public void setsMSPhoneNo(String sMSPhoneNo)
	{
		this.sMSPhoneNo = sMSPhoneNo;
	}

	public Timestamp getServiceAvailDate()
	{
		return serviceAvailDate;
	}

	public void setServiceAvailDate(Timestamp serviceAvailDate)
	{
		this.serviceAvailDate = serviceAvailDate;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
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
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public Long getBenCallID()
	{
		return benCallID;
	}

	public Integer getSubServiceID()
	{
		return subServiceID;
	}

	public void setBenCallID(Long benCallID)
	{
		this.benCallID = benCallID;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feedback")
	private List<FeedbackRequestDetails> feedbackRequestDetails;

	/**
	 * @return the feedbackRquestDetails
	 */
	public List<FeedbackRequestDetails> getFeedbackRequestDetails()
	{
		return feedbackRequestDetails;
	}

	/**
	 * @param feedbackRquestDetails
	 *            the feedbackRquestDetails to set
	 */
	public void setFeedbackRequestDetails(List<FeedbackRequestDetails> feedbackRequestDetails)
	{
		this.feedbackRequestDetails = feedbackRequestDetails;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
