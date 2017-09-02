package com.iemr.helpline1097.controller.co.services;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.service.co.services.CommonService;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RestController
@RequestMapping(value = "/api/helpline1097/co/get")
public class CommonController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@CrossOrigin()
	@RequestMapping(value = "/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	// public Iterable<CategoryDetails> getCategories(){
	@Deprecated
	public String getCategories()
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getCategories().toString());
		} catch (Exception e)
		{
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/subcategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	@Deprecated
	public String getSubcategories(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			CategoryDetails category = inputMapper.gson().fromJson(request, CategoryDetails.class);
			response.setResponse(commonService.getSubCategories(category.getCategoryID()).toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/categoryByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	@Deprecated
	public String getcategoriesById(@RequestBody String request)
	{
		OutputResponse response = new OutputResponse();
		try
		{
			SubServices serviceMaster = inputMapper.gson().fromJson(request, SubServices.class);
			response.setResponse(commonService.getCategories(serviceMaster.getSubServiceID()).toString());
		} catch (

		Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "/servicetypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	@Deprecated
	public String getservicetypes()
	{
		OutputResponse response = new OutputResponse();
		try
		{
			response.setResponse(commonService.getActiveServiceTypes().toString());
		} catch (Exception e)
		{
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	/**
	 * Designation Service
	 */
	private CommonService commonService;

	@Autowired
	public void setCommonService(CommonService commonService)
	{
		this.commonService = commonService;
	}
}
