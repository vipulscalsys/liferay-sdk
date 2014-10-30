package com.oomoque.rest.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.oomoque.rest.dao.UserTypeDao;
import com.oomoque.rest.model.UserType;

@Component
public class UserTypeService {
	
	@Autowired 
	UserTypeDao userTypeDao;
	
	public String saveUserType(String userTypeName){
		  UserType userType = new UserType();
		  //Wallet wallet = new Wallet();
		  StringBuilder saveUserTypeBuilder = new StringBuilder();
		  JSONObject JObject = JSONFactoryUtil.createJSONObject();
		  Date date = new Date(System.currentTimeMillis());
		  userType.setUserTypeName(userTypeName);
		  userType.setCreatedDate(date);
		  userType.setModifiedDate(date);
		  userTypeDao.saveUserType(userType);
		  JObject.put("message", "success");
		  saveUserTypeBuilder.append(JObject);
		  return saveUserTypeBuilder.toString();
	}
	public String deleteUserType(String userTypeId){
		UserType userType = new UserType();
		userType.setUserTypeId(userTypeId);
		userTypeDao.deleteUserType(userType);
		StringBuilder deleteUserTypeBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("message", "success");
		deleteUserTypeBuilder.append(JObject);
		return deleteUserTypeBuilder.toString();
	}
	public String findUserTypeById(String userTypeId){
		UserType userType = userTypeDao.findUserTypeById(userTypeId);
		StringBuilder searchUserTypeBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("userTypeId",userType.getUserTypeId() );
		JObject.put("userTypeName", userType.getUserTypeName() );
		JObject.put("createdDate", userType.getCreatedDate());
		JObject.put("modifiedDate", userType.getModifiedDate());
		searchUserTypeBuilder.append(JObject.toString());
		return searchUserTypeBuilder.toString();
	}
	public String updateUserType(String userTypeId,String userTypeName){
		UserType userType = userTypeDao.findUserTypeById(userTypeId);
		Date date = new Date(System.currentTimeMillis());
		userType.setUserTypeName(userTypeName);
		userType.setModifiedDate(date);
		StringBuilder updateUserTypeBuilder = new StringBuilder();
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		JObject.put("message", "success");
		updateUserTypeBuilder.append(JObject.toString());
		return updateUserTypeBuilder.toString();
	}
	public String getUserTypeList(){
		JSONArray responseJSONARRAY = JSONFactoryUtil.createJSONArray();
		responseJSONARRAY = convertUserTypeToJArray();
		return responseJSONARRAY.toString();
	}
	private JSONArray convertUserTypeToJArray() {
		JSONArray jarray = JSONFactoryUtil.createJSONArray(); 
		List<UserType> userTypeList = (List<UserType>) userTypeDao.getUserTypeList();
		for(UserType userType:userTypeList){
			jarray.put(convertUserTypeToJObject(userType));
		}
		return jarray;
	}
	private JSONObject convertUserTypeToJObject(UserType userType){
		JSONObject JObject = JSONFactoryUtil.createJSONObject();
		if(Validator.isNull(userType)){
			JObject.put("userTypeId","Not Available");
			JObject.put("userTypeName","Not Available");
			JObject.put("createdDate", "Not Available");
			JObject.put("modifiedDate", "Not Available");
		}else{
			JObject.put("userTypeId",userType.getUserTypeId() );
			JObject.put("userTypeName", userType.getUserTypeName() );
			JObject.put("createdDate", userType.getCreatedDate());
			JObject.put("modifiedDate", userType.getModifiedDate());
		}	
		return JObject;
	}
}
