package com.iemr.helpline1097.service.co.services;

import java.util.List;

import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.utils.exception.IEMRException;



public interface CategoryService {

	public abstract List<CategoryDetails> getAllCategories();

	List<CategoryDetails> getAllCategories(String request) throws IEMRException;

}
