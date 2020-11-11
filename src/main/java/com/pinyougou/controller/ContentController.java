package com.pinyougou.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.entity.TbContent;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/findAll")
	public List<Map<String, Object>> findAll(TbContent content) {
		return contentService.findAll(content);
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue = "1")Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows, TbContent content) {
		return contentService.findPage(page, rows, content);
	}
	
	@RequestMapping("/addContent")
	public Result addContent(TbContent content) {
		try {
			contentService.addContent(content);
			return new Result(true, "添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败！");
		}
	}

}
