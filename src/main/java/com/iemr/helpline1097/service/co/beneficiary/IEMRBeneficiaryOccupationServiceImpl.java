package com.iemr.helpline1097.service.co.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiary.I_BeneficiaryOccupation;
import com.iemr.helpline1097.repository.co.beneficiary.IEMRBeneficiaryOccupationRepositoryImplCustom;

@Service
public class IEMRBeneficiaryOccupationServiceImpl implements IEMRBeneficiaryOccupationService{
	
	@Autowired
	private IEMRBeneficiaryOccupationRepositoryImplCustom iemrBeneficiaryOccupationImplCustom;

	@Override
	public I_BeneficiaryOccupation addBeneficiaryOccupation(I_BeneficiaryOccupation i_beneficiaryoccupation) {
		
		return iemrBeneficiaryOccupationImplCustom.save(i_beneficiaryoccupation);
	}

	@Override
	public Iterable<I_BeneficiaryOccupation> getBeneficiaryOccupation() {
		return iemrBeneficiaryOccupationImplCustom.findAll();
	}

}
