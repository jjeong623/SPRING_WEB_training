package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.aPointcut()")
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName=pjp.getSignature().getName();
		
		System.out.println("[BEFORE]");
		
		StopWatch sw=new StopWatch();
		sw.start();
		
		Object obj=pjp.proceed();
		// 비즈니스 메서드가 수행됨
		
		sw.stop();
		
		System.out.println("[AFTER]");
		System.out.println("비즈니스 메서드 : "+methodName);
		System.out.println("수행하는데에 걸린시간 : "+sw.getTotalTimeMillis()+"(ms)초");
		
		return obj;
	}
	
}
