package com.iemr.helpline1097.controller.co.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline1097.utils.mapper.InputMapper;

@RestController
public class CounsellingController
{
	InputMapper inputMapper = new InputMapper();
	Logger logger = LoggerFactory.getLogger(CommonController.class);

	/*
	 * @CrossOrigin()
	 * 
	 * @RequestMapping(value = "/api/helpline1097/co/get/designation", method = RequestMethod.POST) public
	 * Iterable<DesignationDetails> getDesignations(){
	 * 
	 * return designationService.getDesignations(); }
	 * 
	 *//**
		 * Designation Service
		 *//*
		 * private DesignationService designationService;
		 * 
		 * @Autowired public void setDesignationService(DesignationService designationService){
		 * 
		 * this.designationService = designationService; }
		 */
}
