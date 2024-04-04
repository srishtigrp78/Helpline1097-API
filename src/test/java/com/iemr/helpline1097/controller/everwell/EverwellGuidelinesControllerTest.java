package com.iemr.helpline1097.controller.everwell;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.service.everwell.EverwellService;
import com.iemr.helpline1097.utils.exception.IEMRException;

import jakarta.ws.rs.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EverwellGuidelinesControllerTest {

	@InjectMocks
	EverwellGuidelinesController everwellGuidelinesController;

	@Mock
	private EverwellService everwellService;

	@Test
	void saveEverwellGuidelinesTest() throws IEMRException {

		String request = "{\"providerServiceMapID\":123,\"Category\":\\\"String\\\",\"fileContent\":\"String\"\"\\\"GuidelineName\\\":\\\"String\\\"\"\\\"GuidelineDescription\\\":\\\"String\\\"}";

		String result = request;

		when(everwellService.saveGuidelines(request)).thenReturn(result);

		String response = everwellGuidelinesController.saveEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.saveEverwellGuidelines(request));

	}

	@Test
	void saveEverwellGuidelinesTest_Exception() throws IEMRException {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(everwellService.saveGuidelines(request)).thenThrow(NotFoundException.class);

		String response = everwellGuidelinesController.saveEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.saveEverwellGuidelines(request));
	}

	@Test
	void fetchEverwellGuidelinesTest() throws IEMRException {

		String request = "{\"providerServiceMapID\":123,\"adherencePercentage\":234}";

		String result = request;

		when(everwellService.fetchGuidelines(request)).thenReturn(result);

		String response = everwellGuidelinesController.fetchEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.fetchEverwellGuidelines(request));

	}

	@Test
	void fetchEverwellGuidelinesTest_Exception() throws IEMRException {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(everwellService.fetchGuidelines(request)).thenThrow(NotFoundException.class);

		String response = everwellGuidelinesController.fetchEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.fetchEverwellGuidelines(request));
	}

	@Test
	void deleteEverwellGuidelinesTest() throws IEMRException {

		String request = "{\"Id\":1,\"modifiedBy\":\\\"String\\\"}";

		String result = request;

		when(everwellService.deleteGuideline(request)).thenReturn(result);

		String response = everwellGuidelinesController.deleteEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.deleteEverwellGuidelines(request));

	}

	@Test
	void deleteEverwellGuidelinesTest_Exception() throws IEMRException {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		when(everwellService.deleteGuideline(request)).thenThrow(NotFoundException.class);

		String response = everwellGuidelinesController.deleteEverwellGuidelines(request);

		Assertions.assertEquals(response, everwellGuidelinesController.deleteEverwellGuidelines(request));
	}

}
