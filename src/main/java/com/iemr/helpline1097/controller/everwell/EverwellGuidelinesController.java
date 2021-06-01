package com.iemr.helpline1097.controller.everwell;

import java.util.List;

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
import com.iemr.helpline1097.service.everwell.EverwellService;
import com.iemr.helpline1097.utils.mapper.InputMapper;
import com.iemr.helpline1097.utils.response.OutputResponse;

@RestController
public class EverwellGuidelinesController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private EverwellService everwellService;
	@CrossOrigin()
	@RequestMapping(
			value = "/saveEverwellGuidelines",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String saveEverwellGuidelines(@RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		try
		{
			String result = everwellService.saveGuidelines(request);
			response.setResponse(result);
		} catch (Exception e)
		{
			logger.error("Error while saving everwell guidelines ", e);
			response.setError(e);
		}
		return response.toString();
	}
	@CrossOrigin()
	@RequestMapping(
			value = "/fetchEverwellGuidelines",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String fetchEverwellGuidelines(@RequestBody String request)
	{

		OutputResponse response = new OutputResponse();
		try
		{
			String result = everwellService.fetchGuidelines(request);
			response.setResponse(result);
		} catch (Exception e)
		{
			logger.error("Error while fetching everwell guidelines ", e);
			response.setError(e);
		}
		return response.toString();
	}

}
