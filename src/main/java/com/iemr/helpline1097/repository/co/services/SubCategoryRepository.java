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
package com.iemr.helpline1097.repository.co.services;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.services.SubCategoryDetails;

@Repository
@RestResource(exported = false)
public interface SubCategoryRepository extends CrudRepository<SubCategoryDetails, Integer>
{
	@Query("select subCategoryID, subCategoryName from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false")
	public ArrayList<Object[]> findByCategoryID(@Param("categoryId") Integer categoryId);

	@Query("select subCategoryID, subCategoryName from SubCategoryDetails "
			+ "where categoryID = :categoryId and deleted = false")
	public ArrayList<Object[]> findBy(@Param("categoryId") Integer categoryId);

	@Query("select subCatFilePath, subCategoryName, subCategoryDesc from SubCategoryDetails "
			+ "where subCategoryID = :subCategoryID and deleted = false")
	public Set<Object[]> findFilePathBySubCategoryId(@Param("subCategoryID") Integer subCategoryID);
}
