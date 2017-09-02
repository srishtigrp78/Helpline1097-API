package com.iemr.helpline1097.controller.co.services;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.service.co.services.CategoryService;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@RestController
public class CategoryController {
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	@CrossOrigin()
	@RequestMapping(value = "/api/helpline1097/v1/get/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String getAllCategries() {

		OutputResponse response = new OutputResponse();
		try {
			List<CategoryDetails> categoryList = this.categoryService.getAllCategories();
			response.setResponse(categoryList.toString());
		} catch (Exception e) {
			logger.error("", e);
			response.setError(e);
		}
		return response.toString();
	}

	/**
	 * Category srvice
	 */
	private CategoryService categoryService;

	/**
	 * Inject category service
	 */
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
