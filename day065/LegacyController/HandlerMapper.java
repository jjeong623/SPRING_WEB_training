package com.spring.controller.common;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapper {
	private Map<String,Controller> mappings;
	
	public HandlerMapper() {
		mappings=new HashMap<String,Controller>();
		
		mappings.put("/main.do", new MainAction());
		mappings.put("/login.do", new LoginAction());
		mappings.put("/joinPage.do", new JoinPageAction());
		mappings.put("/logout.do", new LogoutAction());
		mappings.put("/testPage.do", new TestPageAction());
		mappings.put("/loginPage.do", new LoginPageAction());
		mappings.put("/mypage.do", new MypageAction());
		mappings.put("/replySelectOne.do", new ReplySelectOneAction());
		mappings.put("/replyInsert.do", new ReplyInsertAction());
		mappings.put("/replyUpdate.do", new ReplyUpdateAction());
		mappings.put("/replyDelete.do", new ReplyDeleteAction());
		mappings.put("/changeName.do", new ChangeNameAction());
		mappings.put("/memberDelete.do", new MemberDeleteAction());
		mappings.put("/alert.do", new AlertAction());
		mappings.put("/goback.do", new GobackAction());
		mappings.put("/error.do", new ErrorAction());
	}
	
	public Controller getController(String commend) {
		return mappings.get(commend);
	}
}
