package test;

import java.util.ArrayList;

// Bean == 객체 == 기능 단위
// 기능 단위로 코드를 작성해놓은 객체
public class BeanFactory {
	// 팩토리 패턴을 구현하기위한 클래스
	// 팩토리 패턴이란?
	//  : 객체명을 요청하면
	//    해당 객체를 제공하는 것
	
	private ArrayList<String> iDatas;
	private ArrayList<String> gDatas;
	public BeanFactory() {
		iDatas=new ArrayList<String>();
		iDatas.add("IPHONE");
		iDatas.add("APPLE");
		
		gDatas=new ArrayList<String>();
		gDatas.add("GALAXY");
		gDatas.add("SAMSUNG");
	}
		
	private boolean isIPHONE(String phoneName) {
		for(String data:iDatas) {
			if(phoneName.equals(data)) {
				return true;
			}
		}
		return false;
	}
	private boolean isGALAXY(String phoneName) {		
		for(String data:gDatas) {
			if(phoneName.equals(data)) {
				return true;
			}
		}
		return false;
	}
		
	// Object == 자바의 최상위클래스
	public Object getBean(String beanName) {
		beanName=beanName.toUpperCase();
		// 버전 2 : 대소문자에 따른 입력
		
		// 버전 3 : 여러 단어 입력
		if(isIPHONE(beanName)) {
			return new IPhone();
		}
		else if(isGALAXY(beanName)) {
			return new GalaxyPhone();
		}
		
		return null;
	}

}
