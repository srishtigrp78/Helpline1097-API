package com.iemr.helpline1097.service.co.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.beneficiary.M_Promoservice;
import com.iemr.helpline1097.repository.co.beneficiary.IEMRPromoserviceRepositoryImplCustom;

@Service
public class IEMRPromoserviceDetailsServiceImpl implements IEMRPromoserviceDetailsService{

	@Autowired 
	private IEMRPromoserviceRepositoryImplCustom iEMRPromoserviceRepositoryImplCustom;
	@Override
	public M_Promoservice addPromoServiceDetail(M_Promoservice m_promoservice) {
		return iEMRPromoserviceRepositoryImplCustom.save(m_promoservice);
	}

}
