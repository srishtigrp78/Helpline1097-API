package com.iemr.helpline1097.data.co.feedback;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "t_FeedbackRequest")
@Data
public class FeedbackRequestDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long feedbackRequestID;
	@Expose
	private Long feedbackID;
	@Expose
	private String feedbackSupSummary;
	@Expose
	private Integer supUserID;
	@Expose
	private String comments;
	@Expose
	private Boolean deleted;
	@Expose
	private String createdBy;
	// private Timestamp CreatedDate;
	private String modifiedBy;
	private Timestamp lastModDate;

	@OneToOne
	@JoinColumn(referencedColumnName = "FeedbackID")
	@JsonIgnore
	private FeedbackDetails feedback;

	/**
	 * @return the feedbackRequestID
	 */
	public Long getFeedbackRequestID()
	{
		return feedbackRequestID;
	}

	/**
	 * @param feedbackRequestID
	 *            the feedbackRequestID to set
	 */
	public void setFeedbackRequestID(Long feedbackRequestID)
	{
		this.feedbackRequestID = feedbackRequestID;
	}

	/**
	 * @return the feedbackID
	 */
	public Long getFeedbackID()
	{
		return feedbackID;
	}

	/**
	 * @param feedbackID
	 *            the feedbackID to set
	 */
	public void setFeedbackID(Long feedbackID)
	{
		this.feedbackID = feedbackID;
	}

	/**
	 * @return the feedbackSupSummary
	 */
	public String getFeedbackSupSummary()
	{
		return feedbackSupSummary;
	}

	/**
	 * @param feedbackSupSummary
	 *            the feedbackSupSummary to set
	 */
	public void setFeedbackSupSummary(String feedbackSupSummary)
	{
		this.feedbackSupSummary = feedbackSupSummary;
	}

	/**
	 * @return the supUserID
	 */
	public Integer getSupUserID()
	{
		return supUserID;
	}

	/**
	 * @param supUserID
	 *            the supUserID to set
	 */
	public void setSupUserID(Integer supUserID)
	{
		this.supUserID = supUserID;
	}

	/**
	 * @return the comments
	 */
	public String getComments()
	{
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted()
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

	/**
	 * @return the feedback
	 */
	public FeedbackDetails getFeedback()
	{
		return feedback;
	}

	/**
	 * @param feedback
	 *            the feedback to set
	 */
	public void setFeedback(FeedbackDetails feedback)
	{
		this.feedback = feedback;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
