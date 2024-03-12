package com.spring.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// DAO → DAO02
// JDBCTemplate 을 활용한 버전업
// JDBCTemplate : 템플릿 패턴을 활용한 클래스
//                반복되는 JDBC 의 로직을 캡슐화한 클래스
//  : 기존 DAO 에 템플릿 패턴을 활용한 클래스를 구현해서 가독성 증가
// ※ 템플릿 패턴 이란?
//  ▶ 주로 반복되거나, 복잡한 로직을 캡슐화한 클래스
@Repository("memberDAO")
public class MemberDAO02 {

	@Autowired // ★ @Autowired 는 만능이아니다...
	private JdbcTemplate jdbcTemplate; // 의존관계 ▶ DI(의존주입)

	private static final String SELECTALL="SELECT * FROM MEMBER";
	private static final String SELECTONE="SELECT * FROM MEMBER WHERE MID=? AND PASSWORD=?";

	private static final String INSERT="INSERT INTO MEMBER (MID,PASSWORD,NAME,ROLE) VALUES(?,?,?,?)";
	private static final String UPDATE="";
	private static final String DELETE="";

	// ※ ArrayList 보다는 List 를 훨씬 많이 사용
	// ※ ArrayList ▶ List 변경할것!!!
	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		return (ArrayList<MemberDTO>)jdbcTemplate.query(SELECTALL, new MemberRowMapper());
	}
	public MemberDTO selectOne(MemberDTO mDTO) {
		Object[] args= { mDTO.getMid(), mDTO.getPassword() };
		try {
			return jdbcTemplate.queryForObject(SELECTONE, args, new MemberRowMapper());
		} catch(Exception e) {
			return null;
		}
	}

	public boolean insert(MemberDTO mDTO) {
		int result=jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean update(MemberDTO mDTO) {
		int result=jdbcTemplate.update(UPDATE, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean delete(MemberDTO mDTO) {
		int result=jdbcTemplate.update(DELETE, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if(result<=0) {
			return false;
		}
		return true;
	}
}

// 개발자의 편의를 위해 RowMapper 인터페이스를 사용
class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO data=new MemberDTO();
		data.setMid(rs.getString("MID"));
		data.setPassword(rs.getString("PASSWORD"));
		data.setName(rs.getString("NAME"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}

}
