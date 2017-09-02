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
import com.iemr.helpline1097.data.co.feedbackRequest.FeedbackRequest;
import com.iemr.helpline1097.service.co.feedback.FeedbackRequestServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RequestMapping(value = "/iEMR")
@RestController
public class FeedbackRequestController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private FeedbackRequestServiceImpl feedbackRequestServiceImpl;

	@CrossOrigin()
	@RequestMapping(value = "/put/feedbackRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
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
	@RequestMapping(value = "/get/feedbackRequest/{feedbackRequestID}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
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
