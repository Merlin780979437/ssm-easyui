package com.pinyougou.service;

import java.util.List;

import com.pinyougou.entity.SysRole;
import com.pinyougou.pojo.PageResult;

public interface SysRoleService {

	/**
	 * 角色列表查询
	 * @param sysRole
	 * @return
	 */
	public List<SysRole> findAll(SysRole sysRole);
	
	/**
	 * 新增角色信息
	 * @param sysRole
	 */
	public void addRole(SysRole sysRole);
	
	/**
	 * 删除角色信息
	 * @param sysRole
	 */
	public void deleteRole(String id);
	
	/**
	 * 修改回显角色
	 * @param id
	 * @return
	 */
	public SysRole findOne(String id);
	
	/**
	 * 修改保存角色
	 * @param sysRole
	 */
	public void updateRole(SysRole sysRole);
	
	/**
	 * 角色列表，分页查询
	 * @param page
	 * @param rows
	 * @param sysRole
	 * @return
	 */
	public PageResult findPage(Integer page, Integer rows, SysRole sysRole);
}
