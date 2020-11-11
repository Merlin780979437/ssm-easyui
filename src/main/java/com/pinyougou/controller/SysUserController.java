package com.pinyougou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.SysUser;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.service.SysUserService;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/findAll")
	public List<SysUser> findAll(SysUser sysUser) {
		return sysUserService.findAll(sysUser);
	}
	
	@RequestMapping("/addUser")
	public Result addUser(SysUser sysUser) {
		try {
			sysUserService.addUser(sysUser);
			return new Result(true, "新增成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "新增失败！");
		}
	}
	
	@RequestMapping("/deleteUser")
	public Result deleteUser(String id) {
		try {
			sysUserService.deleteUser(id);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public SysUser findOne(String id) {
		return sysUserService.findOne(id);
	}
	
	@RequestMapping("/updateUser")
	public Result updateUser(SysUser sysUser) {
		try {
			sysUserService.updateUser(sysUser);
			return new Result(true, "修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败！");
		}
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, SysUser sysUser) {
		return sysUserService.findPage(page, rows, sysUser);
	}
	
	@RequestMapping("/userAndRole")
	public Result userAndRole(String userId, String ids) {
		try {
			sysUserService.userAndRole(userId, ids);
			return new Result(true, "分配成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "分配失败！");
		}
	}
}
