package com.iemr.helpline1097.service.co.beneficiary;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

public interface BenInformationCounsellingFeedbackReferral
{
	String saveBenCallServiceCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory);

	String saveBenCalReferralMapping(String referralRequest);

	String saveBenCallServiceCOCatSubCat(Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory);

	// String saveBenCalFeedbackMapping(String feedbackRequest);

	// String saveBenFeedback(Iterable<T>);

}
