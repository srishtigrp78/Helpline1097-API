package com.iemr.helpline1097.repository.co.beneficiarycall;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline1097.data.co.beneficiary.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	User findByUserID(Long userID);

}
