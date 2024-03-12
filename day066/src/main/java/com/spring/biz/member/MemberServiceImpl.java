package com.spring.biz.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 1. xxxImpl 네? 아, 인터페이스를 구현한 클래스겠구나!
// 2. 인터페이스를 사용했네? 아, 메서드 시그니쳐를 강제해야했구나!
// 3. 왜 강제해? 아, 의존관계에 있는 객체가 해당 메서드 시그니쳐겠구나!
@Service("memberService")
// 1. 가독성 ↑ : 개발자가 이 객체가 Service 레이어의 객체임을 빠르게 파악가능!
// 2. 스프링 컨테이너가 메모리 관리를 하잖아요? 같은 @끼리 메모리위치를 잘 정리하여 관리가능!
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO02 mDAO;

	@Override
	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		return mDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.selectOne(mDTO);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		mDAO.insert(mDTO); // 성공
		return mDAO.insert(mDTO); // 실패
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.update(mDTO);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.delete(mDTO);
	}

}
