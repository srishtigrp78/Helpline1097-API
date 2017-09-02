package com.iemr.helpline1097.service.co.feedback;

import com.iemr.helpline1097.data.co.feedbackRequest.FeedbackRequest;
import com.iemr.helpline1097.data.co.feedbackResponse.FeedbackResponse;

public interface FeedbackResponseService {
	public FeedbackResponse getFeedbackResponse(int feedbackResponseID);

	public FeedbackResponse createFeedbackResponse(FeedbackResponse t_feedbackResponse);

}
