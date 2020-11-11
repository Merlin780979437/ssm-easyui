package com.pinyougou.service;

import java.util.List;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Tree;

public interface SysPermissionService {

	/**
	 * 权限列表查询
	 * @param sysPermission
	 * @return
	 */
	public List<SysPermission> findAll(SysPermission sysPermission);
	
	/**
	 * 新增权限
	 * @param sysPermission
	 */
	public void addPermission(SysPermission sysPermission);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deletePermission(Long id);
	
	/**
	 * 回显权限
	 * @param id
	 * @return
	 */
	public SysPermission findOne(Long id);
	
	/**
	 * 
	 * @param sysPermission
	 */
	public void updatePermission(SysPermission sysPermission);
	
	/**
	 * 权限列表，分页查询
	 * @param page
	 * @param rows
	 * @param sysPermission
	 * @return
	 */
	public PageResult findPage(Integer page, Integer rows, SysPermission sysPermission);

	/**
	 * 获得权限列表树形展示
	 * @param id
	 * @return
	 */
	public List<Tree> initTree(Long id, String roleId);

	/**
	 * 角色分配权限保存
	 * @param roleId
	 * @param ids
	 */
	public void addRoleAndPermission(String roleId, String ids);
	
}
