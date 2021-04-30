package com.iemr.helpline1097.controller.co.feedback;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.service.co.feedback.FeedbackService;
import com.iemr.helpline1097.service.co.feedback.FeedbackServiceImpl;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

@RequestMapping(value = "/co")
@RestController
public class FeedbackController
{
	private static final String request = null;
	private InputMapper inputMapper = new InputMapper();
	private Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * feedback service
	 */
	private FeedbackService feedbackService;

	/***
	 * Author: Neeraj Kumar (298657) Date: 04-06-2017 Purpose: Creating object of FeedbackServiceImpl
	 */
	private FeedbackServiceImpl feedbackServiceImpl;

	@Autowired
	public void setFeedbackServiceImpl(FeedbackServiceImpl feedbackServiceImpl)
	{
		this.feedbackServiceImpl = feedbackServiceImpl;
	}

	@Autowired
	public void setFeedbackService(FeedbackService feedbackService)
	{

		this.feedbackService = feedbackService;
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getfeedbacklist",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String feedbackReuest(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			FeedbackDetails feedbackDetails = inputMapper.gson().fromJson(request, FeedbackDetails.class);
			List<FeedbackDetails> feedbackList = feedbackService
					.getFeedbackRequests(feedbackDetails.getBeneficiaryRegID());
			response.setResponse(feedbackList.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/setfeedback",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	@Deprecated
	public String feedbackCreate(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			FeedbackDetails feedbackDetails = inputMapper.gson().fromJson(request, FeedbackDetails.class);
			FeedbackDetails savedDetails = feedbackService.createFeedback(feedbackDetails);
			response.setResponse("success: " + savedDetails.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getfeedback/{feedbackID}",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getFeedbackByPost(@PathVariable("feedbackID") int feedbackID)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			logger.info("" + feedbackID);
			List<FeedbackDetails> savedDetails = feedbackService.getFeedbackRequests(feedbackID);
			response.setResponse(savedDetails.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/updatefeedback",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String updateFeedback(@RequestBody FeedbackDetails feedbackDetails)
	{
		OutputResponse response = new OutputResponse();
		// try {
		// response.setResponse(feedbackService.updateFeedback(feedbackDetails));
		// } catch (Exception e) {
		// logger.error("", e);
		// response.setError(e);
		// }
		response.setResponse("Call deprecated use API from common to update feedback");
		return response.toString();
	}

	/**
	 * Author: Neeraj Kumar (298657) Date: 04-06-2017 Purpose: Save Feedback from taken from cuntomer
	 * 
	 */

	// @CrossOrigin()
	// @RequestMapping(value = "/saveBenFeedback", method = RequestMethod.POST,
	// produces = MediaType.APPLICATION_JSON)
	// // public String saveFeedback(@RequestBody Iterable<FeedbackDetails>
	// // feedbackDetails) {
	// public String saveFeedback(@RequestBody String feedbackDetails) {
	//
	// OutputResponse response = new OutputResponse();
	// try {
	// String s = feedbackServiceImpl.saveFeedbackFromCustomer(feedbackDetails);
	// response.setResponse(s);
	// } catch (Exception e) {
	// logger.error("", e);
	// response.setError(e);
	// }
	// return response.toString();
	// }

	@CrossOrigin()
	@RequestMapping(value = "/saveBenFeedback", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,headers = "Authorization")
	private String saveBenFeedback(@RequestBody String feedbackRequest, HttpServletRequest request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			String savedFeedback = feedbackServiceImpl.saveFeedbackFromCustomer(feedbackRequest, request);
			response.setResponse(savedFeedback);
		} catch (Exception e)
		{
			logger.error("saveBenFeedback failed with error " + e.getMessage(), e);
			response.setError(e);
		}

		return response.toString();
	}
}
