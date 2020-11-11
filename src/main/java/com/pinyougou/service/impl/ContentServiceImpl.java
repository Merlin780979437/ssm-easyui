package com.pinyougou.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pinyougou.dao.TbContentMapper;
import com.pinyougou.entity.TbContent;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public List<Map<String, Object>> findAll(TbContent content) {
		
		return contentMapper.findAll(content);
	}

	@Override
	public void addContent(TbContent content) {
		contentMapper.insert(content);
		redisTemplate.boundHashOps("contentList").delete(content.getCategoryId());
	}

	@Override
	public void deleteContent(Long id) {
		//通过id查询对应的广告信息
		TbContent content = contentMapper.selectByPrimaryKey(id);
		contentMapper.deleteByPrimaryKey(id);
		redisTemplate.boundHashOps("contentList").delete(content.getCategoryId());
	}

	@Override
	public TbContent findOne(Long id) {
		return contentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateContent(TbContent content) {
		//通过广告id获得对应的广告信息
		TbContent selectByPrimaryKey = contentMapper.selectByPrimaryKey(content.getId());
		redisTemplate.boundHashOps("contentList").delete(selectByPrimaryKey.getCategoryId());
		//修改广告信息
		contentMapper.updateByPrimaryKey(content);
		
		if (content.getCategoryId().longValue() != selectByPrimaryKey.getCategoryId().longValue()) {
			redisTemplate.boundHashOps("contentList").delete(content.getCategoryId());
		}
	}

	@Override
	public PageResult findPage(Integer page, Integer rows, TbContent content) {
		
		PageResult pageResult = (PageResult) redisTemplate.boundHashOps("content").get(page);
		if (pageResult == null || "".equals(pageResult)) {
			//查询总条数
			Integer total = contentMapper.count(content);
			//查询当前页列表信息
			List<Map<String, Object>> contentList = contentMapper.findPage(page, rows, content);
			pageResult = new PageResult(total, contentList);
			
			redisTemplate.boundHashOps("content").put(page, pageResult);
		}
		
		return pageResult;
	}

}
