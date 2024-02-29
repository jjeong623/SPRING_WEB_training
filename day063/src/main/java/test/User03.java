package test;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardDTO;
import com.spring.biz.board.BoardService;
import com.spring.biz.member.MemberDTO;
import com.spring.biz.member.MemberService;

public class User03 {
	public static void main(String[] args) {
		   AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		      
		      BoardService boardService = (BoardService)factory.getBean("boardService");
		      MemberService memberService = (MemberService)factory.getBean("memberService");
		      
		      Scanner sc = new Scanner(System.in);
		      
		      MemberDTO member = null;// 현재 로그인한 회원의 정보
		      int action;
		      
		      
		      while(true) {
		    	  System.out.println("1. 로그인");
		    	  System.out.println("2. 글작성");
		    	  System.out.println("3. 글전체목록보기");
		    	  System.out.print("번호를 입력해주세요>>");
		    	  action = sc.nextInt();
		    	  
		    	  if(action == 1) {
		    		  //로그인
						MemberDTO mDTO=new MemberDTO();
						System.out.print("아이디 입력 >> ");
						mDTO.setMid(sc.next());
						System.out.print("비밀번호 입력 >> ");
						mDTO.setPassword(sc.next());
						mDTO=memberService.selectOne(mDTO);
						if(mDTO == null) {
							System.out.println("로그인 실패");
						} 
						else {
							member=mDTO;
							System.out.println("로그인 성공");
						}
					}
					else if(action == 2) {
						//글작성
						if(member == null) {
							System.out.println("로그인하고 글 작성해주세요!");
							continue;
						}
						BoardDTO bDTO=new BoardDTO();
						System.out.print("제목 입력>> ");
						bDTO.setTitle(sc.next());
						System.out.print("내용 입력>> ");
						bDTO.setContent(sc.next());
						bDTO.setWriter(member.getMid());
						if(boardService.insert(bDTO)) {
							System.out.println("글 작성 성공");
						}
						else {
							System.out.println("글 작성 실패");
						}
					}
					else if(action == 3){
						//전체글 목록보기
						BoardDTO bDTO=new BoardDTO();
						ArrayList<BoardDTO> datas=boardService.selectAll(bDTO);
						for(BoardDTO data:datas) {
							System.out.println(data);
						}
					}
					else {
						break;
					}
				}
				
				factory.close();
		      
		   }

}

