package com.iemr.helpline1097.controller.co.services;

import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.service.co.services.CommonService;
import com.iemr.helpline1097.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class CommonControllerTest {

	@InjectMocks
	CommonController commonController;

	@Mock
	private CommonService commonService;

	@Test
	void getCategoriesTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getCategories().toString());

		Assertions.assertEquals(response.toString(), commonController.getCategories());
	}

	@Test
	void getCategoriesTest_Exception() {

		String response = commonController.getCategories();

		Assertions.assertEquals(response, commonController.getCategories());
	}

	@Test
	void getSubcategoriesTest() {

		String request = "request";

		CategoryDetails categoryDetails3 = new CategoryDetails();
		categoryDetails3.setCategoryDesc("Category Desc");
		categoryDetails3.setCategoryID(1);
		categoryDetails3.setCategoryName("Category Name");
		categoryDetails3.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		categoryDetails3.setCreatedDate(mock(Timestamp.class));
		categoryDetails3.setDeleted(true);
		categoryDetails3.setLastModDate(mock(Timestamp.class));
		categoryDetails3.setSubServiceID(1);

		categoryDetails3.toString();

		String response = commonController.getSubcategories(request);

		Assertions.assertEquals(response, commonController.getSubcategories(request));

	}

	@Test
	void getSubcategoriesTest_Exception() {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = commonController.getSubcategories(request);

		Assertions.assertEquals(response, commonController.getSubcategories(request));
	}

	@Test
	void getcategoriesByIdTest() {

		String request = "request";

		SubServices serviceMaster = new SubServices();

		serviceMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		serviceMaster.setCreatedDate(mock(Timestamp.class));
		serviceMaster.setDeleted(true);
		serviceMaster.setLastModDate(mock(Timestamp.class));
		serviceMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		serviceMaster.setSubServiceDesc("Sub Service Desc");
		serviceMaster.setSubServiceID(1);
		serviceMaster.setSubServiceName("Sub Service Name");

		serviceMaster.toString();

		String response = commonController.getcategoriesById(request);

		Assertions.assertEquals(response, commonController.getcategoriesById(request));
	}

	@Test
	void getcategoriesByIdTest_Exception() {

		String request = "{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}";

		String response = commonController.getcategoriesById(request);

		Assertions.assertEquals(response, commonController.getcategoriesById(request));
	}

	@Test
	void getservicetypesTest() {

		OutputResponse response = new OutputResponse();

		response.setResponse(commonService.getActiveServiceTypes().toString());

		Assertions.assertEquals(response.toString(), commonController.getservicetypes());
	}

	@Test
	void getservicetypesTest_Exception() {

		String response = commonController.getservicetypes();

		Assertions.assertEquals(response, commonController.getservicetypes());
	}

}
