package com.pinyougou.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.entity.TbContent;

public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);
    
    /**
     * 列表查询
     * @param content
     * @return
     */
    List<Map<String, Object>> findAll(TbContent content);

    /**
     * 查询总条数信息
     * @param content
     * @return
     */
	Integer count(@Param("content") TbContent content);

	/**
	 * 广告管理，分页查询
	 * @param page
	 * @param rows
	 * @param content
	 * @return
	 */
	List<Map<String, Object>> findPage(@Param("page") Integer page, @Param("rows") Integer rows,@Param("content") TbContent content);
}