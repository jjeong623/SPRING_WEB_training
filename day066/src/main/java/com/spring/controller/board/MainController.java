package com.spring.controller.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller("main") // "implements Controller"를 포함하는 @
public class MainController {

	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav=new ModelAndView();
		mav.setViewName("main"); // 포워드 + main.jsp
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
		mav.addObject("mdatas", mdatas); // == request.setAttribute("mdatas", mdatas);
		
		return mav;
		
	}

}
