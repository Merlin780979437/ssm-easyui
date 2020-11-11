package com.pinyougou.service.impl;

import javax.jws.WebService;

import com.pinyougou.service.WebserviceI;

@WebService
public class WebServiceImpl implements WebserviceI {

	@Override
	public String sayHello(String name) {
		System.out.println("前台传过来的姓名为：" + name);
		return name + "已经处理完信息，返回成功！";
	}

	@Override
	public void addHello(String name, Integer age) {
		System.out.println(name + "今年的年龄为：" + age);
	}

}
