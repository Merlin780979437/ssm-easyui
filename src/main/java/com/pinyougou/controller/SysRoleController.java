package com.pinyougou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.SysRole;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.service.SysRoleService;

@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/findAll")
	public List<SysRole> findAll(SysRole sysRole) {
		return sysRoleService.findAll(sysRole);
	}
	
	@RequestMapping("/addRole")
	public Result addRole(SysRole sysRole) {
		try {
			sysRoleService.addRole(sysRole);
			return new Result(true, "添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败！");
		}
	}
	
	@RequestMapping("/deleteRole")
	public Result deleteRole(String id) {
		try {
			sysRoleService.deleteRole(id);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public SysRole findOne(String id) {
		return sysRoleService.findOne(id);
	}
	
	@RequestMapping("/updateRole")
	public Result updateRole(SysRole sysRole) {
		try {
			sysRoleService.updateRole(sysRole);
			return new Result(true, "修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败！");
		}
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, SysRole sysRole) {
		return sysRoleService.findPage(page, rows, sysRole);
	}
}
