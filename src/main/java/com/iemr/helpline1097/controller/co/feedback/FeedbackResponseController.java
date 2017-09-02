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
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RequestMapping(value = "/iEMR")
@RestController
public class FeedbackResponseController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private FeedbackResponseServiceImpl feedbackResponseServiceImpl;

	@CrossOrigin()
	@RequestMapping(value = "/put/feedbackResponse", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String feedbackCreate(@RequestBody String request) {
		FeedbackResponse t_feedbackResponse = inputMapper.gson().fromJson(request, FeedbackResponse.class);
		OutputResponse response = new OutputResponse();
		try {
			FeedbackResponse savedDetails = feedbackResponseServiceImpl.createFeedbackResponse(t_feedbackResponse);
			response.setResponse(savedDetails.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/get/feedbackResponse/{feedbackResponseID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getFeedback(@PathVariable("feedbackResponseID") int feedbackResponseID) {
		OutputResponse response = new OutputResponse();
		try {
			FeedbackResponse savedDetails = feedbackResponseServiceImpl.getFeedbackResponse(feedbackResponseID);
			response.setResponse(savedDetails.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

}
