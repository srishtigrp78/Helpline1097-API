package com.iemr.helpline1097.repository.co.feedback;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.feedback.FeedbackType;

@Repository
@RestResource(exported = false)
public interface FeedbackTypeRepository extends CrudRepository<FeedbackType, Long> {
	@Query("select feedbackTypeID, feedbackTypeName from FeedbackType where deleted = false")
	Set<Objects[]> findActiveFeedbackTypes();
}
