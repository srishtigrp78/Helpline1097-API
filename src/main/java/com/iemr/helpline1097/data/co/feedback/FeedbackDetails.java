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
package com.iemr.helpline1097.data.co.feedback;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.services.DistrictBlock;
import com.iemr.helpline1097.data.co.services.DistrictBranchMapping;
import com.iemr.helpline1097.data.co.services.Districts;
import com.iemr.helpline1097.data.co.services.Institute;
import com.iemr.helpline1097.data.co.services.States;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_feedback")
@Data
public class FeedbackDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	@Column(name = "requestID")
	@Expose
	private String requestID;
	@Column(name = "InstitutionID")
	@Expose
	private Long institutionID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstitutionID", insertable = false, updatable = false)
	@Expose
	private Institute institute;

	@Column(name = "InstitutionTypeID")
	@Expose
	private Long institutionTypeID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "institutionTypeID", insertable = false, updatable = false)
	@Expose
	private InstituteType instituteType;

	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	private Designation designation;

	@Column(name = "SeverityID")
	@Expose
	private Short severityID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SeverityID", insertable = false, updatable = false)
	@Expose
	private Severity severity;

	@Column(name = "FeedbackTypeID")
	@Expose
	private Short feedbackTypeID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "feedbackTypeID", insertable = false, updatable = false)
	@Expose
	private FeedbackType FeedbackTypeID;

	@Column(name = "FeedbackStatusID")
	@Expose
	private Short feedbackStatusID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FeedbackStatusID", insertable = false, updatable = false)
	@Expose
	private FeedbackStatus feedbackStatus;

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

	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "StateID", insertable = false, updatable = false)
	@Expose
	private States states;
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DistrictID", insertable = false, updatable = false)
	@Expose
	private Districts district;
	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BlockID", insertable = false, updatable = false)
	@Expose
	private DistrictBlock districtBlock;
	@Column(name = "DistrictBranchID")
	@Expose
	private Integer districtBranchID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "DistrictBranchID", insertable = false, updatable = false, name = "DistrictBranchID")
	@Expose
	private DistrictBranchMapping m_districtbranchmapping;

	@Transient
	@Expose
	private Long benCallID;

	@Transient
	@Expose
	private Integer subServiceID;

	@Column(name = "institutionname")
	@Expose
	private String instiName;

	@Transient
	@Expose
	private String instituteName = "";
	@Transient
	@Expose
	private Long instituteTypeID;

	public FeedbackDetails() {

	}

	public FeedbackDetails(Long feedbackID, Long institutionID, Integer designationID, Short severityID,
			Short feedbackTypeID, Short feedbackStatusID, String feedback, Long beneficiaryRegID, Integer serviceID,
			Integer userID, String sMSPhoneNo, Timestamp serviceAvailDate, Boolean deleted, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
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
			String feedback, String createdBy) {
		this.feedbackID = feedbackID;
		this.severityID = severityID;
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackStatusID = feedbackStatusID;
		this.feedback = feedback;
		this.createdBy = createdBy;
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Long getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(Long institutionID) {
		this.institutionID = institutionID;
	}

	public Integer getDesignationID() {
		return designationID;
	}

	public void setDesignationID(Integer designationID) {
		this.designationID = designationID;
	}

	public Short getSeverityID() {
		return severityID;
	}

	public void setSeverityID(Short severityID) {
		this.severityID = severityID;
	}

	public Short getFeedbackTypeID() {
		return feedbackTypeID;
	}

	public void setFeedbackTypeID(Short feedbackTypeID) {
		this.feedbackTypeID = feedbackTypeID;
	}

	public Short getFeedbackStatusID() {
		return feedbackStatusID;
	}

	public void setFeedbackStatusID(Short feedbackStatusID) {
		this.feedbackStatusID = feedbackStatusID;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getsMSPhoneNo() {
		return sMSPhoneNo;
	}

	public void setsMSPhoneNo(String sMSPhoneNo) {
		this.sMSPhoneNo = sMSPhoneNo;
	}

	public Timestamp getServiceAvailDate() {
		return serviceAvailDate;
	}

	public void setServiceAvailDate(Timestamp serviceAvailDate) {
		this.serviceAvailDate = serviceAvailDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getBenCallID() {
		return benCallID;
	}

	public Integer getSubServiceID() {
		return subServiceID;
	}

	public void setBenCallID(Long benCallID) {
		this.benCallID = benCallID;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feedback")
	private List<FeedbackRequestDetails> feedbackRequestDetails;

	/**
	 * @return the feedbackRquestDetails
	 */
	public List<FeedbackRequestDetails> getFeedbackRequestDetails() {
		return feedbackRequestDetails;
	}

	/**
	 * @param feedbackRequestDetails the feedbackRquestDetails to set
	 */
	public void setFeedbackRequestDetails(List<FeedbackRequestDetails> feedbackRequestDetails) {
		this.feedbackRequestDetails = feedbackRequestDetails;
	}

	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}
}
