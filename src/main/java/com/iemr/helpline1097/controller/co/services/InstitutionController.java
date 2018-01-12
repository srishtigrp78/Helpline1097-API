package com.iemr.helpline1097.controller.co.services;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.service.co.services.InstitutionService;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

@RestController
public class InstitutionController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@CrossOrigin()
	@RequestMapping(
			value = "/api/helpline1097/co/get/institutions",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON)
	public String getInstitutions()
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(institutionService.getInstitutions().toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	/**
	 * Institution service
	 */
	private InstitutionService institutionService;

	@Autowired
	public void setInstitutionService(InstitutionService institutionService)
	{

		this.institutionService = institutionService;
	}
}
