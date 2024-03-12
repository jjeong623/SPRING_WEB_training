package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //new
public class AfterReturningAdvice {
	
	//반환이 있는 애들이랑 연결해주기
	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))") // 포인트컷 설정
	public void bPointcut() {}
	
	@AfterReturning(pointcut="bPointcut()", returning="returnObj")
	//포인트컷(핵심관심)이 수행해서 반환한 returnObj 를 담아줄거야
	public void afterReturningPrintLog(JoinPoint jp, Object returnObj) {
		System.out.println("        로그 02 비즈니스 메서드 수행 후에 로그를 출력합니다.");
	
	
	
	
	}
	//returning="returnObj -> 바인드변수
	//동적바인딩 >> 오버라이딩 
}







