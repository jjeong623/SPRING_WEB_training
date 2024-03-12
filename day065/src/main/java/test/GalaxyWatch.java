package test;

import org.springframework.stereotype.Component;

@Component("galaxyWatch")
public class GalaxyWatch implements Watch {
	public GalaxyWatch() {
		System.out.println("갤럭시워치 객체 생성됨");
	}
	
	public void powerOn() {
		System.out.println("갤럭시워치로 폰 전원 ON");
	}
	public void powerOff() {
		System.out.println("갤럭시워치로 폰 전원 OFF");
	}
	public void call() {
		System.out.println("갤럭시워치로 폰 전화");
	}
}
