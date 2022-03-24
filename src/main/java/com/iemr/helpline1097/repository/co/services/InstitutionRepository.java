package com.iemr.helpline1097.repository.co.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.services.InstitutionDetails;

@Repository
@RestResource(exported = false)
public interface InstitutionRepository extends CrudRepository<InstitutionDetails, Integer> {

	@Query("select institutes from InstitutionDetails institutes where institutes.institutionID = :institutionID")
	List<InstitutionDetails> getInstitutionDetails(@Param("institutionID")Integer institutionID);
}
