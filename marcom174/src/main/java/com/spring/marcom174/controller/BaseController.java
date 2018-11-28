/**
 * 
 */
package com.spring.marcom174.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import com.spring.marcom174.model.UserModel;
import com.spring.marcom174.service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	public UserModel getUserModel() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserModel userModel =null;
		if (auth!=null) {
			User user = (User) auth.getPrincipal();
			String username = user.getUsername();
			String password = user.getPassword();
			
			
			userModel = this.userService.searchByUsernamePassword(username, password);
		}
		return userModel;
	}
}
