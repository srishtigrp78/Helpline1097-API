package com.iemr.helpline1097.service.co.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.feedbackResponse.FeedbackResponse;
import com.iemr.helpline1097.repository.co.feedback.FeedbackResponseRepository;

@Service
public class FeedbackResponseServiceImpl implements FeedbackResponseService{

	@Autowired
	private FeedbackResponseRepository feedbackResponseRepository;
	@Override
	public FeedbackResponse getFeedbackResponse(int feedbackResponseID) {
		return feedbackResponseRepository.findOne(new Long(feedbackResponseID));
	}

	@Override
	public FeedbackResponse createFeedbackResponse(FeedbackResponse t_feedbackResponse) {
		return feedbackResponseRepository.save(t_feedbackResponse);
	}

}
