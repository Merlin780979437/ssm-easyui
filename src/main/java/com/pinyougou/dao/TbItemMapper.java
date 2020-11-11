package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.entity.TbItem;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
    
    /**
     * 查询所有的商品信息
     * @param item
     * @return
     */
    public List<TbItem> findAll(TbItem item);
}