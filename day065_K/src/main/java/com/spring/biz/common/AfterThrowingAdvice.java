package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()", throwing="exceptObj")
	public void printException(JoinPoint jp, Object exceptObj) {
		String methodName=jp.getSignature().getName();
		System.out.println("     AfterThrowing 어드바이스 : "+methodName);

		Object[] args=jp.getArgs();
		System.out.println("     비즈니스 메서드에서 사용하는 인자 : "+args[0]); // 인자가 DTO 1개일 확률이 높기때문
		for(Object arg:args) {
			System.out.println(arg);
		}

		if(exceptObj instanceof NumberFormatException) {
			System.out.println("값이 숫자가 아닙니다.");
		}
		else if(exceptObj instanceof ArithmeticException) {
			System.out.println("수학적인 오류입니다.");
			System.out.println("일부러 발생시킨 에러입니다.");
		}
		else {
			System.out.println("미확인 에러입니다.");
		}

		System.out.println("     비즈니스 메서드 수행에 예외가 발생했습니다.");
	}
	
}
