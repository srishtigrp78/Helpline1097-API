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


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "m_bencall1097servicesmapping")
@Data
public class BenCallServicesMappingHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenCall97ServiceMapID")
	@Expose
	private BigInteger benCall97ServiceMapID;

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Column(name = "BenCallID")
	@Expose
	private Long benCallID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BenCallID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private BeneficiaryCall beneficiaryCall;

	@Column(name = "SubServiceID")
	@Expose
	private Integer subServiceID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubServiceID", insertable = false, updatable = false, referencedColumnName = "SubServiceID")
	@JsonIgnore
	@Expose
	private SubServices subServices;

	@Column(name = "CategoryID")
	@Expose
	private Integer categoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CategoryID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private CategoryDetails categoryDetails;

	@Column(name = "SubCategoryID")
	@Expose
	private Integer subCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SubCategoryID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private SubCategoryDetails subCategoryDetails;

	@Column(name = "COCategoryID")
	@Expose
	private Integer coCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COCategoryID", insertable = false, updatable = false, referencedColumnName = "categoryID")
	@JsonIgnore
	@Expose
	private CategoryDetails coCategoryDetails;

	@Column(name = "COSubCategoryID")
	@Expose
	private Integer coSubCategoryID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COSubCategoryID", insertable = false, updatable = false, referencedColumnName = "subCategoryID")
	@JsonIgnore
	@Expose
	private SubCategoryDetails coSubCategoryDetails;

	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FeedbackID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private FeedbackDetails feedbackDetails;

	@Column(name = "InstituteDirMapID")
	@Expose
	private Long instituteDirMapID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstituteDirMapID", insertable = false, updatable = false)
	@JsonIgnore
	@Expose
	private DirectoryMapping instituteDirectoryMapping;

	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	@Expose
	private List<DirectoryMapping> referrals = new ArrayList<DirectoryMapping>();
	@Transient
	@Expose
	private List<FeedbackDetails> feedbacks = new ArrayList<FeedbackDetails>();
	@Transient
	@Expose
	private List<SubCategoryDetails> counsellings = new ArrayList<SubCategoryDetails>();
	@Transient
	@Expose
	private List<SubCategoryDetails> informations = new ArrayList<SubCategoryDetails>();
	@Transient
	@Expose
	String requestID;

	public BenCallServicesMappingHistory() {

	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID,
			Integer categoryID, Integer subCategoryID, Boolean deleted, String createdBy) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = categoryID;
		this.subCategoryID = subCategoryID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID, Boolean deleted,
			Integer coCategoryID, Integer coSubCategoryID, String createdBy) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = coCategoryID;
		this.subCategoryID = coSubCategoryID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(Long beneficiaryRegID, Long benCallID, Integer subServiceID, Long feedbackID,
			Boolean deleted, String createdBy) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.feedbackID = feedbackID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(long beneficiaryRegID, Long benCallID, Integer subServiceID,
			Long instituteDirMapID, String createdBy, Boolean deleted) {
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.instituteDirMapID = instituteDirMapID;
		this.deleted = deleted;
		this.createdBy = createdBy;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Integer categoryID, CategoryDetails categoryDetails,
			Integer subCategoryID, SubCategoryDetails subCategoryDetails, Long feedbackID,
			FeedbackDetails feedbackDetails, Long instituteDirMapID, DirectoryMapping instituteDirectoryMapping,
			String createdBy, Timestamp createdDate, Integer coCategoryID, CategoryDetails coCategoryDetails,
			Integer coSubCategoryID, SubCategoryDetails coSubCategoryDetails) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.feedbackID = feedbackID;
		this.feedbackDetails = feedbackDetails;
		this.instituteDirMapID = instituteDirMapID;
		this.instituteDirectoryMapping = instituteDirectoryMapping;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.coCategoryID = coCategoryID;
		this.coCategoryDetails = coCategoryDetails;
		this.coSubCategoryDetails = coSubCategoryDetails;
		this.coCategoryID = coSubCategoryID;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, Integer categoryID, Integer subCategoryID, Long feedbackID, Long instituteDirMapID,
			String createdBy, Timestamp createdDate) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.categoryID = categoryID;
		this.subCategoryID = subCategoryID;
		this.feedbackID = feedbackID;
		this.instituteDirMapID = instituteDirMapID;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Integer categoryID, CategoryDetails categoryDetails,
			Integer subCategoryID, SubCategoryDetails subCategoryDetails, String createdBy, Timestamp createdDate) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, CategoryDetails categoryDetails, Integer categoryID,
			SubCategoryDetails subCategoryDetails, Integer subCategoryID, String createdBy, Timestamp createdDate) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.categoryID = categoryID;
		this.categoryDetails = categoryDetails;
		this.subCategoryID = subCategoryID;
		this.subCategoryDetails = subCategoryDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Long feedbackID, FeedbackDetails feedbackDetails,
			String createdBy, Timestamp createdDate) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.feedbackID = feedbackID;
		this.feedbackDetails = feedbackDetails;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public BenCallServicesMappingHistory(BigInteger benCall97ServiceMapID, Long beneficiaryRegID, Long benCallID,
			Integer subServiceID, SubServices subServices, Long instituteDirMapID,
			DirectoryMapping instituteDirectoryMapping, String createdBy, Timestamp createdDate) {
		this.benCall97ServiceMapID = benCall97ServiceMapID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benCallID = benCallID;
		this.subServiceID = subServiceID;
		this.subServices = subServices;
		this.instituteDirMapID = instituteDirMapID;
		this.instituteDirectoryMapping = instituteDirectoryMapping;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}

	
}
