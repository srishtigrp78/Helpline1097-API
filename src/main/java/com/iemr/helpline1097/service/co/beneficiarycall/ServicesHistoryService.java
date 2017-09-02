package com.iemr.helpline1097.service.co.beneficiarycall;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

public interface ServicesHistoryService {

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

}
