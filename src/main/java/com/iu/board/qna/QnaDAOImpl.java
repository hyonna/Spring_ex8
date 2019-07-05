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
	private static final String NAMESPACE = "QnaMapper.";
	
	
	public int setReplyUpdate(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaDTO);
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaDTO);
	}
	
	
	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"totalCount", pageMaker);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"qnaDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"qnaUpdate", boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {

		int result = sqlSession.insert(NAMESPACE+"qnaWrite", boardDTO);
		
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"qnaList", pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", num);
	}
	
	

}
