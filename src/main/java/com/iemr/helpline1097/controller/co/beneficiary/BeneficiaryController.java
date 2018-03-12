package com.iemr.helpline1097.controller.co.beneficiary;

import java.util.Arrays;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.controller.co.services.CommonController;
import com.iemr.helpline1097.data.co.beneficiary.M_Promoservice;
import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;
import com.iemr.helpline1097.service.co.beneficiary.BenInformationCounsellingFeedbackReferralImpl;
import com.iemr.helpline1097.service.co.beneficiary.IEMRPromoserviceDetailsServiceImpl;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/iEMR")
@RestController
public class BeneficiaryController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	private IEMRPromoserviceDetailsServiceImpl iEMRPromoserviceDetailsServiceImpl;
	private BenInformationCounsellingFeedbackReferralImpl benInformationCounsellingFeedbackReferralImpl;

	@Autowired
	public void
			setiEMRPromoserviceDetailsServiceImpl(IEMRPromoserviceDetailsServiceImpl iEMRPromoserviceDetailsServiceImpl)
	{
		this.iEMRPromoserviceDetailsServiceImpl = iEMRPromoserviceDetailsServiceImpl;
	}

	@Autowired
	public void setBenInformationCounsellingFeedbackReferralImpl(
			BenInformationCounsellingFeedbackReferralImpl benInformationCounsellingFeedbackReferralImpl)
	{
		this.benInformationCounsellingFeedbackReferralImpl = benInformationCounsellingFeedbackReferralImpl;
	}

	/* @CrossOrigin(origins = "http://localhost:3000") */
	@ApiOperation(value = "Adds a new beneficiary occupation")
	@Deprecated
	@CrossOrigin()
	@RequestMapping(value = "/add/beneficiaryOccupation", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String addBeneficiaryOccupation(
			@ApiParam(
					value = "{\n\"occupationType\":\"string-Mandatory\","
							+ "\n\"createdBy\":\"user name as string - Mandatorty\","
							+ "\n\"key\":\"user key as string - Mandatory\"}",
					required = true) @RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		// try
		// {
		// I_BeneficiaryOccupation i_beneficiaryoccupation = inputMapper.gson().fromJson(request.toString(),
		// I_BeneficiaryOccupation.class);
		// I_BeneficiaryOccupation i_Beneficiaryoccupation = iEMRBeneficiaryOccupationServiceImpl
		// .addBeneficiaryOccupation(i_beneficiaryoccupation);
		//
		// if (i_Beneficiaryoccupation != null)
		// {
		// response.setResponse("i_Beneficiaryoccupation Added");
		// } else
		// {
		// response.setResponse("Failed to add i_Beneficiaryoccupation");
		// }
		// } catch (Exception e)
		// {
		// logger.error("", e);
		// response.setError(e);
		// }

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(value = "/add/beneficiaryEducation", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String addBeneficiaryEducation(@RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		// try
		// {
		// I_BeneficiaryEducation i_beneficiaryeducation =
		// inputMapper.gson().fromJson(request, I_BeneficiaryEducation.class);
		// I_BeneficiaryEducation i_Beneficiaryeducation =
		// iEMRBeneficiaryEducationServiceImpl.addBeneficiaryEducation(i_beneficiaryeducation);
		// if (i_Beneficiaryeducation != null)
		// {
		// response.setResponse("i_Beneficiaryeducation Added");
		// } else
		// {
		// response.setResponse("Failed to add i_Beneficiaryeducation");
		// }
		// } catch (Exception e)
		// {
		// logger.error("", e);
		// response.setError(e);
		// }

		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(value = "/get/beneficiaryOccupation", method = RequestMethod.GET, headers = "Authorization")
	public String getBeneficiaryOccupation()
	{

		OutputResponse response = new OutputResponse();
		// try
		// {
		// Iterable<I_BeneficiaryOccupation> beneficiaryOccupations =
		// iEMRBeneficiaryOccupationServiceImpl.getBeneficiaryOccupation();
		// response.setResponse(beneficiaryOccupations.toString());
		// } catch (Exception e)
		// {
		// logger.error("", e);
		// response.setError(e);
		// }
		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(value = "/get/beneficiaryEducation", method = RequestMethod.GET, headers = "Authorization")
	public String getBeneficiaryEducation()
	{

		OutputResponse response = new OutputResponse();
		// try
		// {
		// Iterable<I_BeneficiaryEducation> beneficiaryeducations =
		// iEMRBeneficiaryEducationServiceImpl.getBeneficiaryEducation();
		//
		// response.setResponse(beneficiaryeducations.toString());
		// } catch (Exception e)
		// {
		// logger.error("", e);
		// response.setError(e);
		// }
		return response.toString();
	}

	@CrossOrigin()
	@Deprecated
	@RequestMapping(value = "/add/benDemographics", method = RequestMethod.POST, headers = "Authorization")
	public String addBenDemographics(@RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		// try
		// {
		// I_BenDemographics i_benDemographics = inputMapper.gson().fromJson(request, I_BenDemographics.class);
		// I_BenDemographics i_BenDemographics = iEMRBenDemographicsServiceImpl.addBenDemographics(i_benDemographics);
		//
		// if (i_BenDemographics != null)
		// {
		// response.setResponse("i_BenDemographics Added");
		// } else
		// {
		// response.setResponse("Failed to add i_BenDemographics");
		// }
		// } catch (Exception e)
		// {
		// logger.error("", e);
		// response.setError(e);
		// }
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "add/promoServiceDetails", method = RequestMethod.POST, headers = "Authorization")
	public String addPromoServiceDetails(@RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		try
		{
			M_Promoservice m_promoservice = inputMapper.gson().fromJson(request, M_Promoservice.class);
			M_Promoservice m_Promoservice = iEMRPromoserviceDetailsServiceImpl.addPromoServiceDetail(m_promoservice);

			if (m_Promoservice != null)
			{
				response.setResponse("PromoServiceDetails Added");
			} else
			{
				response.setResponse("Failed to add PromoServiceDetails");
			}
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();

	}

	/**
	 * Author: Neeraj Kumar (298657). Date: 02-06-2017. Purpose: Save information services and return subcat file
	 * path....
	 * 
	 * 
	 */

	@CrossOrigin()
	@ApiOperation(value = "This will save information requested by the beneficiary during call")
	@RequestMapping(value = "/saveBenCalServiceCatSubcatMapping", method = RequestMethod.POST,
			headers = "Authorization")
	public String saveBenCalServiceCatSubcatMapping(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			BenCallServicesMappingHistory[] benCallServicesMappingHistories =
					inputMapper.gson().fromJson(request, BenCallServicesMappingHistory[].class);
			Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory =
					Arrays.asList(benCallServicesMappingHistories);

			response.setResponse(benInformationCounsellingFeedbackReferralImpl
					.saveBenCallServiceCatSubCat(benCallServicesMappingHistory));
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();

	}

	@CrossOrigin()
	@ApiOperation(value = "This will save counselling requested by the beneficiary during call")
	@RequestMapping(value = "/saveBenCalServiceCOCatSubcatMapping", method = RequestMethod.POST,
			headers = "Authorization")
	public String saveBenCalServiceCOCatSubcatMapping(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			BenCallServicesMappingHistory[] benCallServicesMappingHistories =
					inputMapper.gson().fromJson(request, BenCallServicesMappingHistory[].class);
			Iterable<BenCallServicesMappingHistory> benCallServicesMappingHistory =
					Arrays.asList(benCallServicesMappingHistories);

			response.setResponse(benInformationCounsellingFeedbackReferralImpl
					.saveBenCallServiceCOCatSubCat(benCallServicesMappingHistory));
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();

	}

	/**
	 * @param referralRequest
	 * @return
	 */
	@CrossOrigin()
	@ApiOperation(value = "This will save information requested by the beneficiary during call",
			consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/saveBenCalReferralMapping", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String saveBenCalReferralMapping(@RequestBody String referralRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.debug("saveBenCalReferralMapping request is " + referralRequest);
		try
		{

			response.setResponse(
					benInformationCounsellingFeedbackReferralImpl.saveBenCalReferralMapping(referralRequest));
		} catch (Exception e)
		{
			logger.error("saveBenCalReferralMapping failed with exception " + e.getMessage(), e);
			response.setError(e);
		}
		logger.debug("saveBenCalReferralMapping response is " + response);
		return response.toString();
	}

	// @CrossOrigin()
	// @ApiOperation(value = "This will save information requested by the
	// beneficiary during call")
	// @RequestMapping(value = "/saveBenCalFeedbackMapping", method =
	// RequestMethod.POST)
	// public String saveBenCalFeedbackMapping(
	// @RequestBody String feedbackRequest) {
	//
	// return
	// benInformationCounsellingFeedbackReferralImpl.saveBenCalFeedbackMapping(feedbackRequest);
	// }
}
