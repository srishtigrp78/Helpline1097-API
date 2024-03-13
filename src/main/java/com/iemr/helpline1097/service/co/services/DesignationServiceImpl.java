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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.services.DesignationDetails;
import com.iemr.helpline1097.repository.co.services.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Override
	public List<DesignationDetails> getDesignations() {
		List<DesignationDetails> designationsList = new ArrayList<DesignationDetails>();
		Set<Object[]> designations = designationRepository.findAciveDesignations();
		for (Object[] designation : designations) {
			if (designation!=null && designation.length >= 2) {
				designationsList.add(new DesignationDetails((Integer) designation[0], (String) designation[1]));
			}
		}
		return designationsList;
	}
	
	/**
	 * Designation repository
	 */
	private DesignationRepository designationRepository;
	
	@Autowired
	public void setDesignationRepository(DesignationRepository designationRepository){
		
		this.designationRepository = designationRepository;
	}

}
