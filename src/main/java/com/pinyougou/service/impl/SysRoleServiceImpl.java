package com.pinyougou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.dao.SysRoleMapper;
import com.pinyougou.entity.SysRole;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> findAll(SysRole sysRole) {
		return sysRoleMapper.findAll(sysRole);
	}

	@Override
	public void addRole(SysRole sysRole) {
		sysRoleMapper.insert(sysRole);
	}

	@Override
	public void deleteRole(String id) {
		sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysRole findOne(String id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(SysRole sysRole) {
		sysRoleMapper.updateByPrimaryKey(sysRole);
	}

	@Override
	public PageResult findPage(Integer page, Integer rows, SysRole sysRole) {
		Integer total = sysRoleMapper.count(sysRole);
		List<SysRole> findPage = sysRoleMapper.findPage(page, rows, sysRole);
		return new PageResult(total, findPage);
	}

}
