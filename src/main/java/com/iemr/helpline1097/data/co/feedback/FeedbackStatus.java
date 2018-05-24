package com.iemr.helpline1097.data.co.feedback;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_feedbackstatus")
@Data
public class FeedbackStatus
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FeedbackStatusID")
	@Expose
	private Integer feedbackStatusID;
	@Column(name = "FeedbackStatus")
	@Expose
	private String feedbackStatus;
	@Column(name = "FeedbackStatusDesc")
	@Expose
	private String feedbackStatusDesc;
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
	private Integer providerServiceMapID;

	public FeedbackStatus()
	{
	}

	@Override
	public String toString()
	{
		return OutputMapper.gson().toJson(this);
	}
}
