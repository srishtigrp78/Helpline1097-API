package com.iemr.helpline1097.service.co.feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.feedback.FeedbackSeverity;
import com.iemr.helpline1097.data.co.feedback.FeedbackType;
import com.iemr.helpline1097.repository.co.feedback.FeedbackSeverityRepository;

@Service
public class FeedbackSeverityServiceImpl implements FeedbackSeverityService {

	FeedbackSeverityRepository feedbackSeverityRepositorty;
	@Autowired
	public void SetFeedbackTypeRepository(FeedbackSeverityRepository feedbackSeverityRepository){
		this.feedbackSeverityRepositorty = feedbackSeverityRepository;
	}
	@Override
	public List<FeedbackSeverity> getActiveFeedbackSeverity() {
		List<FeedbackSeverity> feedbackSeverityList = new ArrayList<FeedbackSeverity>();
		Set<Objects[]> feedbackTypeResult = feedbackSeverityRepositorty.getActiveFeedbackSeverity();
		for (Object[] feedbackSevity : feedbackTypeResult) {
			if (feedbackSevity!=null && feedbackSevity.length >=2) {
			feedbackSeverityList.add(new FeedbackSeverity((Integer) feedbackSevity[0], (String) feedbackSevity[1]));
			}
		}
		return feedbackSeverityList;
	}

}
