package com.hby.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hby.pojo.User;
import com.hby.service.UserService;

@Controller
public class UserController {
	private final int PAGE_NUM = 5;
	
	@Autowired
	private UserService userService;
	
	//主页显示
	@RequestMapping("/")
	public String showIndex() {
		return "/index";
	}
	
	@RequestMapping("/queryUserById")
	public void queryUserById(Integer id,Model model) {
		User user = userService.queryUserById(id);
		model.addAttribute("user",user);
	}
	
	//显示所有用户（分页）
	@RequestMapping("/queryAllUsers")
	public String queryAllUsers(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum
			, Model model , String name) {
		if(pageNum != 0)
			PageHelper.startPage(pageNum, PAGE_NUM);
		else PageHelper.startPage(pageNum + 1 , PAGE_NUM);
		
		List<User> list;	
		if(name != null && name !="")
			list = userService.queryUserByName(name);
		else list = userService.queryAllUsers();	
		
		PageInfo<User> pageInfo = new PageInfo<>(list);
		
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("list",list);
		model.addAttribute("name",name);
		
		return "/queryAllUsers";
	}
	
	//添加用户
	@RequestMapping("/toAddUserPage")
	public String toAddUserPage() {
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/queryAllUsers";
	}
	
	//删除用户
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		userService.deleteUser(id);
		return "redirect:/queryAllUsers";
	}
	
	//修改用户
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
