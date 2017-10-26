package com.iemr.helpline1097.data.co.services;

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
import com.iemr.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_institution")
public class InstitutionDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InstitutionID")
	@Expose
	private Integer institutionID;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institutionDetails")
	@JsonIgnore
	@Transient
	private List<DirectoryMapping> instituteDirectory;
	// m_bencall1097servicesmapping
	// m_institutedirectorymapping
	// t_feedback
	@Column(name = "InstitutionName")
	@Expose
	private String institutionName;
	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="StateID", insertable=false, updatable=false)
	// @JsonIgnore
	// private States states;
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="DistrictID", insertable=false, updatable=false)
	// private Districts m_district;
	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="DistrictBranchMappingID", insertable=false,
	// updatable=false)
	// @JsonIgnore
	// private DistrictBranchMapping m_districtbranchmapping;
	@Column(name = "DistrictBranchMappingID")
	@Expose
	private Integer districtBranchMappingID;
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="DistrictBranchMappingID", insertable=false,
	// updatable=false)
	// @JsonIgnore
	// private DistrictBranchMapping m_districtbranchmapping;
	@Column(name = "Address")
	@Expose
	private String address;

	@Column(name = "ContactPerson1")
	@Expose
	private String contactPerson1;
	@Column(name = "ContactNo1")
	@Expose
	private String contactNo1;
	@Column(name = "ContactPerson1_Email")
	@Expose
	private String contactPerson1Email;
	
	@Column(name = "ContactPerson2")
	@Expose
	private String contactPerson2;
	@Column(name = "ContactNo2")
	@Expose
	private String contactNo2;
	@Column(name = "ContactPerson2_Email")
	@Expose
	private String contactPerson2Email;
	
	@Column(name = "ContactPerson3")
	@Expose
	private String contactPerson3;
	@Column(name = "ContactNo3")
	@Expose
	private String contactNo3;
	@Column(name = "ContactPerson3_Email")
	@Expose
	private String contactPerson3Email;
	
	@Column(name = "Website")
	@Expose
	private String website;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	public InstitutionDetails()
	{
	}

	public InstitutionDetails(int institutionID, String institutionName, String address, String contactNo1,
			String contactNo2, String contactNo3)
	{
		this.institutionID = institutionID;
		this.institutionName = institutionName;
		this.address = address;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.contactNo3 = contactNo3;
	}

	public InstitutionDetails(int institutionID, String institutionName, int stateID, int districtID,
			int districtBranchMappingID)
	{
		this.institutionID = institutionID;
		this.institutionName = institutionName;
		this.stateID = stateID;
		this.districtID = districtID;
		this.districtBranchMappingID = districtBranchMappingID;
	}

	public Integer getInstitutionID()
	{
		return institutionID;
	}

	public String getInstitutionName()
	{
		return institutionName;
	}

	public Integer getStateID()
	{
		return stateID;
	}

	public Integer getDistrictID()
	{
		return districtID;
	}

	public Integer getDistrictBranchMappingID()
	{
		return districtBranchMappingID;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getContactNo1()
	{
		return contactNo1;
	}

	public void setContactNo1(String contactNo1)
	{
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2()
	{
		return contactNo2;
	}

	public void setContactNo2(String contactNo2)
	{
		this.contactNo2 = contactNo2;
	}

	public String getContactNo3()
	{
		return contactNo3;
	}

	public void setContactNo3(String contactNo3)
	{
		this.contactNo3 = contactNo3;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

	public Integer getBlockID()
	{
		return this.blockID;
	}
}
