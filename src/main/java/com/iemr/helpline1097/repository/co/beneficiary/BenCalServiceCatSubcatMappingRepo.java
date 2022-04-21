package com.iemr.helpline1097.repository.co.beneficiary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiarycall.BenCallServicesMappingHistory;

@Repository
@RestResource(exported = false)
public interface BenCalServiceCatSubcatMappingRepo extends CrudRepository<BenCallServicesMappingHistory, Long> {

}
