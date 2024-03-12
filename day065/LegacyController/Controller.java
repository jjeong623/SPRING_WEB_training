package com.spring.controller.common;

// Action
public interface Controller {

	// ActionForward → String
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
