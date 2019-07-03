package com.iu.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s8.AbstractTest;
import com.iu.util.PageMaker;

public class QnaDAOTest extends AbstractTest{
	
	@Inject
	private QnaDAOImpl qnaDAOImpl;

	//@Test
	public void test() throws Exception{
		
		
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title");
		qnaDTO.setWriter("writer");
		qnaDTO.setContents("contents");
		
		int result = qnaDAOImpl.setWrite(qnaDTO);
		
		assertEquals(1, result);
	}
	
	

}
