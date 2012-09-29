package com.flybyu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flybyu.web.model.User;
import com.flybyu.web.model.UserRelation;
import com.flybyu.web.model.UserRelationsDAO;
import com.flybyu.web.model.UsersDAO;

@Controller
public class UserRelationController {
	@Autowired
    private UsersDAO usersDAO;
	
	@Autowired
	private UserRelationsDAO userRelationsDAO;
	
	@RequestMapping(value="/follow/{followId}")
	@ResponseBody
	public Object follow(@PathVariable Long followId) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication auth = securityContext.getAuthentication();
		Object principal = auth.getPrincipal();
		
		String userName = "";
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		
		// get the user_id according to userName;
		User user = usersDAO.getByUsername(userName);
		
		if (user != null) {
			UserRelation userRelation = new UserRelation();
			userRelation.setUserId(user.getId());
			userRelation.setFollowId(followId.intValue());
			userRelation.setRelation(0);
			
			UserRelation fanUserRelation = new UserRelation();
			fanUserRelation.setUserId(followId.intValue());
			fanUserRelation.setFollowId(user.getId());
			fanUserRelation.setRelation(1);
			
			// TODO: Transaction
			{
				userRelationsDAO.save(userRelation);
				userRelationsDAO.save(fanUserRelation);
			}
			
			
			return "true";
		}
		
		return "false";
	}

}
