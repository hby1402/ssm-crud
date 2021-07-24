package com.hby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hby.pojo.User;
import com.hby.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String showIndex() {
		return "/index";
	}
	
	@RequestMapping("/queryUserById")
	public void queryUserById(Integer id,Model model) {
		User user = userService.queryUserById(id);
		model.addAttribute("user",user);
	}
	
	@RequestMapping("/queryUserByName")
	public String queryUserByName(String name,Model model) {
		List<User> list = userService.queryUserByName(name);
		model.addAttribute("list",list);
		return "/queryUserByName";
	}
	
	@RequestMapping("/queryAllUsers")
	public String queryAllUsers(Model model) {
		List<User> list = userService.queryAllUsers();
		model.addAttribute("list",list);
		return "/queryAllUsers";
	}
	
	
	@RequestMapping("/toAddUserPage")
	public String toAddUserPage() {
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/queryAllUsers";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		userService.deleteUser(id);
		return "redirect:/queryAllUsers";
	}
	
	@RequestMapping("/toUpdateUserPage")
	public String toUpdateUserPage(Integer id,Model model) {
		User user = userService.queryUserById(id);
		model.addAttribute("user",user);
		return "updateUser";
	}
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/queryAllUsers";
	}
	
}