package com.pinyougou.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.dao.TbItemMapper;
import com.pinyougou.entity.TbItem;
import com.pinyougou.service.ItemService;
@WebService
@Service("itemService")   //<bean id="itemService" class="com.pinyougou.service.impl.ItemServiceImple"></bean>
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public List<TbItem> findAll(TbItem item) {
		return itemMapper.findAll(item);
	}

}
