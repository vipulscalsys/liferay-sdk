package com.oomoque.rest.controller;

import javax.ws.rs.HeaderParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.oomoque.rest.service.UserTypeService;

@RestController
@RequestMapping("/oomoque-system")
public class UserTypeController {

	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	UserTypeService userTypeService;
	
	/** Operation for add new UserType  */
	@RequestMapping(value = "/saveUserType", method = RequestMethod.POST)
	public String saveUserType(@HeaderParam("userTypeName") String userTypeName){
		  return userTypeService.saveUserType(userTypeName);
	}
	/** Operation for delete UserType  */
	@RequestMapping(value = "/deleteUserType", method = RequestMethod.DELETE)
	public String deleteUserType(@HeaderParam("userTypeId") String userTypeId){
		return userTypeService.deleteUserType(userTypeId);
	}
	/** Operation for search added UserType  */
	@RequestMapping(value = "/searchUserType", method = RequestMethod.GET)
	public String searchUserType(@HeaderParam("userTypeId") String userTypeId){
		return userTypeService.findUserTypeById(userTypeId);
	}
	/** Operation for update UserType  */
	@RequestMapping(value = "/updateUserType", method = RequestMethod.POST)
	public String updateUserType(@HeaderParam("userTypeId") String userTypeId,@HeaderParam("userTypeName") String userTypeName){
		return userTypeService.updateUserType(userTypeId, userTypeName);
	}
	/** Operation for Retrive UserType List  */
	@RequestMapping(value = "/userTypeList", method = RequestMethod.GET)
	public String userTypeList(){
		return userTypeService.getUserTypeList().toString();
	}
	private static Log _log = LogFactoryUtil.getLog(UserTypeController.class);	
}
