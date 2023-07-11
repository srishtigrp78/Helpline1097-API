/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
