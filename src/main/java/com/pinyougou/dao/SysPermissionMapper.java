package com.pinyougou.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.entity.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    /**
     * 权限列表查询
     * @param sysPermission
     * @return
     */
	List<SysPermission> findAll(SysPermission sysPermission);

	/**
	 * 权限总条数
	 * @param sysPermission
	 * @return
	 */
	Integer count(@Param("sysPermission") SysPermission sysPermission);

	/**
	 * 权限列表，分页查询
	 * @param page
	 * @param rows
	 * @param sysPermission
	 */
	void findPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("sysPermission") SysPermission sysPermission);

	/**
	 * 通过id获得对应的子节点信息
	 * @param id
	 * @return
	 */
	List<SysPermission> findPermissionByPranetId(Long id);

	/**
	 * 通过角色id获得对应的角色权限关联信息
	 * @param roleId
	 * @return
	 */
	List<Map<String, Object>> findPermissionIdByRoleId(String roleId);

	/**
	 * 通过角色id删除角色权限关联信息
	 * @param roleId
	 */
	void deletePermissionIdByRoleId(String roleId);

	/**
	 * 添加角色对应的角色权限关联信息
	 * @param params
	 */
	void addRoleAndPermission(Map<String, Object> params);
    
}