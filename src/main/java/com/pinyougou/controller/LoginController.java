package com.pinyougou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.entity.SysUser;
import com.pinyougou.pojo.Result;
import com.pinyougou.service.SysUserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/login")
	public Result login(SysUser sysUser, HttpServletRequest request) {
		SysUser user = sysUserService.login(sysUser);
		if (user != null && !"".equals(user)) {
			//判断密码是否存在
			if (sysUser.getPassword().equals(user.getPassword())) {
				//将当前用户拥有的权限集合放入session中
				List<SysPermission> permissionList = sysUserService.findPermissionByUserId(user);
				user.setPermissionList(permissionList);
				//获得当前用户拥有的所有菜单集合
				
				
				//将用户信息放入到session中
				request.getSession().setAttribute("sysUser", user);
				//登录成功
				return new Result(true, "登录成功！");
			} else {
				return new Result(false,"密码错误！");
			}
		} else {
			return new Result(false, "账号不存在！");
		}
	}
}
