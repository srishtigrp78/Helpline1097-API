package com.iemr.helpline1097.repository.co.services;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iemr.helpline1097.data.co.beneficiarycall.SubServices;

public interface ServiceTypeRepository extends CrudRepository<SubServices, Integer>
{

	@Query("select subServiceID, subServiceName, subServiceDesc, deleted from SubServices")
	public ArrayList<Objects[]> findActiveServiceTypes();
}
