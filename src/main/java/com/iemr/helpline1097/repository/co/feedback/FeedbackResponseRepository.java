package com.iemr.helpline1097.repository.co.feedback;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.feedbackResponse.FeedbackResponse;

@Repository
@RestResource(exported = false)
public interface FeedbackResponseRepository extends CrudRepository<FeedbackResponse, Long>{

}
