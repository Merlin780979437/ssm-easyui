package com.pinyougou.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.pinyougou.entity.TbItem;

@WebService
public interface ItemService {

	/**
	 * 查询所有的商品列表信息
	 * @param item
	 * @return
	 */
	@WebMethod
	public List<TbItem> findAll(TbItem item);
}
