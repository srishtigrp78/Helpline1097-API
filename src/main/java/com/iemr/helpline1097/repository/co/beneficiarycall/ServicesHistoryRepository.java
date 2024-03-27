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

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.math.BigInteger;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

@Repository
@RestResource(exported = false)
public interface ServicesHistoryRepository extends CrudRepository<BenCallServicesMappingHistory, BigInteger>
{

	@Query("select " + "benCall97ServiceMapID, beneficiaryRegID, benCallID, subServiceID, categoryID, "
			+ "subCategoryID, feedbackID, instituteDirMapID, createdBy, createdDate "
			+ "from BenCallServicesMappingHistory " + "where beneficiaryRegID = :beneficiaryRegID "
			+ " order by benCall97ServiceMapID desc")
	public Set<Object[]> findBy(@Param("beneficiaryRegID") Long beneficiaryRegID);

	// @Query("select benCall97ServiceMapID, beneficiaryRegID, benCallID,
	// subServiceID, categoryID, subCategoryID, feedbackID, "
	// + "instituteDirMapID from BenCallServicesMappingHistory where benCallID =
	// :benCallID")
	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.feedbackID, b.feedbackDetails, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate, b.coCategoryID, b.coCategoryDetails, "
			+ "b.coSubCategoryID, b.coSubCategoryDetails  "
			+ "from BenCallServicesMappingHistory b join b.subServices sm left join b.categoryDetails c "
			+ "left join b.subCategoryDetails s left join b.feedbackDetails f left join b.instituteDirectoryMapping i "
			+ "where b.benCallID = :benCallID order by b.benCall97ServiceMapID desc ")
	public List<Object[]> getCallSummary(@Param("benCallID") Long benCallID);

	@Query("select b from BenCallServicesMappingHistory b where b.benCallID = :benCallID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<BenCallServicesMappingHistory> getCallSummaryV1(@Param("benCallID") Long benCallID);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.feedbackID, b.feedbackDetails, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate, b.coCategoryID, b.coCategoryDetails, "
			+ "b.coSubCategoryID, b.coSubCategoryDetails  "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc join b.subServices sm "
			+ "left join b.categoryDetails c left join b.subCategoryDetails s left join b.feedbackDetails f "
			+ "left join b.instituteDirectoryMapping i "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.benCallID = :benCallID group by b.benCallID, b.subServices "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> getCallSummary(@Param("benCallID") Long benCallID,
			@Param("calledServiceID") Integer calledServiceID);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.feedbackID, b.feedbackDetails, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping , b.createdBy, b.createdDate, b.coCategoryID, b.coCategoryDetails, "
			+ "b.coSubCategoryID, b.coSubCategoryDetails "
			+ "from BenCallServicesMappingHistory b left join b.subServices sm left join b.categoryDetails c "
			+ "left join b.subCategoryDetails s left join b.feedbackDetails f left join b.instituteDirectoryMapping i "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subServices "
			+ "order by b.benCall97ServiceMapID desc")
	public List<Object[]> findCallDetailsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.feedbackID, b.feedbackDetails, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping , b.createdBy, b.createdDate, b.coCategoryID, b.coCategoryDetails, "
			+ "b.coSubCategoryID, b.coSubCategoryDetails "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc left join b.subServices sm "
			+ "left join b.categoryDetails c left join b.subCategoryDetails s left join b.feedbackDetails f "
			+ "left join b.instituteDirectoryMapping i "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subServices "
			+ "order by b.benCall97ServiceMapID desc")
	public List<Object[]> findCallDetailsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b left join b.subServices sm "
			+ "join b.instituteDirectoryMapping i join i.institutionDetails ii "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.instituteDirMapID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findReferralsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.feedbackID, b.feedbackDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b left join b.subServices sm join b.feedbackDetails f "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.feedbackID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findFeedbacksForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.subServices sm join b.categoryDetails c "
			+ "join b.subCategoryDetails s "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findInformationsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.coCategoryID, b.coCategoryDetails, b.coSubCategoryID, "
			+ "b.coSubCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.subServices sm join b.coCategoryDetails c "
			+ "join b.coSubCategoryDetails s "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.coSubCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findCounsellingsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc left join b.subServices sm "
			+ "join b.instituteDirectoryMapping i join i.institutionDetails ii "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.instituteDirMapID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findReferralsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.feedbackID, b.feedbackDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc left join b.subServices sm join b.feedbackDetails f "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.feedbackID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findFeedbacksForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc join b.subServices sm "
			+ "join b.categoryDetails c join b.subCategoryDetails s "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findInformationsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.coCategoryID, b.coCategoryDetails, b.coSubCategoryID, "
			+ "b.coSubCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc join b.subServices sm "
			+ "join b.coCategoryDetails c join b.coSubCategoryDetails s "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.coSubCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Object[]> findCounsellingsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);
}
