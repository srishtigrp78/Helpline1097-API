package com.iemr.helpline1097.controller.co.feedback;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.controller.co.services.CommonController;
import com.iemr.helpline1097.service.co.feedback.FeedbackSeverityService;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RequestMapping(value = "/feedback")
@RestController
public class FeedbackSeverity {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	private FeedbackSeverityService feedbackSeverityService;

	@Autowired
	public void SetFeedbackSeverityService(FeedbackSeverityService feedbackSeverityService) {
		this.feedbackSeverityService = feedbackSeverityService;
	}

	@CrossOrigin()
	@RequestMapping(value = "/getseverity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String getFeedbackType() {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(feedbackSeverityService.getActiveFeedbackSeverity().toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}
}
