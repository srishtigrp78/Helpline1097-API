package com.iemr.helpline1097.repository.co.calltype;


import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.helpline1097.data.co.calltype.M_Calltype;

public interface IEMRCalltypeRepositoryImplCustom extends CrudRepository<M_Calltype, Long> {
	
	

	@Query("select callType,remarks from M_Calltype")
	Iterable<M_Calltype> readData();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE M_Calltype c set c.remarks =:remarks, c.callType =:callType where c.id = :id")
	int updateCallType(@Param("id") Long id,@Param("callType") String callType, @Param("remarks") String remarks);
	
	/*@Query("UPDATE M_Calltype c set c.remarks =:"+m_Calltype.getId()+", c.callType =:m_Calltype.getId() where c.id = :m_Calltype.getId()")
	int updateCallType(M_Calltype m_Calltype);*/
	
	@Query("select callType,remarks from M_Calltype")
	Set<Objects[]> getCallTypes();
}
