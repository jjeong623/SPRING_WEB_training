package com.spring.controller.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Action
public interface XXXControllerXXX {

	// ActionForward → String
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
