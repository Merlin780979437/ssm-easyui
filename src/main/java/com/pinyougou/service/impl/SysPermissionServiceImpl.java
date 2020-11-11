package com.pinyougou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pinyougou.dao.SysPermissionMapper;
import com.pinyougou.entity.SysPermission;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Tree;
import com.pinyougou.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionMapper sysPermissinMapper;
	
	@Override
	public List<SysPermission> findAll(SysPermission sysPermission) {
		return sysPermissinMapper.findAll(sysPermission);
	}

	@Override
	public void addPermission(SysPermission sysPermission) {
		sysPermissinMapper.insert(sysPermission);
	}

	@Override
	public void deletePermission(Long id) {
		sysPermissinMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysPermission findOne(Long id) {
		return sysPermissinMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updatePermission(SysPermission sysPermission) {
		sysPermissinMapper.updateByPrimaryKey(sysPermission);
	}

	@Override
	public PageResult findPage(Integer page, Integer rows,
			SysPermission sysPermission) {
		Integer total = sysPermissinMapper.count(sysPermission);
		sysPermissinMapper.findPage(page, rows, sysPermission);
		return null;
	}

	@Override
	public List<Tree> initTree(Long id, String roleId) {
		//1、获得当前id对应的子节点数量
		List<SysPermission> permissionList = sysPermissinMapper.findPermissionByPranetId(id);
		
		//2、通过角色id获得对应的权限id集合
		List<Map<String, Object>> roleAndPermissionList = sysPermissinMapper.findPermissionIdByRoleId(roleId);
		
		
		List<Tree> treeList = new ArrayList<Tree>();
		Tree tree = null;
		for (SysPermission sysPermission : permissionList) {
			tree = new Tree();
			tree.setId(sysPermission.getId());
			tree.setText(sysPermission.getName());
			//tree.setIconCls();
			tree.setUrl(sysPermission.getUrl());
			
			//判断当前节点是否有子节点
			if (isExsisChildrenNodes(sysPermission)) {
				//tree.setState("close");
				List<Tree> treeList1 = findChildrenListNodes(sysPermission, roleAndPermissionList);
				tree.setChildren(treeList1);
			}
			
			//判断当前用户是否拥有权限
			for (Map<String, Object> map : roleAndPermissionList) {
				Long permissionId = null;
				if (map.get("sys_permission_id") != null) {
					permissionId = Long.valueOf(map.get("sys_permission_id").toString());
				}
				if (sysPermission.getId() == permissionId) {
					tree.setChecked("true");
				}
			}
			
			
			treeList.add(tree);
			
		}
		
		
		return treeList;
	}
	
	
	/**
	 * 通过当前节点获得对应的子节点信息
	 * @param sysPermission
	 * @return
	 */
	private List<Tree> findChildrenListNodes(SysPermission sysPermission, List<Map<String, Object>> roleAndPermissionList) {
		List<SysPermission> findPermissionByPranetId = sysPermissinMapper.findPermissionByPranetId(sysPermission.getId());
		List<Tree> childrenList = new ArrayList<Tree>();
		Tree tree = null;
		for (SysPermission sysPermission2 : findPermissionByPranetId) {
			tree = new Tree();
			tree.setId(sysPermission2.getId());
			tree.setText(sysPermission2.getName());
			tree.setUrl(sysPermission2.getUrl());
			if (isExsisChildrenNodes(sysPermission2)) {
				List<Tree> treeList1 = findChildrenListNodes(sysPermission2, roleAndPermissionList);
				tree.setChildren(treeList1);
			}
			
			//判断当前用户是否拥有权限
			for (Map<String, Object> map : roleAndPermissionList) {
				Long permissionId = null;
				if (map.get("sys_permission_id") != null) {
					permissionId = Long.valueOf(map.get("sys_permission_id").toString());
				}
				if (sysPermission.getId() == permissionId) {
					tree.setChecked("true");
				}
			}
			childrenList.add(tree);
		}
		return childrenList;
	}

	/**
	 * 判断当前节点是否存在子节点
	 * @param sysPermission
	 * @return
	 */
	private boolean isExsisChildrenNodes(SysPermission sysPermission) {
		boolean flag = true;
		List<SysPermission> findPermissionByPranetId = sysPermissinMapper.findPermissionByPranetId(sysPermission.getId());
		if(CollectionUtils.isEmpty(findPermissionByPranetId)) {
			flag = false;
		}
		return flag;
	}

	@Override
	public void addRoleAndPermission(String roleId, String ids) {
		//1、通过角色id删除角色原有的权限集合id
		sysPermissinMapper.deletePermissionIdByRoleId(roleId);
		
		//2、添加角色新增的权限id集合
		String[] split = ids.split(",");
		Map<String, Object> params = null;
		for (int i = 0; i < split.length; i++) {
			params = new HashMap<String, Object>();
			params.put("id", UUID.randomUUID().toString());
			params.put("roleId", roleId);
			params.put("permissionId", split[i].trim());
			sysPermissinMapper.addRoleAndPermission(params);
		}
	}

}
