package com.iemr.helpline1097.data.co.beneficiary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "i_Beneficiaryeducation")
public class I_BeneficiaryEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Expose
	private Long educationid;
	@Expose
	private String educationtype;
	@Expose
	private Long deleted;
	@Expose
	private String createdby;
	private String modifiedby;
	
	
	public I_BeneficiaryEducation() {
		super();
	}


	public I_BeneficiaryEducation(long educationID, String educationType, Long deleted, String createdBy,
			String modifiedBy) {
		super();
		this.educationid = educationID;
		this.educationtype = educationType;
		this.deleted = deleted;
		this.createdby = createdBy;
		this.modifiedby = modifiedBy;
	}


	public Long getEducationID() {
		return educationid;
	}


	public void setEducationID(long educationID) {
		this.educationid = educationID;
	}


	public String getEducationType() {
		return educationtype;
	}


	public void setEducationType(String educationType) {
		this.educationtype = educationType;
	}


	public Long getDeleted() {
		return deleted;
	}


	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}


	public String getCreatedBy() {
		return createdby;
	}


	public void setCreatedBy(String createdBy) {
		this.createdby = createdBy;
	}


	public String getModifiedBy() {
		return modifiedby;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedby = modifiedBy;
	}
	@Override
	public String toString() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		gsonBuilder.serializeNulls();
		String tostring = gsonBuilder.create().toJson(this);
		return tostring;
	}
}
