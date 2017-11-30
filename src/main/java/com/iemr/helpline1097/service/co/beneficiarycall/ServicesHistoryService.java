package com.iemr.helpline1097.service.co.beneficiarycall;

import java.util.List;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

public interface ServicesHistoryService
{

	/**
	 * 
	 * @return service history list
	 */
	List<BenCallServicesMappingHistory> getServiceHistory(Long id);

	/**
	 * 
	 * @param service1097HistoryDetails
	 * @return saved object
	 */
	BenCallServicesMappingHistory createServiceHistory(BenCallServicesMappingHistory service1097HistoryDetails);

	List<BenCallServicesMappingHistory> getCallSummary(Long id);

	List<BenCallServicesMappingHistory> getReferralsHistory(Long id, int pageNo, int rows);

	List<BenCallServicesMappingHistory> getFeedbacksHistory(Long id, int pageNo, int rows);

	List<BenCallServicesMappingHistory> getInformationsHistory(Long id, int pageNo, int rows);

	List<BenCallServicesMappingHistory> getCounsellingsHistory(Long id, int pageNo, int rows);

	List<BenCallServicesMappingHistory> getServiceHistory(String beneficiaryRequest) throws Exception;

	List<BenCallServicesMappingHistory> getCallSummary(String beneficiaryRequest) throws Exception;

	List<BenCallServicesMappingHistory> getReferralsHistory(String beneficiaryRequest) throws Exception;

	List<BenCallServicesMappingHistory> getFeedbacksHistory(String beneficiaryRequest) throws Exception;

	List<BenCallServicesMappingHistory> getInformationsHistory(String beneficiaryRequest) throws Exception;

	List<BenCallServicesMappingHistory> getCounsellingsHistory(String beneficiaryRequest) throws Exception;

}
