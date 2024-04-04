package com.iemr.helpline1097.service.co.callhandling;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.helpline1097.data.co.calltype.M_Calltype;
import com.iemr.helpline1097.repository.co.calltype.IEMRCalltypeRepositoryImplCustom;

@ExtendWith(MockitoExtension.class)
class IEMRCalltypeServiceImplTest {

	@InjectMocks
	IEMRCalltypeServiceImpl iEMRCalltypeServiceImpl;

	@Mock
	private IEMRCalltypeRepositoryImplCustom iEMRCalltypeRepositoryImplCustom;

	@Test
	void addCalltypeTest2() {

		String callType = "callType";
		String remarks = "remarks";
		String invalidType = "invalidType";

		M_Calltype m_calltype = new M_Calltype("callType", "remarks", "invalidType");
		m_calltype.setId(null);
		m_calltype.setCallType(callType);
		m_calltype.setRemarks(remarks);
		m_calltype.setInvalidType(invalidType);

		m_calltype.toString();

		when(iEMRCalltypeRepositoryImplCustom.save(m_calltype)).thenReturn(m_calltype);

		Assertions.assertEquals(m_calltype, iEMRCalltypeServiceImpl.addCalltype(m_calltype));
	}

	@Test
	void getAllCalltypesTest() {

		int id = 12;

		M_Calltype m_calltype = new M_Calltype("callType", "remarks", "invalidType");
		m_calltype.setId(12L);
		m_calltype.setCallType("callType");
		m_calltype.setRemarks("remarks");
		m_calltype.setInvalidType("invalidType");

		m_calltype.toString();

		when(iEMRCalltypeRepositoryImplCustom.findById(new Long(id))).thenReturn(Optional.of(m_calltype));

		Assertions.assertEquals(m_calltype, iEMRCalltypeServiceImpl.getAllCalltypes(id));
	}

	@Test
	void updateCalltypeTest() {

		M_Calltype m_Calltype = new M_Calltype("callType", "remarks", "invalidType");
		m_Calltype.setId(12L);
		m_Calltype.setCallType("callType");
		m_Calltype.setRemarks("remarks");
		m_Calltype.setInvalidType("invalidType");

		m_Calltype.toString();

		when(iEMRCalltypeRepositoryImplCustom.updateCallType(new Long(m_Calltype.getId()), m_Calltype.getCallType(),
				m_Calltype.getRemarks())).thenReturn(12);

		Assertions.assertEquals("success", iEMRCalltypeServiceImpl.updateCalltype(m_Calltype));
	}

}
