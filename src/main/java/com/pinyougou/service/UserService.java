package com.pinyougou.service;

import java.util.List;

import com.pinyougou.entity.TbUser;
import com.pinyougou.pojo.PageResult;

public interface UserService {

	/**
	 * 用户列表查询
	 * @param user
	 * @return
	 */
	public List<TbUser> userList(TbUser user);
	
	
	/**
	 * 新增
	 * @param user
	 */
	public void addUser(TbUser user);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteUser(Integer id);
	
	/**
	 * 回显
	 * @param id
	 * @return
	 */
	public TbUser findOne(Integer id);
	
	/**
	 * 修改保存
	 * @param user
	 */
	public void updateUser(TbUser user);
	
	
	/**
	 * 用户分页查询
	 * @param page
	 * @param rows
	 * @param user
	 * @return
	 */
	public PageResult findPage(Integer page, Integer rows, TbUser user, String startDate, String endDate);
	
}
