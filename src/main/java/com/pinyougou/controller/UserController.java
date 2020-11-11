package com.pinyougou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.TbUser;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/userList")
	public List<TbUser> userList(TbUser user) {
		return userService.userList(user);
	}
	
	@RequestMapping("/addUser")
	public Result addUser(TbUser user) {
		try {
			userService.addUser(user);
			return new Result(true, "添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败！");
		}
	}
	
	@RequestMapping("/deleteUser")
	public Result deleteUser(Integer id) {
		try {
			userService.deleteUser(id);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public TbUser findOne(Integer id) {
		return userService.findOne(id);
	}
	
	@RequestMapping("/updateUser")
	public Result updateUser(TbUser user) {
		try {
			userService.updateUser(user);
			return new Result(true, "修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败！");
		}
		
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue = "1")Integer page, @RequestParam(value = "rows", defaultValue = "10")Integer rows, TbUser user, String startDate, String endDate) {
		return userService.findPage(page, rows, user, startDate, endDate);
	}
	
	@RequestMapping(value = "/sayHi", produces = "text/html;charset=UTF-8")
	public String sayHi() {
		return "添加成功";
	}
}
