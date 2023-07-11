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
package com.iemr.helpline1097.controller.co.feedback;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.controller.co.services.CommonController;
import com.iemr.helpline1097.data.co.feedbackResponse.FeedbackResponse;
import com.iemr.helpline1097.service.co.feedback.FeedbackResponseServiceImpl;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

@RequestMapping(value = "/iEMR")
@RestController
public class FeedbackResponseController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private FeedbackResponseServiceImpl feedbackResponseServiceImpl;

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/put/feedbackResponse",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String feedbackCreate(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			FeedbackResponse t_feedbackResponse = inputMapper.gson().fromJson(request, FeedbackResponse.class);
			FeedbackResponse savedDetails = feedbackResponseServiceImpl.createFeedbackResponse(t_feedbackResponse);
			response.setResponse(savedDetails.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/get/feedbackResponse/{feedbackResponseID}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	@Deprecated
	public String getFeedback(@PathVariable("feedbackResponseID") int feedbackResponseID)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			FeedbackResponse savedDetails = feedbackResponseServiceImpl.getFeedbackResponse(feedbackResponseID);
			response.setResponse(savedDetails.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

}
