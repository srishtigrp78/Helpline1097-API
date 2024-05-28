package com.iemr.helpline1097.controller.co.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.service.co.services.DesignationService;
import com.iemr.helpline1097.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class DesignationControllerTest {

	@InjectMocks
	DesignationController designationController;

	@Mock
	private DesignationService designationService;

	@Test
	void getDesignationsTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(designationService.getDesignations().toString());

		Assertions.assertEquals(response.toString(), designationController.getDesignations());
	}

	@Test
	void getDesignationsTest_Exception() {

		String response = designationController.getDesignations();

		Assertions.assertEquals(response.toString(), designationController.getDesignations());
	}

}
