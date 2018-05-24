package com.iemr.helpline1097.data.co.feedback;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_severity")
@Data
public class Severity
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SeverityID")
	private Integer severityID;
	@Column(name = "SeverityTypeName")
	private String severityTypeName;
	@Column(name = "SeverityDesc")
	private String severityDesc;
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Column(name = "CreatedBy")
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	public Severity()
	{
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
