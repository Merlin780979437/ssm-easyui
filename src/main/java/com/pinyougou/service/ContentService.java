package com.pinyougou.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.entity.TbContent;
import com.pinyougou.pojo.PageResult;

public interface ContentService {

	/**
	 * 广告列表查询
	 * @param content
	 * @return
	 */
	public List<Map<String, Object>> findAll(TbContent content);
	
	/**
	 * 广告新增
	 * @param content
	 */
	public void addContent(TbContent content);
	
	/**
	 * 删除广告
	 * @param id
	 */
	public void deleteContent(Long id);
	
	/**
	 * 回显广告
	 * @param id
	 * @return
	 */
	public TbContent findOne(Long id);
	
	/**
	 * 修改保存
	 * @param content
	 */
	public void updateContent(TbContent content);
	
	/**
	 * 广告管理，分页查询
	 * @param page
	 * @param rows
	 * @param content
	 * @return
	 */
	public PageResult findPage(Integer page, Integer rows, TbContent content);
}
