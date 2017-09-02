package com.iemr.helpline1097.service.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.repository.co.services.CategoryRepository;
import com.iemr.utils.mapper.InputMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
	/**
	 * category repository
	 */
	private CategoryRepository categoryRepository;

	/**
	 * inject category service
	 */
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	private InputMapper inputMapper = new InputMapper();

	@Override
	public List<CategoryDetails> getAllCategories(String request) {
		CategoryDetails categoryDetails = inputMapper.gson().fromJson(request, CategoryDetails.class);
		List<CategoryDetails> categoryList = new ArrayList<CategoryDetails>();
		ArrayList<Objects[]> lists = categoryRepository.getAllCategories(categoryDetails.getSubServiceID());
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 2) {
				categoryList.add(new CategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}

		return categoryList;
	}

	@Override
	public List<CategoryDetails> getAllCategories() {
		List<CategoryDetails> categoryList = new ArrayList<CategoryDetails>();
		ArrayList<Objects[]> lists = categoryRepository.findBy();

		for (Object[] objects : lists) {

			if (objects != null && objects.length > 0) {
				categoryList.add(new CategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}

		return categoryList;
	}
}
