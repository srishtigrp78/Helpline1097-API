package com.iemr.helpline1097.service.co.beneficiary;

import com.iemr.helpline1097.data.co.beneficiary.I_BenDemographics;

public interface IEMRBenDemographicsService {

	I_BenDemographics addBenDemographics(I_BenDemographics i_benDemographics);
	
	Iterable<I_BenDemographics> getBenDemographics();
}
