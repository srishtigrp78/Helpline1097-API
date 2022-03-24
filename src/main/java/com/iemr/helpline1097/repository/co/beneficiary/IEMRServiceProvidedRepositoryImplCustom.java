package com.iemr.helpline1097.repository.co.beneficiary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiarycall.ServiceProvided;

@Repository
@RestResource(exported = false)
public interface IEMRServiceProvidedRepositoryImplCustom extends CrudRepository<ServiceProvided, Long>{

		
}
