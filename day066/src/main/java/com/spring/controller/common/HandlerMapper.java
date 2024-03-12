package com.spring.controller.common;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapper {
	private Map<String,Controller> mappings;
	
	public HandlerMapper() {
		mappings = new HashMap<String,Controller>();
		
		mappings.put("/main.do", new MainAction());
		mappings.put("/login.do", new LoginAction());
	}
	
	public Controller getController(String commend) {
		return mappings.get(commend);
	}
}
