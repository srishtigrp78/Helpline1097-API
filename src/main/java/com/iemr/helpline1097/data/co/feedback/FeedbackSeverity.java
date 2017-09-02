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
import com.iemr.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_severity")
public class FeedbackSeverity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SeverityID")
	@Expose
	private Integer severityID;
	// t_feedback
	@Column(name = "SeverityTypeName")
	@Expose
	private String severityTypeName;
	@Column(name = "SeverityDesc")
	@Expose
	private String severityDesc;
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

	public FeedbackSeverity() {

	}

	public FeedbackSeverity(Integer severityID, String severityTypeName) {
		this.severityID = severityID;
		this.severityTypeName = severityTypeName;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
