package com.iemr.helpline1097.service.co.callhandling;

import com.iemr.helpline1097.data.co.calltype.M_Calltype;

public interface IEMRCalltypeService {
	
	M_Calltype addCalltype(String callType,String remarks,String invalidType);
	M_Calltype addCalltype(M_Calltype m_Calltype);
	
	M_Calltype getAllCalltypes(int id);
	
	/*String updateCalltype(Integer id,String callType,String remarks,String invalidType);*/
	String updateCalltype(M_Calltype m_Calltype);
}
