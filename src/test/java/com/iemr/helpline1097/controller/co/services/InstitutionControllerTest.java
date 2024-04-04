package com.iemr.helpline1097.controller.co.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.service.co.services.InstitutionService;
import com.iemr.helpline1097.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class InstitutionControllerTest {

	@InjectMocks
	InstitutionController institutionController;

	@Mock
	private InstitutionService institutionService;

	@Test
	void getInstitutionsTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(institutionService.getInstitutions().toString());

		Assertions.assertEquals(response.toString(), institutionController.getInstitutions());
	}

	@Test
	void getInstitutionsTest_Exception() {

		String response = institutionController.getInstitutions();

		Assertions.assertEquals(response.toString(), institutionController.getInstitutions());
	}

}
