package com.iemr.helpline1097.service.co.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.feedbackRequest.FeedbackRequest;
import com.iemr.helpline1097.repository.co.feedback.FeedbackRequestRepository;

@Service
public class FeedbackRequestServiceImpl implements FeedbackRequestService{

	@Autowired FeedbackRequestRepository feedbackRequestRepository;
	@Override
	public FeedbackRequest getFeedbackReuest(int feedbackRequestID) {
		// TODO Auto-generated method stub
		return feedbackRequestRepository.findOne(new Long(feedbackRequestID));
	}

	@Override
	public FeedbackRequest createFeedbackRequest(FeedbackRequest i_feedbackrequest) {
		// TODO Auto-generated method stub
		return feedbackRequestRepository.save(i_feedbackrequest);
	}
}
