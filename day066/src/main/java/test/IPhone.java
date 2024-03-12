package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("apple") // new   <bean id="apple">
public class IPhone implements Phone {
	
	@Autowired // DI(의존 주입)
	@Qualifier("appleWatch")
	private Watch watch; // 의존 관계
	/*
	public IPhone(Watch watch) { // 생성자 주입
		this.watch=watch;
		System.out.println("생성자를 통해 의존 주입");
	}
	public void setWatch(Watch watch) { // Setter 주입
		this.watch=watch;
		System.out.println("setter를 통해 의존 주입");
	}
	*/
	 
	public void powerOn() {
		watch.powerOn();
	}
	public void powerOff() {
		watch.powerOff();
	}
	public void call() {
		watch.call();
	}

}
