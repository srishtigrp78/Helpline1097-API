package com.iemr.helpline1097.controller.co.beneficiary;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.data.co.beneficiary.M_Promoservice;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.service.co.beneficiary.BenInformationCounsellingFeedbackReferralImpl;
import com.iemr.helpline1097.service.co.beneficiary.IEMRPromoserviceDetailsServiceImpl;
import com.iemr.helpline1097.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class BeneficiaryControllerTest {

	@InjectMocks
	BeneficiaryController beneficiaryController;

	@Mock
	private IEMRPromoserviceDetailsServiceImpl iEMRPromoserviceDetailsServiceImpl;

	@Mock
	private BenInformationCounsellingFeedbackReferralImpl benInformationCounsellingFeedbackReferralImpl;

	@Test
	void addPromoServiceDetailsTest() {

		String request = "Add promo service detail";

		M_Promoservice m_promoservice = new M_Promoservice();

		m_promoservice.setPamphlet("pamphlet");
		m_promoservice.setRadio("FM");
		m_promoservice.setTelevision("Samsung 8K");
		m_promoservice.setFamilyFriends("Many");
		m_promoservice.setHealthcareWorker("healthcareWorker");
		m_promoservice.setOthers("Others");
		m_promoservice.setNotDisclosed("notDisclosed");

		m_promoservice.toString();

		M_Promoservice m_Promoservice = m_promoservice;

		String response = beneficiaryController.addPromoServiceDetails(request);

		Assertions.assertNotNull(m_Promoservice);
		Assertions.assertEquals(response.toString(), beneficiaryController.addPromoServiceDetails(request));

	}

	@Test
	void addPromoServiceDetailsTest_AsNull() {

		String request = "Add promo service detail";

		M_Promoservice m_Promoservice = null;

		String response = beneficiaryController.addPromoServiceDetails(request);

		Assertions.assertNull(m_Promoservice);
		Assertions.assertEquals(response.toString(), beneficiaryController.addPromoServiceDetails(request));

	}

	@Test
	void addPromoServiceDetailsTest_Exception() {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = beneficiaryController.addPromoServiceDetails(request);

		Assertions.assertEquals(response.toString(), beneficiaryController.addPromoServiceDetails(request));

	}

	@Test
	void saveBenCalServiceCatSubcatMappingTest() {

		String request = "Save information requested by the beneficiary during call";

		BenCallServicesMappingHistory benCallServicesMappingHistory1 = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory1.setBenCall97ServiceMapID(12L);
		benCallServicesMappingHistory1.setBenCallID(23L);
		benCallServicesMappingHistory1.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory1.setCategoryID(23);
		benCallServicesMappingHistory1.setCoCategoryID(12);
		benCallServicesMappingHistory1.setCoSubCategoryID(1234);
		benCallServicesMappingHistory1.setCreatedBy("A K");
		benCallServicesMappingHistory1.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory1.setDeleted(false);
		benCallServicesMappingHistory1.setFeedbackID(129L);
		benCallServicesMappingHistory1.setInstituteDirMapID(234L);
		benCallServicesMappingHistory1.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory1.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory1.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory1.setSubCategoryID(12);
		benCallServicesMappingHistory1.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory1);

		BenCallServicesMappingHistory[] benCallServicesMappingHistories = new BenCallServicesMappingHistory[callHistoryList
				.size()];
		benCallServicesMappingHistories = callHistoryList.toArray(benCallServicesMappingHistories);

		Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory = Arrays
				.asList(benCallServicesMappingHistories);

		String response = beneficiaryController.saveBenCalServiceCatSubcatMapping(request);

		Assertions.assertEquals(response.toString(), beneficiaryController.saveBenCalServiceCatSubcatMapping(request));

	}

	@Test
	void saveBenCalServiceCatSubcatMappingTest_Exception() {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = beneficiaryController.saveBenCalServiceCatSubcatMapping(request);

		Assertions.assertEquals(response.toString(), beneficiaryController.saveBenCalServiceCatSubcatMapping(request));

	}

	@Test
	void saveBenCalServiceCOCatSubcatMappingTest() {

		String request = "Save counselling requested by beneficiary";

		BenCallServicesMappingHistory benCallServicesMappingHistory1 = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory1.setBenCall97ServiceMapID(12L);
		benCallServicesMappingHistory1.setBenCallID(23L);
		benCallServicesMappingHistory1.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory1.setCategoryID(23);
		benCallServicesMappingHistory1.setCoCategoryID(12);
		benCallServicesMappingHistory1.setCoSubCategoryID(1234);
		benCallServicesMappingHistory1.setCreatedBy("A K");
		benCallServicesMappingHistory1.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory1.setDeleted(false);
		benCallServicesMappingHistory1.setFeedbackID(129L);
		benCallServicesMappingHistory1.setInstituteDirMapID(234L);
		benCallServicesMappingHistory1.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory1.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory1.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory1.setSubCategoryID(12);
		benCallServicesMappingHistory1.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory1);

		BenCallServicesMappingHistory[] benCallServicesMappingHistories = new BenCallServicesMappingHistory[callHistoryList
				.size()];
		benCallServicesMappingHistories = callHistoryList.toArray(benCallServicesMappingHistories);

		Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory = Arrays
				.asList(benCallServicesMappingHistories);

		String response = beneficiaryController.saveBenCalServiceCOCatSubcatMapping(request);

		Assertions.assertEquals(response.toString(),
				beneficiaryController.saveBenCalServiceCOCatSubcatMapping(request));

	}

	@Test
	void saveBenCalServiceCOCatSubcatMappingTest_Exception() {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = beneficiaryController.saveBenCalServiceCOCatSubcatMapping(request);

		Assertions.assertEquals(response.toString(),
				beneficiaryController.saveBenCalServiceCOCatSubcatMapping(request));
	}

	@Test
	void saveBenCalReferralMappingTest() {

		String referralRequest = "Save beneficiary call referral mapping";

		when(benInformationCounsellingFeedbackReferralImpl.saveBenCalReferralMapping(referralRequest))
				.thenReturn(referralRequest);

		OutputResponse response = new OutputResponse();

		response.setResponse(benInformationCounsellingFeedbackReferralImpl.saveBenCalReferralMapping(referralRequest));

		Assertions.assertEquals(response.toString(), beneficiaryController.saveBenCalReferralMapping(referralRequest));
	}

	@Test
	void saveBenCalReferralMappingTest_Exception() {

		String referralRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(benInformationCounsellingFeedbackReferralImpl.saveBenCalReferralMapping(referralRequest))
				.thenThrow(NotFoundException.class);

		String response = beneficiaryController.saveBenCalReferralMapping(referralRequest);

		Assertions.assertEquals(response, beneficiaryController.saveBenCalReferralMapping(referralRequest));
	}

}
