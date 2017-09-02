package com.iemr.helpline1097.repository.co.feedback;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackDetails, Long> {

	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy from FeedbackDetails where beneficiaryRegID = :id")
	public ArrayList<Objects[]> findByBeneficiaryID(@Param("id") long id);
	
	@Query("select feedbackID, severityID, feedbackTypeID, feedbackStatusID, feedback, createdBy from FeedbackDetails where feedbackID = :id")
	public ArrayList<Objects[]> findByFeedbackID(@Param("id") long id);
}
