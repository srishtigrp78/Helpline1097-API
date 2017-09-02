package com.iemr.helpline1097.service.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.services.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Override
	public List<SubCategoryDetails> getSubCategories(int id) {
		
		List<SubCategoryDetails> subCategoryList = new ArrayList<SubCategoryDetails>();
		ArrayList<Objects[]> lists = subCategoryRepository.findBy(id);
		for (Object[] objects : lists) {
			if (objects!=null && objects.length > 0) {
				subCategoryList.add(new SubCategoryDetails((Integer)objects[0], (String)objects[1]));
			}
		}
		
		return subCategoryList;
	}
	
	/**
	 * sub category repository
	 */
	private SubCategoryRepository subCategoryRepository;
	
	/**
	 * inject sub category
	 */
	@Autowired
	public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository){
		
		this.subCategoryRepository = subCategoryRepository;
	}

}
