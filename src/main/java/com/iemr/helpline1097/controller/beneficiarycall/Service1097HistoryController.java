package com.iemr.helpline1097.controller.beneficiarycall;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.controller.co.services.CommonController;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;
import com.iemr.helpline1097.service.co.beneficiarycall.BeneficiaryCallService;
import com.iemr.helpline1097.service.co.beneficiarycall.ServicesHistoryService;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/services")
public class Service1097HistoryController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	private ServicesHistoryService servicesHistoryService;
	private BeneficiaryCallService beneficiaryCallService;

	@Autowired
	public void setService1097HistoryService(ServicesHistoryService servicesHistoryService)
	{

		this.servicesHistoryService = servicesHistoryService;
	}

	@Autowired
	public void setBeneficiaryCallService(BeneficiaryCallService beneficiaryCallService)
	{

		this.beneficiaryCallService = beneficiaryCallService;
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getServiceHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String beneficiaryRequest)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// BenCallServicesMappingHistory service1097HistoryDetails = inputMapper.gson().fromJson(beneficiaryRequest,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> serviceHistoryList = servicesHistoryService
			// .getServiceHistory(service1097HistoryDetails.getBeneficiaryRegID());
			List<BenCallServicesMappingHistory> serviceHistoryList = servicesHistoryService
					.getServiceHistory(beneficiaryRequest);
			response.setResponse(serviceHistoryList.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getBeneficiaryCallHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getBeneficiaryCallHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String beneficiaryRequest)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// BenCallServicesMappingHistory service1097HistoryDetails = inputMapper.gson().fromJson(beneficiaryRequest,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> serviceHistoryList = servicesHistoryService
			// .getServiceHistory(service1097HistoryDetails.getBeneficiaryRegID());
			List<BenCallServicesMappingHistory> serviceHistoryList = servicesHistoryService
					.getServiceHistory(beneficiaryRequest);
			response.setResponse(serviceHistoryList.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/setHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String setServiceHistory(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			BenCallServicesMappingHistory serviceHistoryDetails = inputMapper.gson().fromJson(request,
					BenCallServicesMappingHistory.class);
			BenCallServicesMappingHistory savedObj = servicesHistoryService.createServiceHistory(serviceHistoryDetails);
			response.setResponse(savedObj.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getCallSummary",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	// public String getCallSummary(@RequestBody BenCallServicesMappingHistory
	// service1097HistoryDetails) {
	//
	// List<BenCallServicesMappingHistory> serviceHistoryList =
	// servicesHistoryService
	// .getCallSummary(service1097HistoryDetails.getBenCallID());
	// return serviceHistoryList.toString();
	// }
	public String getCallSummary(
			@ApiParam(value = "{\"benCallID\":\"Integer - current call ID\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			BeneficiaryCall call = inputMapper.gson().fromJson(request, BeneficiaryCall.class);
			List<BeneficiaryCall> callHistoryList = beneficiaryCallService.getCallSummaryByCallID(call.getBenCallID());
			response.setResponse(callHistoryList.toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getBeneficiaryCallsHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getBeneficiaryCallsHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			JSONObject requestObject = new JSONObject(request);
			int pageNo = requestObject.has("pageNo") ? (requestObject.getInt("pageNo") - 1) : 0;
			int rows = requestObject.has("rowsPerPage") ? requestObject.getInt("rowsPerPage") : 1000;
			BeneficiaryCall call = inputMapper.gson().fromJson(request, BeneficiaryCall.class);
			List<BeneficiaryCall> callHistoryList;
			if (call.getCalledServiceID() != null)
			{
				callHistoryList = beneficiaryCallService.getBeneficiaryCallsHistory(call.getBeneficiaryRegID(),
						call.getCalledServiceID(), pageNo, rows);
			} else
			{
				callHistoryList = beneficiaryCallService.getBeneficiaryCallsHistory(call.getBeneficiaryRegID(), pageNo,
						rows);
			}
			response.setResponse(callHistoryList.toString());
		} catch (JSONException e)
		{
			logger.error("", e);
			response.setError(e);
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getReferralsHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getReferralsHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// JSONObject requestObject = new JSONObject(request);
			// // int pageNo = requestObject.has("pageNo") ?
			// // (requestObject.getInt("pageNo") - 1) : 0;
			// // int rows = requestObject.has("rowsPerPage") ?
			// // requestObject.getInt("rowsPerPage") : 1000;
			// int pageNo = 0;
			// int rows = 1000;
			// BenCallServicesMappingHistory call = inputMapper.gson().fromJson(request,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
			// .getReferralsHistory(call.getBeneficiaryRegID(), pageNo, rows);
			List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService.getReferralsHistory(request);
			response.setResponse(callHistoryList.toString());
		} catch (JSONException e)
		{
			logger.error("", e);
			response.setError(e);
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getFeedbacksHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getFeedbacksHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// JSONObject requestObject = new JSONObject(request);
			// int pageNo = requestObject.has("pageNo") ?
			// (requestObject.getInt("pageNo") - 1) : 0;
			// int rows = requestObject.has("rowsPerPage") ?
			// requestObject.getInt("rowsPerPage") : 1000;
			// int pageNo = 0;
			// int rows = 1000;
			// BenCallServicesMappingHistory call = inputMapper.gson().fromJson(request,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
			// .getFeedbacksHistory(call.getBeneficiaryRegID(), pageNo, rows);
			List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService.getFeedbacksHistory(request);
			response.setResponse(callHistoryList.toString());
		} catch (JSONException e)
		{
			logger.error("", e);
			response.setError(e);
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getInformationsHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getInformationsHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\"}, "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// JSONObject requestObject = new JSONObject(request);
			// // int pageNo = requestObject.has("pageNo") ?
			// // (requestObject.getInt("pageNo") - 1) : 0;
			// // int rows = requestObject.has("rowsPerPage") ?
			// // requestObject.getInt("rowsPerPage") : 1000;
			// int pageNo = 0;
			// int rows = 1000;
			// BenCallServicesMappingHistory call = inputMapper.gson().fromJson(request,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
			// .getInformationsHistory(call.getBeneficiaryRegID(), pageNo, rows);
			List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
					.getInformationsHistory(request);
			response.setResponse(callHistoryList.toString());
		} catch (JSONException e)
		{
			logger.error("", e);
			response.setError(e);
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(
			value = "/getCounsellingsHistory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	public String getCounsellingsHistory(@ApiParam(
			value = "{\"beneficiaryRegID\":\"Integer - Beneficiary registration ID\", "
					+ "\"calledServiceID\":\"provider Service Map ID as integer\"}") @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			// JSONObject requestObject = new JSONObject(request);
			// // int pageNo = requestObject.has("pageNo") ?
			// // (requestObject.getInt("pageNo") - 1) : 0;
			// // int rows = requestObject.has("rowsPerPage") ?
			// // requestObject.getInt("rowsPerPage") : 1000;
			// int pageNo = 0;
			// int rows = 1000;
			// BenCallServicesMappingHistory call = inputMapper.gson().fromJson(request,
			// BenCallServicesMappingHistory.class);
			// List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
			// .getCounsellingsHistory(call.getBeneficiaryRegID(), pageNo, rows);
			List<BenCallServicesMappingHistory> callHistoryList = servicesHistoryService
					.getCounsellingsHistory(request);
			response.setResponse(callHistoryList.toString());
		} catch (JSONException e)
		{
			logger.error("", e);
			response.setError(e);
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/updateBeneficiaryIDForCall",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	private String updateBeneficiaryIDForCall(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		// try {
		// JSONObject requestObject = new JSONObject(request);
		// Integer updateCount = beneficiaryCallService.closeCall(request);
		// requestObject.put("updateCount", updateCount);
		// response.setResponse(requestObject.toString());
		// } catch (JSONException e) {
		// logger.error("", e);
		// response.setError(e);
		// } catch (Exception e) {
		// logger.error("", e);
		// response.setError(e);
		// }
		response.setResponse("Refer to common api for call start, creation and closure");

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/startCall",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	private String startCall(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		// try {
		// JSONObject requestObject = new JSONObject(request);
		// // Long beneficiaryRegID =
		// // requestObject.getLong("beneficiaryRegID");
		// // Boolean is1097 = (requestObject.has("is1097") ?
		// // requestObject.getBoolean("is1097") : false);
		// BeneficiaryCall call = inputMapper.gson().fromJson(request, BeneficiaryCall.class);
		// BeneficiaryCall startedCall = beneficiaryCallService.createCall(call.getBeneficiaryRegID(),
		// call.getIs1097());
		// response.setResponse(startedCall.toString());
		// } catch (JSONException e) {
		// logger.error("", e);
		// response.setError(e);
		// } catch (Exception e) {
		// logger.error("", e);
		// response.setError(e);
		// }
		response.setResponse("Refer to common api for call start, creation and closure");

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/updatebeneficiaryincall",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	private String updateBeneficiaryIDInCall(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		// try {
		// JSONObject requestObject = new JSONObject(request);
		// requestObject.put("updatedCount", beneficiaryCallService.updateBeneficiaryIDInCall(request));
		// response.setResponse(requestObject.toString());
		// } catch (JSONException e) {
		// logger.error("", e);
		// response.setError(e);
		// } catch (Exception e) {
		// logger.error("", e);
		// response.setError(e);
		// }
		response.setResponse("Refer to common api for call start, creation and closure");

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(
			value = "/closeCall",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON,
			headers = "Authorization")
	private String closeCall(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		// try {
		// JSONObject requestObject = new JSONObject(request);
		// Integer updateCount = beneficiaryCallService.closeCall(request);
		// requestObject.put("updateCount", updateCount);
		// response.setResponse(requestObject.toString());
		// } catch (JSONException e) {
		// logger.error("", e);
		// response.setError(e);
		// } catch (Exception e) {
		// logger.error("", e);
		// response.setError(e);
		// }
		response.setResponse("Refer to common api for call start, creation and closure");

		return response.toString();
	}

	// @Autowired
	// HttpUtils utils;

	// @CrossOrigin()
	// @RequestMapping(value = "/closeCallTest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	// private String closeCallTest(@RequestBody String request) {
	// OutputResponse response = new OutputResponse();
	// try {
	// HttpUtils utils = new HttpUtils();
	// String responseStr = utils.post("http://localhost:9090/helpline1097APIV1/services/closeCall", request);
	// JSONObject requestObject = new JSONObject(request);
	//// Integer updateCount = beneficiaryCallService.closeCall(request);
	//// requestObject.put("updateCount", updateCount);
	// response.setResponse(responseStr);
	// } catch (JSONException e) {
	// logger.error("", e);
	// response.setError(e);
	// } catch (Exception e) {
	// logger.error("", e);
	// response.setError(e);
	// }
	//
	// return response.toString();
	// }

}
