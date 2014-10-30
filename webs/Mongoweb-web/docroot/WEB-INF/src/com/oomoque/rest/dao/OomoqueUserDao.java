package com.oomoque.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.oomoque.rest.model.OomoqueUser;


@Service
public class OomoqueUserDao {
	@Autowired
	MongoOperations mongoOperations;
	
	public void saveOomoqueUser(OomoqueUser ouser){
		mongoOperations.save(ouser);
	};
	
	public void deleteOomoqueUser(OomoqueUser ouser){
		mongoOperations.remove(ouser);
	};
	
	public OomoqueUser findOomoqueUserById(String userId){
		Query searchOUserQuery = new Query(Criteria.where("_id").is(userId));
		OomoqueUser ouser = mongoOperations.findOne(searchOUserQuery, OomoqueUser.class);
		return ouser;
	};
	
}
