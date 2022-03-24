package com.iemr.helpline1097.repository.co.services;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.services.CategoryDetails;

@Repository
@RestResource(exported = false)
public interface CategoryRepository extends CrudRepository<CategoryDetails, Integer> {

	@Query("select categoryID, categoryName from CategoryDetails where deleted=false")
	public ArrayList<Objects[]> findBy();

	@Query("select categoryID, categoryName from CategoryDetails  "
			+ "where deleted=false and subServiceID=:subServiceID ")
	public ArrayList<Objects[]> getAllCategories(@Param("subServiceID") Integer subServiceID);
}
