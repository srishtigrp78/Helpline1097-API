package com.iemr.helpline1097.service.co.callhandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.helpline1097.data.co.calltype.M_Calltype;
import com.iemr.helpline1097.repository.co.calltype.IEMRCalltypeRepositoryImplCustom;

@Service
public class IEMRCalltypeServiceImpl implements IEMRCalltypeService {

	/*
	 * @Autowired M_Calltype m_calltype;
	 */
	@Autowired
	private IEMRCalltypeRepositoryImplCustom iEMRCalltypeRepositoryImplCustom;

	/*
	 * @Autowired public void
	 * setIemrCalltypeRepositoryImpl(BeneficiaryCallRepository
	 * iEMRCalltypeRepositoryImplCustom) { this.iemrCalltypeRepositoryImplCustom
	 * = iEMRCalltypeRepositoryImplCustom; }
	 */

	@Override
	public M_Calltype addCalltype(String callType, String remarks, String invalidType) {

		M_Calltype m_calltype = new M_Calltype();
		m_calltype.setCallType(callType);
		m_calltype.setRemarks(remarks);
		m_calltype.setInvalidType(invalidType);
		System.out.println("" + iEMRCalltypeRepositoryImplCustom.save(m_calltype));
		return iEMRCalltypeRepositoryImplCustom.save(m_calltype);
	}

	@Override
	public M_Calltype addCalltype(M_Calltype m_calltype) {

		System.out.println("" + iEMRCalltypeRepositoryImplCustom.save(m_calltype));
		return iEMRCalltypeRepositoryImplCustom.save(m_calltype);
	}

	@Override
	public M_Calltype getAllCalltypes(int id) {

		return iEMRCalltypeRepositoryImplCustom.findOne(new Long(id));
	}

	@Override
	public String updateCalltype(M_Calltype m_Calltype) {

		iEMRCalltypeRepositoryImplCustom.updateCallType(new Long(m_Calltype.getId()), m_Calltype.getCallType(),
				m_Calltype.getRemarks());
		// iEMRCalltypeRepositoryImplCustom.updateCallType(m_Calltype);
		return "success";
	}

}
