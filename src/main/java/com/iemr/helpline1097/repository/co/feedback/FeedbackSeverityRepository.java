package com.iemr.helpline1097.repository.co.feedback;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.feedback.FeedbackSeverity;

@Repository
@RestResource(exported = false)
public interface FeedbackSeverityRepository extends CrudRepository<FeedbackSeverity, Long> {
	@Query("select severityID, severityTypeName from FeedbackSeverity where deleted = false")
	Set<Objects[]> getActiveFeedbackSeverity();
}
