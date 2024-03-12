package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		String methodName=jp.getSignature().getName();
		System.out.println("     BEFORE 어드바이스 : "+methodName);
		
		Object[] args=jp.getArgs();
		System.out.println("     비즈니스 메서드에서 사용하는 인자 : "+args[0]); // 인자가 DTO 1개일 확률이 높기때문
		for(Object arg:args) {
			System.out.println(arg);
		}
		
		System.out.println("     비즈니스 메서드 수행 전에 로그를 출력합니다.");
	}

}
