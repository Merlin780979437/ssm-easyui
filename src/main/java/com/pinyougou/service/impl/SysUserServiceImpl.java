package com.pinyougou.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pinyougou.dao.SysUserMapper;
import com.pinyougou.entity.SysPermission;
import com.pinyougou.entity.SysUser;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<SysUser> findAll(SysUser sysUser) {
		return sysUserMapper.findAll(sysUser);
	}

	@Override
	public void addUser(SysUser sysUser) {
		sysUserMapper.insert(sysUser);
	}

	@Override
	public void deleteUser(String id) {
		sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysUser findOne(String id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(SysUser sysUser) {
		sysUserMapper.updateByPrimaryKey(sysUser);
	}

	@Override
	public PageResult findPage(Integer page, Integer rows, SysUser sysUser) {
		Integer total = sysUserMapper.count(sysUser);
		List<SysUser> findPage = sysUserMapper.findPage(page, rows, sysUser);
		return new PageResult(total, findPage);
	}

	@Override
	public void userAndRole(String userId, String ids) {
		//1、删除李四原有的角色关联
		sysUserMapper.deleteUserAndRole(userId);
		//2、新增李四新的角色关联
		String[] split = ids.split(",");
		Map<String, Object> params = null;
		for (int i = 0; i < split.length; i++) {
			params = new HashMap<String, Object>();
			params.put("id", UUID.randomUUID().toString());
			params.put("userId", userId);
			params.put("roleId", split[i]);
			sysUserMapper.addUserAndRole(params);
		}
		
		
		
	}

	@Override
	public SysUser login(SysUser sysUser) {
		//通过用户名获得对应的用户信息集合
		List<SysUser> sysUserList = sysUserMapper.findSysUserByUsercode(sysUser);
		if (CollectionUtils.isEmpty(sysUserList)) {
			return null;
		} else {
			return sysUserList.get(0);
		}
	}

	@Override
	public List<SysPermission> findPermissionByUserId(SysUser user) {
		
		return sysUserMapper.findPermissionByUserId(user);
	}

}
