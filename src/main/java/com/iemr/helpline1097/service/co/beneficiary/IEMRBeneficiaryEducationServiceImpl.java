package com.iemr.helpline1097.service.co.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiary.I_BeneficiaryEducation;
import com.iemr.helpline1097.repository.co.beneficiary.IEMRBeneficiaryEducationRepositoryImplCustom;

@Service
public class IEMRBeneficiaryEducationServiceImpl implements IEMRBeneficiaryEducationService {
	
	@Autowired
	private IEMRBeneficiaryEducationRepositoryImplCustom iemrBeneficiaryEducationImplCustom;

	@Override
	public I_BeneficiaryEducation addBeneficiaryEducation(I_BeneficiaryEducation i_beneficiaryeducation) {
		
		return iemrBeneficiaryEducationImplCustom.save(i_beneficiaryeducation);
	}

	@Override
	public Iterable<I_BeneficiaryEducation> getBeneficiaryEducation() {
		return iemrBeneficiaryEducationImplCustom.findAll();
	}

}
