package com.iemr.helpline1097.data.co.services;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_designation")
public class DesignationDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@Column(name = "DesignationName")
	@Expose
	private String designationName;
	@Column(name = "DesignationDesc")
	@Expose
	private String designationDesc;
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

	/**
	 * @return the designationID
	 */
	public Integer getDesignationID()
	{
		return designationID;
	}

	/**
	 * @param designationID
	 *            the designationID to set
	 */
	public void setDesignationID(Integer designationID)
	{
		this.designationID = designationID;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName()
	{
		return designationName;
	}

	/**
	 * @param designationName
	 *            the designationName to set
	 */
	public void setDesignationName(String designationName)
	{
		this.designationName = designationName;
	}

	/**
	 * @return the designationDesc
	 */
	public String getDesignationDesc()
	{
		return designationDesc;
	}

	/**
	 * @param designationDesc
	 *            the designationDesc to set
	 */
	public void setDesignationDesc(String designationDesc)
	{
		this.designationDesc = designationDesc;
	}

	/**
	 * @return the deleted
	 */
	public Boolean isDeleted()
	{
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy()
	{
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	/**
	 * @param lastModDate
	 *            the lastModDate to set
	 */
	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public DesignationDetails()
	{
	}

	public DesignationDetails(Integer designationId, String designationName)
	{
		this.designationID = designationId;
		this.designationName = designationName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
