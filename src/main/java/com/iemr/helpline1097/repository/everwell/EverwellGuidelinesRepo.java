package com.iemr.helpline1097.repository.everwell;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.everwell.EverwellGuidelines;
@Repository
public interface EverwellGuidelinesRepo extends CrudRepository<EverwellGuidelines, Integer> { 
	@Query("select b from EverwellGuidelines b "
			+ "where b.category = :category and b.providerServiceMapID = :providerServiceMapID and b.deleted!=true ")
	public List<EverwellGuidelines> findGuidelinesByCategory(@Param("category") String category,@Param("providerServiceMapID") Integer providerServiceMapID);

	public List<EverwellGuidelines> findByProviderServiceMapID(Integer providerServiceMapID);
	

}
