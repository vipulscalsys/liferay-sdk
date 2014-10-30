package com.oomoque.rest.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.oomoque.rest.model.UserType;

@Service
public class UserTypeDao {
	@Autowired
	MongoOperations mongoOperations;
	
	public void saveUserType(UserType userType){
		mongoOperations.save(userType);
	};
	
	public void deleteUserType(UserType userType){
		mongoOperations.remove(userType);
	};
	
	public UserType findUserTypeById(String userTypeId){
		Query searchUserTypeQuery = new Query(Criteria.where("_id").is(userTypeId));
		UserType userType = mongoOperations.findOne(searchUserTypeQuery, UserType.class);
		return userType;
	};
	
	public List<UserType> getUserTypeList(){
		List<UserType> userTypeList = (List<UserType>) mongoOperations.findAll(UserType.class);
		return userTypeList;
	}
}
