package com.iemr.helpline1097.service.co.feedback;

import com.iemr.helpline1097.data.co.feedbackRequest.FeedbackRequest;

public interface FeedbackRequestService {

	public FeedbackRequest getFeedbackReuest(int feedbackRequestID);

	public FeedbackRequest createFeedbackRequest(FeedbackRequest i_feedbackrequest);

	
}
