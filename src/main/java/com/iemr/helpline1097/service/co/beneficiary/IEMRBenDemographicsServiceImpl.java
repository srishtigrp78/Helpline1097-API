package com.iemr.helpline1097.service.co.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiary.I_BenDemographics;
import com.iemr.helpline1097.repository.co.beneficiary.IEMRBenDemographicsRepositoryImplCustom;

@Service
public class IEMRBenDemographicsServiceImpl implements IEMRBenDemographicsService{
	@Autowired
	private IEMRBenDemographicsRepositoryImplCustom iEMRBenDemographicsRepositoryImplCustom;

	@Override
	public I_BenDemographics addBenDemographics(I_BenDemographics i_benDemographics) {
		return iEMRBenDemographicsRepositoryImplCustom.save(i_benDemographics);
	}

	@Override
	public Iterable<I_BenDemographics> getBenDemographics() {
		return iEMRBenDemographicsRepositoryImplCustom.findAll();
	}

}
