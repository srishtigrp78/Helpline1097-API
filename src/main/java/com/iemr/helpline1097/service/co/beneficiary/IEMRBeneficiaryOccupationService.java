package com.iemr.helpline1097.service.co.beneficiary;

import com.iemr.helpline1097.data.co.beneficiary.I_BeneficiaryOccupation;

public interface IEMRBeneficiaryOccupationService {

	I_BeneficiaryOccupation addBeneficiaryOccupation(I_BeneficiaryOccupation i_beneficiaryoccupation);
	
	Iterable<I_BeneficiaryOccupation> getBeneficiaryOccupation();
}
