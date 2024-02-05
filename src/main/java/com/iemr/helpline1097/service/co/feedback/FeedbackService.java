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
package com.iemr.helpline1097.service.co.feedback;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;

public interface FeedbackService {

	public List<FeedbackDetails> getFeedbackRequests(long id);

	public List<FeedbackDetails> getFeedbackRequest(long id);

	public String updateFeedback(FeedbackDetails feedbackDetails);

	public FeedbackDetails createFeedback(FeedbackDetails feedbackDetails);

	String saveFeedbackFromCustomer(String feedbackDetails, HttpServletRequest request) throws Exception;

}
