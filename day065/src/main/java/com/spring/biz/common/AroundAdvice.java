package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable{ //throws Throwable 예외처리 미룸
		
		String methodName = pjp.getSignature().getName();
		
		System.out.println("[BEFORE]");
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = pjp.proceed(); 
			//Object 사용 이유? 반환 타입을 알지 못하기 때문
			//pjp를 탈취해서 전 후로 작업을 하는?느낌
			//18번 라인을 통해서 비즈니스 메서드가 수행됨
		sw.stop();
		
		System.out.println("[AFTER]");
		System.out.println("비즈니스 메서드 : " + methodName);
		System.out.println("수행하는데에 걸린 시간 : "+ sw.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	
	}
	
	
}
