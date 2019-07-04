package com.iu.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s8.AbstractTest;
import com.iu.util.PageMaker;

public class QnaServiceTest extends AbstractTest{
	
	@Inject
	private QnaServiceImpl QnaServiceImpl;

	@Test
	public void getList() throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCurPage(1);
		List<BoardDTO> ar = QnaServiceImpl.getList(pageMaker);
		
	}

}
