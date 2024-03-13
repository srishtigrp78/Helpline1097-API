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
package com.iemr.helpline1097.service.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;
import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.feedback.FeedbackDetails;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.DirectoryMapping;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.beneficiarycall.ServicesHistoryRepository;
import com.iemr.helpline1097.repository.co.services.InstitutionRepository;
import com.iemr.helpline1097.utils.mapper.InputMapper;

@Service
public class ServicesHistoryServiceImpl implements ServicesHistoryService {

	/**
	 * Service history repository
	 */
	private ServicesHistoryRepository serviceHistoryRepository;

	@Autowired
	public void setServiceHistoryRepository(ServicesHistoryRepository serviceHistoryRepository) {

		this.serviceHistoryRepository = serviceHistoryRepository;
	}

	private InstitutionRepository institutionRepository;

	@Autowired
	public void setInstitutionRepository(InstitutionRepository institutionRepository) {
		this.institutionRepository = institutionRepository;
	}

	@Override
	public BenCallServicesMappingHistory createServiceHistory(
			BenCallServicesMappingHistory benCallServicesMappingHistory) {

		return serviceHistoryRepository.save(benCallServicesMappingHistory);
	}

	private InputMapper inputMapper = new InputMapper();

	@Override
	public List<BenCallServicesMappingHistory> getServiceHistory(Long id) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.findCallDetailsForBeneficiary(id);

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 19) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getServiceHistory(String beneficiaryRequest) throws Exception {
		BeneficiaryCall service1097HistoryDetails = inputMapper.gson().fromJson(beneficiaryRequest,
				BeneficiaryCall.class);
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists;
		if (service1097HistoryDetails.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.findCallDetailsForBeneficiary(
					service1097HistoryDetails.getBeneficiaryRegID(), service1097HistoryDetails.getCalledServiceID());
		} else {
			lists = serviceHistoryRepository
					.findCallDetailsForBeneficiary(service1097HistoryDetails.getBeneficiaryRegID());
		}
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 19) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCallSummary(Long id) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.getCallSummary(id);
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 19) {
				BenCallServicesMappingHistory srh = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(srh);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCallSummaryV1(Long id) {
		List<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		serviceHistoryList = serviceHistoryRepository.getCallSummaryV1(id);
		List<BenCallServicesMappingHistory> caseSheets = new ArrayList<BenCallServicesMappingHistory>();
		BenCallServicesMappingHistory caseSheet = null;
		if (serviceHistoryList.size() > 0) {
			caseSheets.add(serviceHistoryList.get(0));
			caseSheet = caseSheets.get(0);
		}
		for (BenCallServicesMappingHistory benCallServicesMappingHistory : serviceHistoryList) {
			if (benCallServicesMappingHistory.getSubCategoryID() != null && caseSheet != null) {
				if (caseSheet.getInformations() != null)
					caseSheet.getInformations().add(benCallServicesMappingHistory.getSubCategoryDetails());
			} else if (benCallServicesMappingHistory.getCoSubCategoryID() != null && caseSheet != null) {
				if (caseSheet.getCounsellings() != null)
					caseSheet.getCounsellings().add(benCallServicesMappingHistory.getCoSubCategoryDetails());
			} else if (benCallServicesMappingHistory.getFeedbackID() != null && caseSheet != null) {
				if (caseSheet.getFeedbacks() != null)
					caseSheet.getFeedbacks().add(benCallServicesMappingHistory.getFeedbackDetails());
			} else if (benCallServicesMappingHistory.getInstituteDirMapID() != null && caseSheet != null) {
				if (caseSheet.getReferrals() != null)
					caseSheet.getReferrals().add(benCallServicesMappingHistory.getInstituteDirectoryMapping());
			}
		}
		return caseSheets;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCallSummary(String beneficiaryRequest) throws Exception {
		BeneficiaryCall service1097HistoryDetails = inputMapper.gson().fromJson(beneficiaryRequest,
				BeneficiaryCall.class);
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists;
		if (service1097HistoryDetails.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.getCallSummary(service1097HistoryDetails.getBeneficiaryRegID(),
					service1097HistoryDetails.getCalledServiceID());
		} else {
			lists = serviceHistoryRepository.getCallSummary(service1097HistoryDetails.getBeneficiaryRegID());
		}
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 19) {
				BenCallServicesMappingHistory srh = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (Long) objects[9], (FeedbackDetails) objects[10],
						(Long) objects[11], (DirectoryMapping) objects[12], (String) objects[13],
						(Timestamp) objects[14], (Integer) objects[15], (CategoryDetails) objects[16],
						(Integer) objects[17], (SubCategoryDetails) objects[18]);
				serviceHistoryList.add(srh);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getReferralsHistory(Long id, int pageNo, int rows) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.findReferralsForBeneficiary(id, PageRequest.of(pageNo, rows));

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 9) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (DirectoryMapping) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getReferralsHistory(String beneficiaryRequest) throws Exception {
		int pageNo = 0;
		int rows = 1000;
		BeneficiaryCall mapHistory = inputMapper.gson().fromJson(beneficiaryRequest, BeneficiaryCall.class);
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists;
		if (mapHistory.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.findReferralsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					mapHistory.getCalledServiceID(), PageRequest.of(pageNo, rows));
		} else {
			lists = serviceHistoryRepository.findReferralsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					PageRequest.of(pageNo, rows));
		}
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 9) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (DirectoryMapping) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getFeedbacksHistory(Long id, int pageNo, int rows) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.findFeedbacksForBeneficiary(id, PageRequest.of(pageNo, rows));

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 9) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (FeedbackDetails) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getFeedbacksHistory(String beneficiaryRequest) throws Exception {
		int pageNo = 0;
		int rows = 1000;
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		BeneficiaryCall mapHistory = inputMapper.gson().fromJson(beneficiaryRequest, BeneficiaryCall.class);
		List<Object[]> lists;
		if (mapHistory.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.findFeedbacksForBeneficiary(mapHistory.getBeneficiaryRegID(),
					mapHistory.getCalledServiceID(), PageRequest.of(pageNo, rows));
		} else {
			lists = serviceHistoryRepository.findFeedbacksForBeneficiary(mapHistory.getBeneficiaryRegID(),
					PageRequest.of(pageNo, rows));
		}

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 9) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Long) objects[5], (FeedbackDetails) objects[6], (String) objects[7], (Timestamp) objects[8]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getInformationsHistory(Long id, int pageNo, int rows) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.findInformationsForBeneficiary(id,
				PageRequest.of(pageNo, rows));

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 11) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getInformationsHistory(String beneficiaryRequest) throws Exception {
		int pageNo = 0;
		int rows = 1000;
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		BeneficiaryCall mapHistory = inputMapper.gson().fromJson(beneficiaryRequest, BeneficiaryCall.class);
		List<Object[]> lists;

		if (mapHistory.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.findInformationsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					mapHistory.getCalledServiceID(), PageRequest.of(pageNo, rows));
		} else {
			lists = serviceHistoryRepository.findInformationsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					PageRequest.of(pageNo, rows));
		}
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 11) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCounsellingsHistory(Long id, int pageNo, int rows) {
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		List<Object[]> lists = serviceHistoryRepository.findCounsellingsForBeneficiary(id,
				PageRequest.of(pageNo, rows));

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 11) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

	@Override
	public List<BenCallServicesMappingHistory> getCounsellingsHistory(String beneficiaryRequest) throws Exception {
		int pageNo = 0;
		int rows = 1000;
		ArrayList<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<BenCallServicesMappingHistory>();
		BeneficiaryCall mapHistory = inputMapper.gson().fromJson(beneficiaryRequest, BeneficiaryCall.class);
		List<Object[]> lists;
		if (mapHistory.getCalledServiceID() != null) {
			lists = serviceHistoryRepository.findCounsellingsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					mapHistory.getCalledServiceID(), PageRequest.of(pageNo, rows));
		} else {
			lists = serviceHistoryRepository.findCounsellingsForBeneficiary(mapHistory.getBeneficiaryRegID(),
					PageRequest.of(pageNo, rows));
		}

		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 11) {
				BenCallServicesMappingHistory call = new BenCallServicesMappingHistory((Long) objects[0],
						(Long) objects[1], (Long) objects[2], (Integer) objects[3], (SubServices) objects[4],
						(Integer) objects[5], (CategoryDetails) objects[6], (Integer) objects[7],
						(SubCategoryDetails) objects[8], (String) objects[9], (Timestamp) objects[10]);
				serviceHistoryList.add(call);
			}
		}
		return serviceHistoryList;
	}

}
