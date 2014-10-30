package com.oomoque.rest.controller;

import javax.ws.rs.HeaderParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.oomoque.rest.service.OomoqueUserService;


@RestController
@RequestMapping("/oomoque-system")
public class UserController {

	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	OomoqueUserService oomoqueUserService;
	
	/** Operation for add new User  */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@HeaderParam("portalUserId") Long portalUserId,@HeaderParam("userTypeId") Long userTypeId,@HeaderParam("email") String email,@HeaderParam("Phone") String Phone){
		return oomoqueUserService.saveOomoqueUser(portalUserId, userTypeId, email, Phone);
	}
	/** Operation for delete User  */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public String deleteUser(@HeaderParam("userId") String userId){
		return oomoqueUserService.deleteOomoqueUser(userId).toString();
	}
	/** Operation for search added User  */
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public String searchUser(@HeaderParam("userId") String userId){
		return oomoqueUserService.findOomoqueUserById(userId).toString();
	}
	/** Operation for update User  */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@HeaderParam("userId") String userId,@HeaderParam("portalUserId") Long portalUserId,@HeaderParam("userTypeId") Long userTypeId,@HeaderParam("email") String email,@HeaderParam("Phone") String Phone){
		return oomoqueUserService.updateUser(userId, portalUserId, userTypeId, email, Phone);
	}
	private static Log _log = LogFactoryUtil.getLog(UserController.class);
}
