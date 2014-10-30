package com.oomoque.rest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.oomoque.rest.dao.WalletDao;
import com.oomoque.rest.model.Wallet;

@Component
public class WalletServices {
	@Autowired
	WalletDao walletDao;

	public String saveWallet(){
	  Wallet wallet = new Wallet();
	  StringBuilder saveWalletBuilder = new StringBuilder();
	  JSONObject JObject = JSONFactoryUtil.createJSONObject();
	  
	  wallet.setWalletKey("adfasdgsvbv12345");
	  Date date = new Date(System.currentTimeMillis());
	  wallet.setCreatedDate(date);
	  wallet.setModifiedDate(date);
	  wallet.setLastSyncTime(date);
	  wallet.setLastSyncStatus(true);
	  walletDao.saveWallet(wallet);
	  
	  JObject.put("message", "success");
	  saveWalletBuilder.append(JObject);
	  
	  return saveWalletBuilder.toString();
	}
	
	public String deleteWallet(String walletId){
		
		Wallet wallet = new Wallet();
		wallet.setWalletId(walletId);
		walletDao.deleteWallet(wallet);
		
		StringBuilder deleteWalletBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("message", "success");
		deleteWalletBuilder.append(JObject);
		
		return deleteWalletBuilder.toString();
	}
	
	public String findWalletById(String walletId){
		Wallet wallet = walletDao.findWalletById(walletId);
		StringBuilder searchOneWallet = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("walletId", wallet.getWalletId());
		JObject.put("created_date", wallet.getCreatedDate());
		JObject.put("last_sync_time", wallet.getLastSyncTime());
		JObject.put("modified_date", wallet.getModifiedDate());
		JObject.put("wallet_key", wallet.getWalletKey());
		JObject.put("last_synk_status", wallet.getLastSyncStatus());
		searchOneWallet.append(JObject.toString());
		return searchOneWallet.toString();
	}
	
	public String updateWallet(String walletId){
		  Wallet wallet = walletDao.findWalletById(walletId);
		  StringBuilder updateWalletBuilder = new StringBuilder();
		  JSONObject JObject = JSONFactoryUtil.createJSONObject();
		  
		  wallet.setWalletKey("adfasdgsvbv12345");
		  Date date = new Date(System.currentTimeMillis());
		  wallet.setCreatedDate(date);
		  wallet.setModifiedDate(date);
		  wallet.setLastSyncTime(date);
		  wallet.setLastSyncStatus(true);
		  walletDao.saveWallet(wallet);
		  JObject.put("message", "success");
		  updateWalletBuilder.append(JObject);
		  return updateWalletBuilder.toString();
		}
}
