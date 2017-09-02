package com.iemr.helpline1097.data.co.beneficiarycall;

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
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.utils.mapper.OutputMapper;

@Entity
// @Table(name = "m_1097servicesmaster")
@Table(name = "m_subservice")
public class SubServices
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SubServiceID")
	@Expose
	private Integer subServiceID;
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "servicesMaster1097", fetch = FetchType.LAZY)
	private List<BenCallServicesMappingHistory> benCallServicesMappingHistories;

	@JsonIgnore
	@Transient
	@OneToMany(mappedBy = "servicesMaster1097", fetch = FetchType.LAZY)
	private List<CategoryDetails> categoryDetails;

	@Column(name = "SubServiceName")
	@Expose
	private String subServiceName;

	@Column(name = "SubServiceDesc")
	@Expose
	private String subServiceDesc;

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

	public Integer getSubServiceID()
	{
		return this.subServiceID;
	}

	public SubServices()
	{
	}

	public SubServices(Integer subServiceID, String subServiceName, String subServiceDesc, Boolean deleted)
	{
		this.subServiceID = subServiceID;
		this.subServiceName = subServiceName;
		this.subServiceDesc = subServiceDesc;
		this.deleted = deleted;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
