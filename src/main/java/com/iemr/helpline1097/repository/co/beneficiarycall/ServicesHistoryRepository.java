package com.iemr.helpline1097.repository.co.beneficiarycall;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

@Repository
public interface ServicesHistoryRepository extends CrudRepository<BenCallServicesMappingHistory, Integer>
{

	@Query("select " + "benCall97ServiceMapID, beneficiaryRegID, benCallID, subServiceID, categoryID, "
			+ "subCategoryID, feedbackID, instituteDirMapID, createdBy, createdDate "
			+ "from BenCallServicesMappingHistory " + "where beneficiaryRegID = :beneficiaryRegID "
			+ " order by benCall97ServiceMapID desc")
	public Set<Objects[]> findBy(@Param("beneficiaryRegID") Long beneficiaryRegID);

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
	public List<Objects[]> getCallSummary(@Param("benCallID") Long benCallID);

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
	public List<Objects[]> getCallSummary(@Param("benCallID") Long benCallID,
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
	public List<Objects[]> findCallDetailsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID);

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
	public List<Objects[]> findCallDetailsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b left join b.subServices sm "
			+ "join b.instituteDirectoryMapping i join i.institutionDetails ii "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.instituteDirMapID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findReferralsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.feedbackID, b.feedbackDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b left join b.subServices sm join b.feedbackDetails f "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.feedbackID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findFeedbacksForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.subServices sm join b.categoryDetails c "
			+ "join b.subCategoryDetails s "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findInformationsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.coCategoryID, b.coCategoryDetails, b.coSubCategoryID, "
			+ "b.coSubCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.subServices sm join b.coCategoryDetails c "
			+ "join b.coSubCategoryDetails s "
			+ "where b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.coSubCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findCounsellingsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.instituteDirMapID, "
			+ "b.instituteDirectoryMapping, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc left join b.subServices sm "
			+ "join b.instituteDirectoryMapping i join i.institutionDetails ii "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.instituteDirMapID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findReferralsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.feedbackID, b.feedbackDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc left join b.subServices sm join b.feedbackDetails f "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.feedbackID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findFeedbacksForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.categoryID, b.categoryDetails, b.subCategoryID, "
			+ "b.subCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc join b.subServices sm "
			+ "join b.categoryDetails c join b.subCategoryDetails s "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.subCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findInformationsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);

	@Query("select b.benCall97ServiceMapID, b.beneficiaryRegID, b.benCallID, "
			+ "b.subServiceID, b.subServices, b.coCategoryID, b.coCategoryDetails, b.coSubCategoryID, "
			+ "b.coSubCategoryDetails, b.createdBy, b.createdDate "
			+ "from BenCallServicesMappingHistory b join b.beneficiaryCall bc join b.subServices sm "
			+ "join b.coCategoryDetails c join b.coSubCategoryDetails s "
			+ "where bc.calledServiceID = :calledServiceID and bc.benCallID = b.benCallID "
			+ "and b.beneficiaryRegID = :beneficiaryRegID group by b.benCallID, b.coSubCategoryID "
			+ "order by b.benCall97ServiceMapID desc ")
	public List<Objects[]> findCounsellingsForBeneficiary(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("calledServiceID") Integer calledServiceID, Pageable page);
}
