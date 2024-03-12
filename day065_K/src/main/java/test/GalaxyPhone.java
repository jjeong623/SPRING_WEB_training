package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("galaxy")
public class GalaxyPhone implements Phone {
	@Autowired
	@Qualifier("galaxyWatch")
	private Watch watch;
	/*
	public GalaxyPhone(Watch watch) {
		this.watch=watch;
		System.out.println("갤럭시 폰 생성자 주입 완료");
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("갤럭시 폰 Setter 주입 완료");
	}
	*/
	
	@Override
	public void powerOn() {
		watch.powerOn();
	}
	@Override
	public void powerOff() {
		watch.powerOff();
	}
	@Override
	public void call() {
		watch.call();
	}
}
