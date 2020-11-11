package com.pinyougou.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebserviceI {

	@WebMethod
	public String sayHello(String name);
	
	@WebMethod
	public void addHello(String name, Integer age);
	
}
