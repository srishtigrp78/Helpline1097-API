package com.iemr.helpline1097.service.co.services;

import java.util.List;

import com.iemr.helpline1097.data.co.services.SubCategoryDetails;



public interface SubCategoryService {

	public abstract List<SubCategoryDetails> getSubCategories(int id);

}
