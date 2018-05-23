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

import lombok.Data;

@Entity
@Table(name = "m_institutedirectory")
@Data
public class Directory
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InstituteDirectoryID")
	@Expose
	private Integer instituteDirectoryID;

	@Column(name = "InstituteDirectoryName")
	@Expose
	private String instituteDirectoryName;
	@Column(name = "InstituteDirectoryDesc")
	@Expose
	private String instituteDirectoryDesc;
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
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	protected Directory()
	{
	}

	public Directory(Integer institutionID, String directoryName)
	{
		this.instituteDirectoryID = institutionID;
		this.instituteDirectoryName = directoryName;
	}

	public Integer getProviderServiceMapID()
	{
		return providerServiceMapID;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
