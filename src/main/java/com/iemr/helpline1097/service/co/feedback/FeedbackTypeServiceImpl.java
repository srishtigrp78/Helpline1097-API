package com.iemr.helpline1097.service.co.feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.feedback.FeedbackType;
import com.iemr.helpline1097.repository.co.feedback.FeedbackTypeRepository;

@Service
public class FeedbackTypeServiceImpl implements FeedbackTypeService {

	FeedbackTypeRepository feedbackRepositorty;

	@Autowired
	public void setFeedbackTypeRepository(FeedbackTypeRepository feedbackTypeRepository) {
		this.feedbackRepositorty = feedbackTypeRepository;
	}

	@Override
	public List<FeedbackType> getActiveFeedbackTypes() {
		List<FeedbackType> feedbackTypeList = new ArrayList<FeedbackType>();
		Set<Objects[]> feedbackTypeResult = feedbackRepositorty.findActiveFeedbackTypes();
		for (Object[] feedbackType : feedbackTypeResult) {
			if (feedbackType != null && feedbackType.length >= 2) {
				feedbackTypeList.add(new FeedbackType((Integer) feedbackType[0], (String) feedbackType[1]));
			}
		}
		return feedbackTypeList;
	}

}
