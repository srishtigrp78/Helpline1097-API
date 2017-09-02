package com.iemr.helpline1097.service.co.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.services.InstitutionDetails;
import com.iemr.helpline1097.repository.co.services.InstitutionRepository;

@Service
public class InstitutionServiceImpl implements InstitutionService {

	@Override
	public Iterable<InstitutionDetails> getInstitutions() {
		
		return institutionRepository.findAll();
	}

	/**
	 * Institution repository
	 */
	private InstitutionRepository institutionRepository;
	
	@Autowired
	public void setInstitutionRepository(InstitutionRepository institutionRepository){
		
		this.institutionRepository = institutionRepository;
	}
}
