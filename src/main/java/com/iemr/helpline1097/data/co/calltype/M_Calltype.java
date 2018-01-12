package com.iemr.helpline1097.data.co.calltype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

@Entity
public class M_Calltype
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long id;
	@Expose
	private String callType;
	@Expose
	private String remarks;
	@Expose
	private String invalidType;

	public M_Calltype()
	{
		super();
	}

	public M_Calltype(String callType, String remarks, String invalidType)
	{

		this.callType = callType;
		this.remarks = remarks;
		this.invalidType = invalidType;
	}

	public Long getId()
	{
		return id;
	}

	public String getCallType()
	{
		return callType;
	}

	public void setCallType(String callType)
	{
		this.callType = callType;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public String getInvalidType()
	{
		return invalidType;
	}

	public void setInvalidType(String invalidType)
	{
		this.invalidType = invalidType;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
