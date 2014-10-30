package com.oomoque.rest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.oomoque.rest.dao.OomoqueUserDao;
import com.oomoque.rest.model.OomoqueUser;


@Component
public class OomoqueUserService {

	@Autowired
	OomoqueUserDao oomoqueUserDao;
	
	public String saveOomoqueUser(Long portalUserId,Long userTypeId,String email,String Phone){
		  OomoqueUser oomoqueuser = new OomoqueUser();
		  StringBuilder saveOUserBuilder = new StringBuilder();
		  JSONObject JObject = JSONFactoryUtil.createJSONObject();
		  Date date = new Date(System.currentTimeMillis());
		  oomoqueuser.setPortalUserId(portalUserId);
		  /** Portal userId */
		  Long testPortalUserId = PrincipalThreadLocal.getUserId();
		  System.out.println("\n UserID from PrincipalThreadLocal :: " + testPortalUserId);
		  oomoqueuser.setUserTypeId(userTypeId);
		  oomoqueuser.setEmail(email);
		  oomoqueuser.setPhone(Phone);
		  oomoqueuser.setCreatedDate(date);
		  oomoqueuser.setModifiedDate(date);
		  oomoqueUserDao.saveOomoqueUser(oomoqueuser);
		  JObject.put("message", "success");
		  saveOUserBuilder.append(JObject);	
		  return saveOUserBuilder.toString();
	}
	public String deleteOomoqueUser(String userId){
		OomoqueUser oomoqueuser = new OomoqueUser();
		oomoqueuser.setUserId(userId);
		oomoqueUserDao.deleteOomoqueUser(oomoqueuser);
		StringBuilder deleteUserBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("message", "success");
		deleteUserBuilder.append(JObject);
		return deleteUserBuilder.toString();
	}
	public String findOomoqueUserById(String userId){
		OomoqueUser oomoqueuser = oomoqueUserDao.findOomoqueUserById(userId);
		StringBuilder searchUser = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("userId",oomoqueuser.getUserId());
		JObject.put("portalUserId",oomoqueuser.getPortalUserId());
		JObject.put("userType", oomoqueuser.getUserTypeId());
		JObject.put("email", oomoqueuser.getEmail());
		JObject.put("phone", oomoqueuser.getPhone());
		JObject.put("createdDate", oomoqueuser.getCreatedDate());
		JObject.put("modifiedDate", oomoqueuser.getModifiedDate());
		searchUser.append(JObject.toString());
		return searchUser.toString();
	}
	public String updateUser(String userId,Long portalUserId,Long userTypeId,String email,String Phone){
		OomoqueUser oomoqueuser = oomoqueUserDao.findOomoqueUserById(userId);
		StringBuilder updateUserBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		Date date = new Date(System.currentTimeMillis());
		oomoqueuser.setPortalUserId(portalUserId);
		oomoqueuser.setUserTypeId(userTypeId);
		oomoqueuser.setEmail(email);
		oomoqueuser.setPhone(Phone);
		oomoqueuser.setModifiedDate(date);
		oomoqueUserDao.saveOomoqueUser(oomoqueuser);
		JObject.put("message", "success");
		updateUserBuilder.append(JObject);
		return updateUserBuilder.toString();
	}
}
