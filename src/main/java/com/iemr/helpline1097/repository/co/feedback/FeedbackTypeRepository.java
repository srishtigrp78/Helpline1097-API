package com.iemr.helpline1097.repository.co.feedback;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iemr.helpline1097.data.co.feedback.FeedbackType;

public interface FeedbackTypeRepository extends CrudRepository<FeedbackType, Long> {
	@Query("select feedbackTypeID, feedbackTypeName from FeedbackType where deleted = false")
	Set<Objects[]> findActiveFeedbackTypes();
}
