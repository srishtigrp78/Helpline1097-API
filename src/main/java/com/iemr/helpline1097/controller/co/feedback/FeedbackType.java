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
import com.iemr.helpline1097.service.co.feedback.FeedbackTypeService;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

@RequestMapping(value = "/feedback")
@RestController
public class FeedbackType
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	private FeedbackTypeService feedbackTypeService;

	@Autowired
	public void SetFeedbackTypeService(FeedbackTypeService feedbackTypeService)
	{
		this.feedbackTypeService = feedbackTypeService;
	}

	@CrossOrigin()
	@RequestMapping(value = "/gettype", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String getFeedbackType()
	{

		OutputResponse response = new OutputResponse();
		try
		{

			response.setResponse(feedbackTypeService.getActiveFeedbackTypes().toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}
}
