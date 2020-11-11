/** 
 * <pre>项目名称:user_wd 
 * 文件名称:LogBean.java 
 * 包名:com.jk.wd.model.log 
 * 创建日期:2018年10月19日下午6:34:48 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */
package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <pre>
 * 项目名称：user_wd    
 * 类名称：LogBean    
 * 类描述：    
 * 创建人：王栋   
 * 创建时间：2018年10月19日 下午6:34:48    
 * 修改人：王栋      
 * 修改时间：2018年10月19日 下午6:34:48    
 * 修改备注：       
 * @version
 * </pre>
 */
public class LogBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5019221429238481785L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 请求用户id
	 */
	private String userId;

	/**
	 * 请求参数
	 */
	private String reqParams;

	/**
	 * 返回参数
	 */
	private String respParams;

	/**
	 * 方法名称
	 */
	private String method;

	/**
	 * 地址
	 */
	private String url;

	/**
	 * IP地址
	 */
	private String ip;

	/**
	 * 类名
	 */
	private String className;

	/**
	 * 日志记录时间
	 */
	private Date createTime;

	/**
	 * 日志记录时间
	 */
	private String staTime;
	/**
	 * 日志记录时间
	 */
	private String endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReqParams() {
		return reqParams;
	}

	public void setReqParams(String reqParams) {
		this.reqParams = reqParams;
	}

	public String getRespParams() {
		return respParams;
	}

	public void setRespParams(String respParams) {
		this.respParams = respParams;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStaTime() {
		return staTime;
	}

	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogBean other = (LogBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogBean [id=" + id + ", userId=" + userId + ", reqParams="
				+ reqParams + ", respParams=" + respParams + ", method="
				+ method + ", url=" + url + ", ip=" + ip + ", className="
				+ className + ", createTime=" + createTime + ", staTime="
				+ staTime + ", endTime=" + endTime + "]";
	}
	
}
