package com.iemr.helpline1097.service.co.beneficiary;

import com.iemr.helpline1097.data.co.beneficiary.I_BeneficiaryEducation;

public interface IEMRBeneficiaryEducationService {
	I_BeneficiaryEducation addBeneficiaryEducation(I_BeneficiaryEducation i_beneficiaryeducation);
	
	Iterable<I_BeneficiaryEducation> getBeneficiaryEducation();
}
