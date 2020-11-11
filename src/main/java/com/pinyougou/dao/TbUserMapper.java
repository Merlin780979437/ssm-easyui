package com.pinyougou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.entity.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    /**
     * 用户列表查询
     * @param user
     * @return
     */
    List<TbUser> userList(TbUser user);

    /**
     * 查询总条数
     * @param user
     * @return
     */
	Integer count(@Param("user") TbUser user, @Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 用户列表，分页查询数据
	 * @param page
	 * @param rows
	 * @param user
	 * @return
	 */
	List<TbUser> findPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("user") TbUser user, @Param("startDate") String startDate, @Param("endDate") String endDate);
}