package test;

public class User { // Client(브라우저)

	public static void main(String[] args) {
		
		BeanFactory beanFactory=new BeanFactory();
		
		Phone phone = (Phone)beanFactory.getBean(args[0]); // Look Up
		phone.powerOn();
		phone.call();
		phone.powerOff();
		
		// [결론]
		// 유사한 서비스를 제공하는 객체들끼리는
		// 메서드 시그니쳐를 맞춰줄 필요가 있다!
		// -> 메서드 시그니쳐를 강제
		// -> 인터페이스 설계가 필요!
		// => "다형성"을 실현하여 코드에 적용한 대표적인 사례!!!
		//    : 똑같은 메서드를 호출했어도,
		//      메서드를 수행하는 주체(주어,대상)에 따라
		//      다른 결과(output)가 나오는 현상
		
		Phone phone2 = (Phone)beanFactory.getBean(args[1]);
		phone2.powerOn();
		phone2.call();
		phone2.powerOff();
		
	}

}
