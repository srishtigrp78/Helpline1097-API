package com.iemr.helpline1097.repository.co.services;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.services.DesignationDetails;

@Repository
@RestResource(exported = false)
public interface DesignationRepository extends CrudRepository<DesignationDetails, Integer> {

	@Query("select designationID, designationName from DesignationDetails where deleted=false")
	public Set<Objects[]> findAciveDesignations();
}
