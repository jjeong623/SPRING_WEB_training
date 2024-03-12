package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	public void printException() {
		System.out.println("        로그 03 예외 발생");
	}
}
