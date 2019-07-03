package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.PageMaker;

@Repository
public class QnaDAOImpl implements BoardDAO {
	
	
	@Inject
	private SqlSession sqlSession;
	private String mapper = "QnaMapper.";
	
	
	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		return sqlSession.selectOne(mapper+"totalCount", pageMaker);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(mapper+"qnaDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(mapper+"qnaUpdate", boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(mapper+"qnaWrite", boardDTO);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapper+"qnaList");
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapper+"qnaSelect", num);
	}
	
	

}
