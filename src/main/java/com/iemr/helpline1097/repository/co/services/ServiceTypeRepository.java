package com.iemr.helpline1097.repository.co.services;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;

@Repository
@RestResource(exported = false)
public interface ServiceTypeRepository extends CrudRepository<SubServices, Integer>
{

	@Query("select subServiceID, subServiceName, subServiceDesc, deleted from SubServices")
	public ArrayList<Objects[]> findActiveServiceTypes();
}
