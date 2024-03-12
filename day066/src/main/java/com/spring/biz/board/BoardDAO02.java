package com.spring.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO02 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECTALL="SELECT * FROM BOARD";
	private static final String SELECTONE="SELECT * FROM BOARD WHERE BID=?";

	private static final String INSERT="INSERT INTO BOARD (TITLE,CONTENT,WRITER) VALUES(?,?,?)";
	private static final String UPDATE="";
	private static final String DELETE="";

	public ArrayList<BoardDTO> selectAll(BoardDTO bDTO) {
		return (ArrayList<BoardDTO>)jdbcTemplate.query(SELECTALL, new BoardRowMapper());
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
		int result=jdbcTemplate.update(INSERT);
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean update(BoardDTO bDTO) {
		int result=jdbcTemplate.update(UPDATE);
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean delete(BoardDTO bDTO) {
		int result=jdbcTemplate.update(DELETE);
		if(result<=0) {
			return false;
		}
		return true;
	}
}

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
