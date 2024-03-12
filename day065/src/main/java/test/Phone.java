package test;

public interface Phone {
	// 인터페이스
	// == 아, 메서드 오버라이딩 강제하려는거구나!
	// == 메서드 시그니쳐를 맞춰야하는 상황인가보다~
	// "다형성"을 코드에 적용한 사례
	
	public void powerOn();
	public void powerOff();
	public void call();

}
