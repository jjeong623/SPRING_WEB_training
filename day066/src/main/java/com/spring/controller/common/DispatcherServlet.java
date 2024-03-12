package com.spring.controller.common;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// FrontController
// @ ▶ .xml : 서블릿 컨테이너(톰캣, 웹 서버)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping handler;
	private ViewResolver viewResolver;

	// init-method="init"
	// 1. 멤버변수 초기화하는 역할
	// 2. 생성자
	// 3. setter
	// 4. @Autowired
	// 5. DI(의존주입)
	// 6. init() 메서드
	public void init() {
		handler=new HandlerMapping();
		viewResolver=new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String commend=uri.substring(cp.length());
		System.out.println("FC : "+commend);

		Controller controller=handler.getController(commend);
		ModelAndView mav = controller.handleRequest(request, response);

		if(!mav.getViewName().contains(".do")) {
			mav.setViewName(viewResolver.getView(mav.getViewName()));
		}
		response.sendRedirect(mav.getViewName());

	}
}
