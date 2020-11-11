package com.pinyougou.service;

import java.util.List;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.entity.SysUser;
import com.pinyougou.pojo.PageResult;

public interface SysUserService {

	/**
	 * 用户列表查询
	 * @param sysUser
	 * @return
	 */
	public List<SysUser> findAll(SysUser sysUser);
	
	/**
	 * 新增用户信息
	 * @param sysUser
	 */
	public void addUser(SysUser sysUser);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	public void deleteUser(String id);
	
	/**
	 * 修改用户回显
	 * @param id
	 * @return
	 */
	public SysUser findOne(String id);
	
	/**
	 * 修改用户保存
	 * @param sysUser
	 */
	public void updateUser(SysUser sysUser);
	
	/**
	 * 用户列表，分页查询
	 * @param page
	 * @param rows
	 * @param sysUser
	 * @return
	 */
	public PageResult findPage(Integer page, Integer rows, SysUser sysUser);

	/**
	 * 用户分配角色
	 * @param userId
	 * @param ids
	 */
	public void userAndRole(String userId, String ids);

	/**
	 * 通过用户名获得对应的用户信息
	 * @param sysUser
	 * @return
	 */
	public SysUser login(SysUser sysUser);

	/**
	 * 通过用户id获得用户拥有的所有权限集合
	 * @param user
	 * @return
	 */
	public List<SysPermission> findPermissionByUserId(SysUser user);
}
