package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // 컴포넌트로 적어도 되지만 같이 관리하기 위해 service로 작성하는게 유리하다
//로그 어드바이스는 보드 서비스와 위빙 처리를 할거라서 
@Aspect // aspect처리 해줄래(연결시켜줄래)
public class LogAdvice {
//누구랑 연결되어야 하는지 알고있어야 함->어떤 포인트컷인지 --> 아래에 포인트컷 작성
	
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))") // 포인트컷 설정
	public void aPointcut() {}
	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))") // 포인트컷 설정
	public void bPointcut() {}
	
	
	@Before("aPointcut()")
	public void printLog(JoinPoint jp) { // 인자로 jp를 받을 수 있다
		String methodName = jp.getSignature().getName();
		System.out.println("        BEFORE 어드바이스 : " + methodName);
		
		Object[] args = jp.getArgs();//인자확인가능
		System.out.println("     비즈니스 메서드에서 사용하는 인자 : " + args[0]); // 인자가 DTO 1개일 확률이 높기때문에
		for(Object arg:args) {
			System.out.println(arg);
		}
		
		
		System.out.println("        로그 01 비즈니스 메서드 수행 전에 로그를 출력합니다.");
		}
}
