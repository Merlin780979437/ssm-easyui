package com.pinyougou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    /**
     * 角色列表查询
     * @param sysRole
     * @return
     */
    List<SysRole> findAll(SysRole sysRole);

    /**
     * 统计总条数
     * @param sysRole
     * @return
     */
	Integer count(@Param("sysRole") SysRole sysRole);

	/**
	 * 统计总条数
	 * @param page
	 * @param rows
	 * @param sysRole
	 * @return
	 */
	List<SysRole> findPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("sysRole") SysRole sysRole);
}