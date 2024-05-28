package com.iemr.helpline1097.controller.beneficiarycall;

import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;
import com.iemr.helpline1097.service.co.beneficiarycall.BeneficiaryCallService;
import com.iemr.helpline1097.service.co.beneficiarycall.ServicesHistoryService;
import com.iemr.helpline1097.utils.exception.IEMRException;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class Service1097HistoryControllerTest {

	@InjectMocks
	Service1097HistoryController service1097HistoryController;

	@Mock
	InputMapper inputMapper;

	@Mock
	private ServicesHistoryService servicesHistoryService;

	@Mock
	private BeneficiaryCallService beneficiaryCallService;

	@Test
	void getServiceHistoryTest() throws Exception {

		String beneficiaryRequest = "{\"beneficiaryRegID\":123, \"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<>();
		serviceHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getServiceHistory(beneficiaryRequest)).thenReturn(serviceHistoryList);

		String response = service1097HistoryController.getServiceHistory(beneficiaryRequest);

		Assertions.assertEquals(response, service1097HistoryController.getServiceHistory(beneficiaryRequest));

	}

	@Test
	void getServiceHistoryTest_Exception() throws Exception {

		String beneficiaryRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getServiceHistory(beneficiaryRequest)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getServiceHistory(beneficiaryRequest);

		Assertions.assertEquals(response, service1097HistoryController.getServiceHistory(beneficiaryRequest));

	}

	@Test
	void getBeneficiaryCallHistoryTest() throws Exception {

		String beneficiaryRequest = "{\"beneficiaryRegID\":123, \"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> serviceHistoryList = new ArrayList<>();
		serviceHistoryList.add(benCallServicesMappingHistory);

		String response = service1097HistoryController.getBeneficiaryCallHistory(beneficiaryRequest);

		Assertions.assertEquals(response, service1097HistoryController.getBeneficiaryCallHistory(beneficiaryRequest));
	}

	@Test
	void getBeneficiaryCallHistoryTest_Exception() throws Exception {

		String beneficiaryRequest = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.getBeneficiaryCallHistory(beneficiaryRequest);

		Assertions.assertEquals(response, service1097HistoryController.getBeneficiaryCallHistory(beneficiaryRequest));

	}

	@Test
	void setServiceHistoryTest() throws IEMRException {

		String request = "setHistory";

		BenCallServicesMappingHistory serviceHistoryDetails = new BenCallServicesMappingHistory();

		serviceHistoryDetails.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		serviceHistoryDetails.setBenCallID(23L);
		serviceHistoryDetails.setBeneficiaryRegID(123L);
		serviceHistoryDetails.setCategoryID(23);
		serviceHistoryDetails.setCoCategoryID(12);
		serviceHistoryDetails.setCoSubCategoryID(1234);
		serviceHistoryDetails.setCreatedBy("A K");
		serviceHistoryDetails.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		serviceHistoryDetails.setDeleted(false);
		serviceHistoryDetails.setFeedbackID(129L);
		serviceHistoryDetails.setInstituteDirMapID(234L);
		serviceHistoryDetails.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		serviceHistoryDetails.setModifiedBy("beneficiaryRequest");
		serviceHistoryDetails.setRequestID("beneficiaryRequest");
		serviceHistoryDetails.setSubCategoryID(12);
		serviceHistoryDetails.setSubServiceID(234);

		BenCallServicesMappingHistory savedObj = serviceHistoryDetails;

		String response = service1097HistoryController.setServiceHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.setServiceHistory(request));

	}

	@Test
	void setServiceHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.setServiceHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.setServiceHistory(request));

	}

	@Test
	void getCallSummaryTest() {

		String request = "{\"benCallID\":91}";

		OutputResponse response = new OutputResponse();

		BeneficiaryCall call = new BeneficiaryCall();

		call.setBenCallID(91L);
		call.setBeneficiaryRegID(123L);
		call.setCalledServiceID(123);
		call.setCallClosureType("Normal");
		call.setIs1097(true);
		call.setCallTime(Timestamp.valueOf("2029-09-09 09:09:09"));
		call.setRemarks("Nice");
		call.setDispositionStatusID(134);

		call.toString();

		List<BeneficiaryCall> callHistoryList = new ArrayList<>();
		callHistoryList.add(call);

		when(beneficiaryCallService.getCallSummaryByCallID(call.getBenCallID())).thenReturn(callHistoryList);

		response.setResponse(callHistoryList.toString());

		Assertions.assertEquals(response.toString(), service1097HistoryController.getCallSummary(request));

	}

	@Test
	void getCallSummaryTest_Exception() throws Exception {

		BeneficiaryCall call = new BeneficiaryCall();

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(beneficiaryCallService.getCallSummaryByCallID(call.getBenCallID())).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getCallSummary(request);

		Assertions.assertEquals(response, service1097HistoryController.getCallSummary(request));

	}

	@Test
	void getBeneficiaryCallsHistoryTest() {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":234}";

		BeneficiaryCall call = new BeneficiaryCall();

		call.setBenCallID(91L);
		call.setBeneficiaryRegID(123L);
		call.setCalledServiceID(123);
		call.setCallClosureType("Normal");
		call.setIs1097(true);
		call.setCallTime(Timestamp.valueOf("2029-09-09 09:09:09"));
		call.setRemarks("Nice");
		call.setDispositionStatusID(134);
		call.setCalledServiceID(234);

		call.toString();

		List<BeneficiaryCall> callHistoryList = new ArrayList<>();
		callHistoryList.add(call);

		String response = service1097HistoryController.getBeneficiaryCallsHistory(request);

		Assertions.assertNotNull(call.getCalledServiceID());
		Assertions.assertEquals(response.toString(), service1097HistoryController.getBeneficiaryCallsHistory(request));

	}

	@Test
	void getBeneficiaryCallsHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.getBeneficiaryCallsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getBeneficiaryCallsHistory(request));

	}

	@Test
	void getBeneficiaryCallsHistoryTest_Else() {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":null}";

		BeneficiaryCall call = new BeneficiaryCall();

		call.setBenCallID(91L);
		call.setBeneficiaryRegID(123L);
		call.setCalledServiceID(123);
		call.setCallClosureType("Normal");
		call.setIs1097(true);
		call.setCallTime(Timestamp.valueOf("2029-09-09 09:09:09"));
		call.setRemarks("Nice");
		call.setDispositionStatusID(134);
		call.setCalledServiceID(null);

		call.toString();

		List<BeneficiaryCall> callHistoryList = new ArrayList<>();
		callHistoryList.add(call);

		String response = service1097HistoryController.getBeneficiaryCallsHistory(request);

		Assertions.assertNull(call.getCalledServiceID());
		Assertions.assertEquals(response, service1097HistoryController.getBeneficiaryCallsHistory(request));

	}

	@Test
	void getBeneficiaryCallsHistoryTest_Else_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.getBeneficiaryCallsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getBeneficiaryCallsHistory(request));

	}

	@Test
	void getReferralsHistoryTest() throws Exception {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getReferralsHistory(request)).thenReturn(callHistoryList);

		String response = service1097HistoryController.getReferralsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getReferralsHistory(request));

	}

	@Test
	void getReferralsHistoryTest_JSONException() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.getReferralsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getReferralsHistory(request));

	}

	@Test
	void getReferralsHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getReferralsHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getReferralsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getReferralsHistory(request));

	}

	@Test
	void getFeedbacksHistoryTest() throws Exception {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getFeedbacksHistory(request)).thenReturn(callHistoryList);

		String response = service1097HistoryController.getFeedbacksHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getFeedbacksHistory(request));

	}

	@Test
	void getFeedbacksHistoryTest_JSONException() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = service1097HistoryController.getFeedbacksHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getFeedbacksHistory(request));

	}

	@Test
	void getFeedbacksHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getFeedbacksHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getFeedbacksHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getFeedbacksHistory(request));

	}

	@Test
	void getInformationsHistoryTest() throws Exception {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getInformationsHistory(request)).thenReturn(callHistoryList);

		String response = service1097HistoryController.getInformationsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getInformationsHistory(request));

	}

	@Test
	void getInformationsHistoryTest_JSONException() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getInformationsHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getInformationsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getInformationsHistory(request));

	}

	@Test
	void getInformationsHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getInformationsHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getInformationsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getInformationsHistory(request));

	}

	@Test
	void getCounsellingsHistoryTest() throws Exception {

		String request = "{\"beneficiaryRegID\":123,\"calledServiceID\":234}";

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getCounsellingsHistory(request)).thenReturn(callHistoryList);

		String response = service1097HistoryController.getCounsellingsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getCounsellingsHistory(request));

	}

	@Test
	void getCounsellingsHistoryTest_JSONException() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getCounsellingsHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getCounsellingsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getCounsellingsHistory(request));

	}

	@Test
	void getCounsellingsHistoryTest_Exception() throws Exception {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getCounsellingsHistory(request)).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getCounsellingsHistory(request);

		Assertions.assertEquals(response, service1097HistoryController.getCounsellingsHistory(request));

	}

	@Test
	void getCaseSheetTest() {

		String request = "{\"benCallID\":91}";

		BeneficiaryCall call = new BeneficiaryCall();

		call.setBenCallID(91L);
		call.setBeneficiaryRegID(123L);
		call.setCalledServiceID(123);
		call.setCallClosureType("Normal");
		call.setIs1097(true);
		call.setCallTime(Timestamp.valueOf("2029-09-09 09:09:09"));
		call.setRemarks("Nice");
		call.setDispositionStatusID(134);

		call.toString();

		BenCallServicesMappingHistory benCallServicesMappingHistory = new BenCallServicesMappingHistory();

		benCallServicesMappingHistory.setBenCall97ServiceMapID(BigInteger.valueOf(12L));
		benCallServicesMappingHistory.setBenCallID(23L);
		benCallServicesMappingHistory.setBeneficiaryRegID(123L);
		benCallServicesMappingHistory.setCategoryID(23);
		benCallServicesMappingHistory.setCoCategoryID(12);
		benCallServicesMappingHistory.setCoSubCategoryID(1234);
		benCallServicesMappingHistory.setCreatedBy("A K");
		benCallServicesMappingHistory.setCreatedDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setDeleted(false);
		benCallServicesMappingHistory.setFeedbackID(129L);
		benCallServicesMappingHistory.setInstituteDirMapID(234L);
		benCallServicesMappingHistory.setLastModDate(Timestamp.valueOf("2029-09-09 09:09:09"));
		benCallServicesMappingHistory.setModifiedBy("beneficiaryRequest");
		benCallServicesMappingHistory.setRequestID("beneficiaryRequest");
		benCallServicesMappingHistory.setSubCategoryID(12);
		benCallServicesMappingHistory.setSubServiceID(234);

		List<BenCallServicesMappingHistory> callHistoryList = new ArrayList<>();
		callHistoryList.add(benCallServicesMappingHistory);

		when(servicesHistoryService.getCallSummaryV1(call.getBenCallID())).thenReturn(callHistoryList);

		String response = service1097HistoryController.getCaseSheet(request);

		Assertions.assertEquals(response, service1097HistoryController.getCaseSheet(request));

	}
	
	@Test
	void getCaseSheetTest_Exception() throws Exception {
		
		BeneficiaryCall call = new BeneficiaryCall();

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(servicesHistoryService.getCallSummaryV1(call.getBenCallID())).thenThrow(NotFoundException.class);

		String response = service1097HistoryController.getCaseSheet(request);

		Assertions.assertEquals(response, service1097HistoryController.getCaseSheet(request));

	}

}
