package com.iemr.helpline1097.controller.co.feedback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.service.co.feedback.FeedbackSeverityService;
import com.iemr.helpline1097.service.co.feedback.FeedbackTypeService;
import com.iemr.helpline1097.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class FeedbackSeverityTest {

	@InjectMocks
	FeedbackSeverity feedbackSeverity;

	@Mock
	private FeedbackSeverityService feedbackSeverityService;

	@Mock
	private FeedbackTypeService feedbackTypeService;

	@Test
	void getSeverityTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(feedbackSeverityService.getActiveFeedbackSeverity().toString());

		Assertions.assertEquals(response.toString(), feedbackSeverity.getSeverity());
	}

	@Test
	void getSeverityTest_Exception() {

		String response = feedbackSeverity.getSeverity();

		Assertions.assertEquals(response, feedbackSeverity.getSeverity());

	}

	@Test
	void getFeedbackTypeTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(feedbackTypeService.getActiveFeedbackTypes().toString());

		Assertions.assertEquals(response.toString(), feedbackSeverity.getFeedbackType());

	}

	@Test
	void getFeedbackTypeTest_Exception() {

		String response = feedbackSeverity.getFeedbackType();

		Assertions.assertEquals(response, feedbackSeverity.getFeedbackType());

	}

}
