package com.pinyougou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.pojo.Tree;
import com.pinyougou.service.SysPermissionService;

@RestController
@RequestMapping("/sysPermission")
public class SysPermissionController {

	@Autowired
	private SysPermissionService sysPermissionService;
	
	@RequestMapping("/findAll")
	public List<SysPermission> findAll(SysPermission sysPermission) {
		return sysPermissionService.findAll(sysPermission);
	}
	
	@RequestMapping("/addPermission")
	public Result addPermission(SysPermission sysPermission) {
		try {
			sysPermissionService.addPermission(sysPermission);
			return new Result(true, "添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败！");
		}
	}
	
	@RequestMapping("/deletePermission")
	public Result deletePermission(Long id) {
		try {
			sysPermissionService.deletePermission(id);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public SysPermission findOne(Long id) {
		return sysPermissionService.findOne(id);
	}
	
	@RequestMapping("/updatePermission")
	public Result updatePermission(SysPermission sysPermission) {
		try {
			sysPermissionService.updatePermission(sysPermission);
			return new Result(true, "修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败！");
		}
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, SysPermission sysPermission) {
		return sysPermissionService.findPage(page, rows, sysPermission);
	}
	
	@RequestMapping("/initTree")
	public List<Tree> initTree(Long id, String roleId) {
		if (id == null) {
			id = 0L;
		}
		List<Tree> treeList = sysPermissionService.initTree(id, roleId);
		
		return treeList;
	}
	
	@RequestMapping("/addRoleAndPermission")
	public Result addRoleAndPermission(String roleId, String ids) {
		try {
			sysPermissionService.addRoleAndPermission(roleId, ids);
			return new Result(true, "角色分配权限成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "角色分配权限失败！");
		}
	}
}
