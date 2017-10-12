package com.iemr.helpline1097.data.co.services;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_institutedirectorymapping")
public class DirectoryMapping
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InstituteDirMapID")
	@Expose
	private Long instituteDirMapID;
	@JsonIgnore
	@OneToMany(mappedBy = "instituteDirectoryMapping", fetch = FetchType.LAZY)
	@Transient
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;

	@Column(name = "InstitutionID")
	@Expose
	private Integer institutionID;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "InstitutionID", insertable = false, updatable = false)
	@Expose
	private InstitutionDetails institutionDetails;

	@Column(name = "InstituteDirectoryID")
	@Expose
	private Integer instituteDirectoryID;
	@Column(name = "InstituteSubDirectoryID")
	@Expose
	private Integer instituteSubDirectoryID;
	@Expose
	@Column(name = "InstituteRouteDirectoryID")
	private Integer instituteRouteDirectoryID;
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

	public DirectoryMapping()
	{
	}

	public DirectoryMapping(Long instituteDirMapID, Integer institutionID, String institutionName, String address,
			String contactNo1, String contactNo2, String contactNo3)
	{
		this.instituteDirMapID = instituteDirMapID;
		this.institutionDetails = new InstitutionDetails(institutionID, institutionName, address, contactNo1,
				contactNo2, contactNo3);
	}

	/**
	 * @return the instituteDirMapID
	 */
	public Long getInstituteDirMapID()
	{
		return instituteDirMapID;
	}

	/**
	 * @return the institutionID
	 */
	public Integer getInstitutionID()
	{
		return institutionID;
	}

	/**
	 * @return the institutionDetails
	 */
	public InstitutionDetails getInstitute()
	{
		return institutionDetails;
	}

	/**
	 * @return the instituteDirectoryID
	 */
	public Integer getInstituteDirectoryID()
	{
		return instituteDirectoryID;
	}

	/**
	 * @return the instituteSubDirectoryID
	 */
	public Integer getInstituteSubDirectoryID()
	{
		return instituteSubDirectoryID;
	}

	/**
	 * @return the instituteRouteDirectoryID
	 */
	public Integer getInstituteRouteDirectoryID()
	{
		return instituteRouteDirectoryID;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted()
	{
		return deleted;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy()
	{
		return modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setInstitutionDetails(InstitutionDetails institutionDetails)
	{
		this.institutionDetails = institutionDetails;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
