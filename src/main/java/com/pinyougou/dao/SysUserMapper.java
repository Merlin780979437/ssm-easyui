package com.pinyougou.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    /**
     * 用户列表查询
     * @param sysUser
     * @return
     */
    List<SysUser> findAll(SysUser sysUser);

    /**
     * 统计总条数
     * @param sysUser
     * @return
     */
	Integer count(@Param("sysUser") SysUser sysUser);

	/**
	 * 用户列表，分页查询
	 * @param page
	 * @param rows
	 * @param sysUser
	 * @return
	 */
	List<SysUser> findPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("sysUser") SysUser sysUser);

	/**
	 * 通过用户id删除用户原有的角色关联信息
	 * @param userId
	 */
	void deleteUserAndRole(String userId);

	/**
	 * 添加用户和角色关联信息
	 * @param params
	 */
	void addUserAndRole(Map<String, Object> params);

	/**
	 * 通过用户名获得对应的用户信息集合
	 * @param sysUser
	 * @return
	 */
	List<SysUser> findSysUserByUsercode(SysUser sysUser);

	/**
	 * 通过用户id获得用户拥有的所有权限集合
	 * @param user
	 * @return
	 */
	List<SysPermission> findPermissionByUserId(SysUser user);
	
}