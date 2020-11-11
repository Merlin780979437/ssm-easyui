package com.pinyougou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.dao.TbUserMapper;
import com.pinyougou.entity.TbUser;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private TbUserMapper userMapper;

	@Override
	public List<TbUser> userList(TbUser user) {
		return userMapper.userList(user);
	}

	@Override
	public void addUser(TbUser user) {
		userMapper.insert(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TbUser findOne(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(TbUser user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public PageResult findPage(Integer page, Integer rows, TbUser user, String startDate, String endDate) {
		
		//1、获得总条数
		Integer total = userMapper.count(user, startDate, endDate);
		//2、获得当前页展示的数据
		List<TbUser> findPage = userMapper.findPage(page, rows, user, startDate, endDate);
		
		return new PageResult(total, findPage);
	}

}
