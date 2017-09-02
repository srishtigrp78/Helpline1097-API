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
		Set<Objects[]> designations = designationRepository.findAciveDesignations();
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
