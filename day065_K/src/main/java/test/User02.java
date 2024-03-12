package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class User02 {
	public static void main(String[] args) {
		// 팩토리를 new
		// 팩토리를 통해 Look Up : 객체를 호출
		// 호출된 객체를 사용
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		// 스프링에서 기본제공하는 팩토리
		// 스프링 컨테이너 역할 : POJO 클래스를 new 해줄 역할
		// 설정 파일(.xml)이 필요함
		
		Phone phone=(Phone)factory.getBean("galaxy");
		// Look Up
		// applicationContext.xml 에서 설정한 이름으로 호출해야만함!
		
		phone.powerOn();
		phone.call();
		phone.powerOff();
		
		factory.close();
	}
}
