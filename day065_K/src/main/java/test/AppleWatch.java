package test;

import org.springframework.stereotype.Component;

@Component("appleWatch")
public class AppleWatch implements Watch {
	public AppleWatch() {
		System.out.println("애플워치 객체 생성됨");
	}
	
	public void powerOn() {
		System.out.println("애플워치로 폰 전원 ON");
	}
	public void powerOff() {
		System.out.println("애플워치로 폰 전원 OFF");
	}
	public void call() {
		System.out.println("애플워치로 폰 전화");
	}
}
