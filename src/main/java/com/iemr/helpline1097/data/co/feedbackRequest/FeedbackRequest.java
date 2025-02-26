/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.helpline1097.data.co.feedbackRequest;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;
import com.iemr.helpline1097.utils.mapper.OutputMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class FeedbackRequest
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	private Long FeedbackRequestID;
	@Expose
	private String FeedbackSupSummary;
	@Expose
	private Integer SupUserID;
	@Expose
	private String Comments;
	@Expose
	private Boolean Deleted;
	@Expose
	private String CreatedBy;
	private Timestamp CreatedDate;
	private String ModifiedBy;
	private Timestamp LastModDate;

	public FeedbackRequest()
	{
		super();
	}

	public FeedbackRequest(Long feedbackRequestID, String feedbackSupSummary, Integer supUserID, String comments,
			Boolean deleted, String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate)
	{
		super();
		FeedbackRequestID = feedbackRequestID;
		FeedbackSupSummary = feedbackSupSummary;
		SupUserID = supUserID;
		Comments = comments;
		Deleted = deleted;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		ModifiedBy = modifiedBy;
		LastModDate = lastModDate;
	}

	public Long getFeedbackRequestID()
	{
		return FeedbackRequestID;
	}

	public void setFeedbackRequestID(Long feedbackRequestID)
	{
		FeedbackRequestID = feedbackRequestID;
	}

	public String getFeedbackSupSummary()
	{
		return FeedbackSupSummary;
	}

	public void setFeedbackSupSummary(String feedbackSupSummary)
	{
		FeedbackSupSummary = feedbackSupSummary;
	}

	public Integer getSupUserID()
	{
		return SupUserID;
	}

	public void setSupUserID(Integer supUserID)
	{
		SupUserID = supUserID;
	}

	public String getComments()
	{
		return Comments;
	}

	public void setComments(String comments)
	{
		Comments = comments;
	}

	public Boolean getDeleted()
	{
		return Deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		Deleted = deleted;
	}

	public String getCreatedBy()
	{
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy)
	{
		CreatedBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		CreatedDate = createdDate;
	}

	public String getModifiedBy()
	{
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		ModifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return LastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		LastModDate = lastModDate;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
