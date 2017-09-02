package com.iemr.helpline1097.service.co.services;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;

public interface CommonService {

	public Iterable<CategoryDetails> getCategories();
	
	public Iterable<CategoryDetails> getCategories(Integer subServiceID);
	
	public Iterable<SubCategoryDetails> getSubCategories(Integer categoryID);
	
	public Iterable<SubServices> getActiveServiceTypes();

}
