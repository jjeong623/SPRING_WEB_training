package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.spring.biz.member.MemberDTO;

@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointcutCommon.bPointcut()", returning="returnObj")
	public void afterReturningPrintLog(JoinPoint jp, Object returnObj) {
		String methodName=jp.getSignature().getName();
		System.out.println("     AfterReturning 어드바이스 : "+methodName);

		Object[] args=jp.getArgs();
		System.out.println("     비즈니스 메서드에서 사용하는 인자 : "+args[0]); // 인자가 DTO 1개일 확률이 높기때문
		for(Object arg:args) {
			System.out.println(arg);
		}

		System.out.println("     비즈니스 메서드의 OUTPUT : "+returnObj);
		
		if(returnObj instanceof MemberDTO) {
			MemberDTO mDTO=(MemberDTO)returnObj;
			if(mDTO!=null) {
				if(mDTO.getRole().equals("ADMIN")) {
					System.out.println("[관리자 로그인]");
					System.out.println(mDTO.getName()+"님 입장");
				}
				else {
					System.out.println("[사용자 로그인]");
				}
			}
		}

		System.out.println("     비즈니스 메서드 수행 후에 로그를 출력합니다.");
	}
	// 바인드 변수

}
