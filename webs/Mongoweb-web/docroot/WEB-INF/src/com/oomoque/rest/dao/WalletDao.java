package com.oomoque.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.oomoque.rest.model.Wallet;

@Service
public class WalletDao {
	
	@Autowired
	MongoOperations mongoOperations;
	
	public void saveWallet(Wallet wallet){
		mongoOperations.save(wallet);
	};
	
	public void deleteWallet(Wallet wallet){
		mongoOperations.remove(wallet);
	};
	
	public Wallet findWalletById(String walletId){
		Query searchWalletQuery = new Query(Criteria.where("_id").is(walletId));
		Wallet wallet = mongoOperations.findOne(searchWalletQuery, Wallet.class);
		return wallet;
	};
}
