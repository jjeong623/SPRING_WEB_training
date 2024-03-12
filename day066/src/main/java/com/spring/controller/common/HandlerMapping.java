package com.spring.controller.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		
		//mappings.put("/login.do", new LoginController());
		//mappings.put("/main.do", new MainController());
	}
	
	public Controller getController(String commend) {
		return mappings.get(commend);
	}
}
