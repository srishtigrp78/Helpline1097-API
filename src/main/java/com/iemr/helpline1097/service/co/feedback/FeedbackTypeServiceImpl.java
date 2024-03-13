/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
		Set<Object[]> feedbackTypeResult = feedbackRepositorty.findActiveFeedbackTypes();
		for (Object[] feedbackType : feedbackTypeResult) {
			if (feedbackType != null && feedbackType.length >= 2) {
				feedbackTypeList.add(new FeedbackType((Integer) feedbackType[0], (String) feedbackType[1]));
			}
		}
		return feedbackTypeList;
	}

}
