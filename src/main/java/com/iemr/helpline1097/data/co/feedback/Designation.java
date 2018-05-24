package com.iemr.helpline1097.data.co.feedback;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_designation")
@Data
public class Designation
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
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	public Designation()
	{

	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
