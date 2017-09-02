package com.iemr.helpline1097.data.co.beneficiary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "i_Beneficiaryoccupation")
public class I_BeneficiaryOccupation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OccupationID")
	@Expose
	private Long occupationid;
	@Column(name = "OccupationType")
	@Expose
	private String occupationtype;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Long deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdby;
	@Column(name = "ModifiedBy")
	private String modifiedby;

	public I_BeneficiaryOccupation() {
	}

	public I_BeneficiaryOccupation(long occupationID, String occupationType, Long deleted, String createdBy,
			String modifiedBy) {
		super();
		this.occupationid = occupationID;
		this.occupationtype = occupationType;
		this.deleted = deleted;
		this.createdby = createdBy;
		this.modifiedby = modifiedBy;
	}

	public Long getOccupationID() {
		return occupationid;
	}

	public String getOccupationType() {
		return occupationtype;
	}

	public void setOccupationType(String occupationType) {
		this.occupationtype = occupationType;
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
