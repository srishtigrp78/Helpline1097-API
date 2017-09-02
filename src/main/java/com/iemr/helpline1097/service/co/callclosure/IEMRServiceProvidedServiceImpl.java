package com.iemr.helpline1097.service.co.callclosure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiarycall.ServiceProvided;
import com.iemr.helpline1097.repository.co.beneficiary.IEMRServiceProvidedRepositoryImplCustom;

@Service
public class IEMRServiceProvidedServiceImpl implements IEMRServiceProvidedService{

	@Autowired
	private IEMRServiceProvidedRepositoryImplCustom iEMRServiceProvidedRepositoryImplCustom;
	
	@Override
	public ServiceProvided addServiceProvided(ServiceProvided m_serviceprovided) {
		return iEMRServiceProvidedRepositoryImplCustom.save(m_serviceprovided);
	}

}
