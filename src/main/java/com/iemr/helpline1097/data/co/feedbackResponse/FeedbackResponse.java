package com.iemr.helpline1097.data.co.feedbackResponse;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.utils.mapper.OutputMapper;

@Entity

public class FeedbackResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private Long FeedbackResponseID;
	@Expose
	private Long FeedbackRequestID;
	@Expose
	private String ResponseSummary;
	@Expose
	private Integer AuthUserID;
	@Expose
	private String Comments;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	private Timestamp CreatedDate;
	private String ModifiedBy;
	private Timestamp LastModDate;

	public FeedbackResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackResponse(Long feedbackResponseID, Long feedbackRequestID, String responseSummary, Integer authUserID,
			String comments, Boolean deleted, String createdBy, Timestamp createdDate, String modifiedBy,
			Timestamp lastModDate) {
		super();
		FeedbackResponseID = feedbackResponseID;
		FeedbackRequestID = feedbackRequestID;
		ResponseSummary = responseSummary;
		AuthUserID = authUserID;
		Comments = comments;
		Deleted = deleted;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		ModifiedBy = modifiedBy;
		LastModDate = lastModDate;
	}

	public Long getFeedbackResponseID() {
		return FeedbackResponseID;
	}

	public void setFeedbackResponseID(Long feedbackResponseID) {
		FeedbackResponseID = feedbackResponseID;
	}

	public Long getFeedbackRequestID() {
		return FeedbackRequestID;
	}

	public void setFeedbackRequestID(Long feedbackRequestID) {
		FeedbackRequestID = feedbackRequestID;
	}

	public String getResponseSummary() {
		return ResponseSummary;
	}

	public void setResponseSummary(String responseSummary) {
		ResponseSummary = responseSummary;
	}

	public Integer getAuthUserID() {
		return AuthUserID;
	}

	public void setAuthUserID(Integer authUserID) {
		AuthUserID = authUserID;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public Boolean getDeleted() {
		return Deleted;
	}

	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return LastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		LastModDate = lastModDate;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
