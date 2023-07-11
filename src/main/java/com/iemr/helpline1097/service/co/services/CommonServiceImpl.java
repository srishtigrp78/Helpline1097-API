/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.helpline1097.service.co.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;
import com.iemr.helpline1097.data.co.services.CategoryDetails;
import com.iemr.helpline1097.data.co.services.SubCategoryDetails;
import com.iemr.helpline1097.repository.co.services.CategoryRepository;
import com.iemr.helpline1097.repository.co.services.ServiceTypeRepository;
import com.iemr.helpline1097.repository.co.services.SubCategoryRepository;

@Service
public class CommonServiceImpl implements CommonService {

	/**
	 * Designation repository
	 */
	private ServiceTypeRepository serviceTypeRepository;
	private CategoryRepository categoryRepository;
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {

		this.categoryRepository = categoryRepository;
	}

	@Autowired
	public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository) {

		this.subCategoryRepository = subCategoryRepository;
	}

	@Autowired
	public void setServiceTypeRepository(ServiceTypeRepository serviceTypeRepository) {

		this.serviceTypeRepository = serviceTypeRepository;
	}

	@Override
	public Iterable<CategoryDetails> getCategories() {
		List<CategoryDetails> categoriesList = new ArrayList<CategoryDetails>();
		ArrayList<Objects[]> lists = categoryRepository.findBy();
		for (Object[] objects : lists) {
			if (objects != null && objects.length > 1) {
				System.out.println(objects);
				categoriesList.add(new CategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}
		return categoriesList;
	}

	@Override
	public Iterable<SubCategoryDetails> getSubCategories(Integer categoryID) {
		List<SubCategoryDetails> subCategoriesList = new ArrayList<SubCategoryDetails>();
		ArrayList<Objects[]> lists = subCategoryRepository.findByCategoryID(categoryID);
		for (Object[] objects : lists) {
			if (objects != null && objects.length > 1) {
				subCategoriesList.add(new SubCategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}
		return subCategoriesList;
	}

	@Override
	public Iterable<CategoryDetails> getCategories(Integer subServiceID) {
		List<CategoryDetails> categoriesList = new ArrayList<CategoryDetails>();
		ArrayList<Objects[]> lists = categoryRepository.getAllCategories(subServiceID);
		for (Object[] objects : lists) {
			if (objects != null && objects.length > 1) {
				System.out.println(objects);
				categoriesList.add(new CategoryDetails((Integer) objects[0], (String) objects[1]));
			}
		}
		return categoriesList;
	}

	@Override
	public Iterable<SubServices> getActiveServiceTypes() {
		List<SubServices> serviceTypes1097List = new ArrayList<SubServices>();
		ArrayList<Objects[]> lists = serviceTypeRepository.findActiveServiceTypes();
		for (Object[] objects : lists) {
			if (objects != null && objects.length >= 4) {
				serviceTypes1097List.add(new SubServices((Integer) objects[0], (String) objects[1],
						(String) objects[2], (Boolean) objects[3]));
			}
		}
		return serviceTypes1097List;
	}

}
