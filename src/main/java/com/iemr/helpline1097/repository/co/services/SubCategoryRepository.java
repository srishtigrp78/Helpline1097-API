package com.iemr.helpline1097.repository.co.services;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.services.SubCategoryDetails;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategoryDetails, Integer>
{
	@Query("select subCategoryID, subCategoryName from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false")
	public ArrayList<Objects[]> findByCategoryID(@Param("categoryId") Integer categoryId);

	@Query("select subCategoryID, subCategoryName from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false")
	public ArrayList<Objects[]> findBy(@Param("categoryId") Integer categoryId);

	@Query("select subCatFilePath, subCategoryName, subCategoryDesc from SubCategoryDetails "
			+ "where subCategoryID = :subCategoryID and deleted = false")
	public Set<Objects[]> findFilePathBySubCategoryId(@Param("subCategoryID") Integer subCategoryID);
}
