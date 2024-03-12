package com.spring.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO02 {
	@Autowired //★ @Autowired는 만능이 아니다.. 현재는 메모리에 없다
	private JdbcTemplate jdbcTemplate; //의존관계 ▶ DI(의존주입)

	private static final String SELECTALL="SELECT * FROM BOARD";
	private static final String SELECTONE="SELECT * FROM BOARD WHERE BID=?";

	private static final String INSERT="INSERT INTO BOARD (TITLE,CONTENT,WRITER) VALUES(?,?,?)";
	private static final String UPDATE="";
	private static final String DELETE="";
 
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return jdbcTemplate.query(SELECTALL, new BoardRowMapper());
	}
	
	public BoardDTO selectOne(BoardDTO bDTO) {
		Object[] args= { bDTO.getBid() };
		try {
			return jdbcTemplate.queryForObject(SELECTONE, args, new BoardRowMapper());
		} catch(Exception e) {
			return null;
		}
	}

	public boolean insert(BoardDTO bDTO) {
		int result = jdbcTemplate.update(INSERT);
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean update(BoardDTO bDTO) {
		int result = jdbcTemplate.update(UPDATE);
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	public boolean delete(BoardDTO bDTO) {
		int result = jdbcTemplate.update(DELETE);
		if(result <= 0) {
			return false;
		}
		return true;
		}
	}
	// 개발자의 편의를 위해 RowMapper 인터페이스를 사용
		class BoardRowMapper implements RowMapper<BoardDTO> {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO data=new BoardDTO();
				data.setBid(rs.getInt("BID"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				return data;
			}
}
