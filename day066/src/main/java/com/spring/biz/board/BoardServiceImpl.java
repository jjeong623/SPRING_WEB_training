package com.spring.biz.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO02 bDAO;
	
	@Override
	public ArrayList<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		return bDAO.selectOne(bDTO);
	}

	@Override
	public boolean insert(BoardDTO bDTO) {
		if(bDTO.getBid()==0) { // 무조건 예외발생할수있도록 if 조건문 작성
			throw new ArithmeticException(); // 컴파일러가 무시하는 예외 클래스
		}
		return bDAO.insert(bDTO);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		return bDAO.update(bDTO);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		return bDAO.delete(bDTO);
	}

}
