package com.mis.persistence;

import java.util.List;

import com.mis.domain.BoardVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll()  throws Exception;
	
	public void updateViewCnt(int bno) throws Exception;
	
}
