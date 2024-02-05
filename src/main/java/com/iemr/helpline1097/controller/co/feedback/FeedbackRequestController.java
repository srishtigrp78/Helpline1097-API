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

import com.iemr.helpline1097.data.co.feedbackRequest.FeedbackRequest;
import com.iemr.helpline1097.service.co.feedback.FeedbackRequestServiceImpl;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/iEMR")
@RestController
public class FeedbackRequestController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private FeedbackRequestServiceImpl feedbackRequestServiceImpl;

	@CrossOrigin()
	@ApiOperation(value = "Create feedback request", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/put/feedbackRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String feedbackCreate(@RequestBody String request) {
		OutputResponse response = new OutputResponse();
		try {
			FeedbackRequest t_feedbackRequest = inputMapper.gson().fromJson(request, FeedbackRequest.class);
			FeedbackRequest savedDetails = feedbackRequestServiceImpl.createFeedbackRequest(t_feedbackRequest);
			response.setResponse(savedDetails.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get feedback request", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/feedbackRequest/{feedbackRequestID}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getFeedbackRequests(@PathVariable("feedbackRequestID") int feedbackRequestID) {
		OutputResponse response = new OutputResponse();
		try {
			FeedbackRequest savedDetails = feedbackRequestServiceImpl.getFeedbackReuest(feedbackRequestID);
			response.setResponse(savedDetails.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

}
