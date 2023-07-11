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
package com.iemr.helpline1097.repository.co.beneficiarycall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

//import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.helpline1097.data.co.beneficiarycall.BeneficiaryCall;

@Repository
@RestResource(exported = false)
public interface BeneficiaryCallRepository extends CrudRepository<BeneficiaryCall, Long>
{
	@Query("select " + "b.benCallID, b.benCallServicesMappingHistories, b.calledServiceID, b.is1097, "
			+ "b.callTime, b.remarks, b.callClosureType, b.dispositionStatusID from BeneficiaryCall b "
			+ "where b.benCallID = :id order by b.benCallID desc")
	public ArrayList<Objects[]> findCallsByBenefeciaryID(@Param("id") long id, Pageable page);

	@Query("select b.benCallID, b.callTime, b.remarks, count(m.subCategoryID), "
			+ "count(m.feedbackID), count(m.instituteDirMapID) , b.createdDate, "
			+ "count(m.coSubCategoryID), c from BeneficiaryCall b left join b.benCallServicesMappingHistories m "
			+ "left join b.callTypeObj c "
			+ "where b.beneficiaryRegID = :id group by b.benCallID order by b.benCallID desc")
	public ArrayList<Objects[]> findCallsHistoryByBenefeciaryID(@Param("id") Long id, Pageable page);

	@Query("select b.benCallID, b.callTime, b.remarks, count(m.subCategoryID), "
			+ "count(m.feedbackID), count(m.instituteDirMapID) , b.createdDate, "
			+ "count(m.coSubCategoryID), c from BeneficiaryCall b left join b.benCallServicesMappingHistories m "
			+ "left join b.callTypeObj c "
			+ "where b.beneficiaryRegID = :beneficiaryRegID and b.calledServiceID = :calledServiceID "
			+ "group by b.benCallID order by b.benCallID desc")
	public ArrayList<Objects[]> findCallsHistoryByBenefeciaryID(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCallID, b.callTime, b.remarks, count(m.subCategoryID), "
			+ "count(m.feedbackID), count(m.instituteDirMapID) , b.createdDate, "
			+ "count(m.coSubCategoryID), c from BeneficiaryCall b left join b.benCallServicesMappingHistories m "
			+ "left join b.callTypeObj c " + "where b.benCallID = :id group by b.benCallID order by b.benCallID desc")
	public ArrayList<Objects[]> findCallSummaryByCallID(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update BeneficiaryCall set callTime = :callTime, remarks = :remarks, "
			+ "callClosureType = :callClosureType, " + "dispositionStatusID = :dispositionStatusID, "
			+ "callTypeID = :callTypeID where benCallID = :id")
	public int closeCall(@Param("id") Long id, @Param("remarks") String remarks, @Param("callTime") Timestamp callTime,
			@Param("callClosureType") String callClosureType,
			@Param("dispositionStatusID") Integer dispositionStatusID);

	@Transactional
	@Modifying
	@Query("update BeneficiaryCall set beneficiaryRegID = :beneficiaryRegID where benCallID = :id")
	public int updateBeneficiaryIDInCall(@Param("id") Long id, @Param("beneficiaryRegID") Long beneficiaryRegID);

}
