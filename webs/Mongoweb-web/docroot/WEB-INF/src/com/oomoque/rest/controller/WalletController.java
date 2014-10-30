package com.oomoque.rest.controller;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.HeaderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.oomoque.rest.model.Wallet;
import com.oomoque.rest.service.WalletServices;

@RestController
@RequestMapping("/oomoque-system")
public class WalletController {

	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	WalletServices walletService;
	
	/** Operation for add new Wallet  */
	@RequestMapping(value = "/saveWallet", method = RequestMethod.POST)
	public String saveWallet(){
		  return walletService.saveWallet().toString();
	}
	/** Operation for delete Wallet  */
	@RequestMapping(value = "/deleteWallet", method = RequestMethod.DELETE)
	public String deleteWallet(@HeaderParam("walletId") String walletId){
		return walletService.deleteWallet(walletId).toString();
	}
	/** Operation for search added Wallet  */
	@RequestMapping(value = "/searchWallet", method = RequestMethod.GET)
	public String searchWallet(@HeaderParam("walletId") String walletId){
		return walletService.findWalletById(walletId).toString();
	}
	/** Operation for update Wallet  */
	@RequestMapping(value = "/updateWallet", method = RequestMethod.POST)
	public String updateWallet(@HeaderParam("walletId") String walletId){
		return walletService.updateWallet(walletId).toString();
	}
	private static Log _log = LogFactoryUtil.getLog(WalletController.class);
}
