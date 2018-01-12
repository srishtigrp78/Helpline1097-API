package com.iemr.helpline1097.data.co.feedback;

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
@Table(name = "m_feedbacktype")
public class FeedbackType
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FeedbackTypeID")
	@Expose
	private Integer feedbackTypeID;
	@Column(name = "FeedbackTypeName")
	@Expose
	private String feedbackTypeName;
	@Column(name = "FeedbackDesc")
	@Expose
	private String feedbackDesc;
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

	public FeedbackType()
	{

	}

	public FeedbackType(Integer feedbackTypeID, String feedbackTypeName)
	{
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackTypeName = feedbackTypeName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
