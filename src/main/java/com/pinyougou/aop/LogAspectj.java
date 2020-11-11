package com.pinyougou.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pinyougou.entity.SysUser;
import com.pinyougou.pojo.LogBean;
import com.pinyougou.util.IPUtil;

@Aspect
@Component
public class LogAspectj {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Pointcut("execution(* com.pinyougou.service..*Impl.*(..))")
	public void logPointCut(){
		
	}
	
	@AfterReturning(value = "logPointCut()", argNames = "rtv", returning = "rtv")
	public void saveLog(JoinPoint joinPoint, Object rtv) {
		
		System.out.println("进入后置通知方法");
		//判断是否有参数
		if (joinPoint.getArgs() == null) {
			return;
		}
		//拼接对象
		LogBean logBean = new LogBean();
		logBean.setCreateTime(new Date());
		//获得类名
		String simpleName = joinPoint.getTarget().getClass().getSimpleName();
		logBean.setClassName(simpleName);
		
		//获取方法名
		String name = joinPoint.getSignature().getName();
		logBean.setMethod(name);
		
		StringBuffer stringBuffer = new StringBuffer();
		Object[] args = joinPoint.getArgs();
		
		for (int i = 0; i < args.length; i++) {
			String str = args[i] == null ? "": args[i].toString();
			stringBuffer.append("参数【").append(i).append(str).append("】");
		}
		logBean.setReqParams(stringBuffer.toString());
		
		//返回参数
		if (rtv != null) {
			logBean.setRespParams(rtv.toString());
		}
		
		//spring aop输出日志中获取request的post参数
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
		if (sra != null) {
			HttpServletRequest request = sra.getRequest();
			String url = request.getRequestURI().toString();
			logBean.setUrl(url);
			SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
			if (sysUser != null) {
				logBean.setUserId(sysUser.getUsername());
			}
			logBean.setIp(IPUtil.getIp(request));
		}
		mongoTemplate.save(logBean);
		
	}
	
}
