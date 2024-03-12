package com.spring.biz.member;

import java.util.ArrayList;

// 1. DAO를 사용할 Service의
// 2. 메서드 시그니쳐가 DAO와 같으면 용이하겠다!
// 3. 메서드 시그니쳐를 강제해보자!!!
public interface MemberService {
	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO);
	public MemberDTO selectOne(MemberDTO mDTO);
	
	public boolean insert(MemberDTO mDTO);
	public boolean update(MemberDTO mDTO);
	public boolean delete(MemberDTO mDTO);
}
