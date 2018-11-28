package com.spring.marcom174.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.marcom174.model.MenuModel;
import com.spring.marcom174.service.MenuService;

@Controller
public class LoginController extends BaseController{
	

	@Autowired
	private MenuService menuService;
	
	public void aksesLogin(Model model) {
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		Integer idRole = this.getUserModel().getIdRole();
		menuModelList = this.menuService.searchByRole(idRole);
		
		model.addAttribute("menuModelList", menuModelList);
		model.addAttribute("username", this.getUserModel().getUsername());
		model.addAttribute("password", this.getUserModel().getPassword());
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout",required=false) String logout){
		ModelAndView model = new ModelAndView();
		if(error != null){
			model.addObject("error","Invalid username and password");
		}
		if(logout != null){
			model.addObject("msg","You are have logged out successfully");
		}
		return model;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session){
		this.aksesLogin(model);
		return new ModelAndView("/index");
	}
	
	
	
	@RequestMapping(value="/j_spring_security_logout", method=RequestMethod.GET)
	public ModelAndView logout(Model model, HttpSession session){
	
		return new ModelAndView("/login");
	}


	
	
	
	@RequestMapping(value="/direct-outlet", method=RequestMethod.POST)
	public String directOutlet(HttpServletRequest request, HttpSession session){
		
		int outletId = Integer.parseInt(request.getParameter("outletId"));
		session.setAttribute("outletId", outletId);
		return "/index";
	}
	
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public ModelAndView AccessDenied(){
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)){
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		return model;
	}
}
