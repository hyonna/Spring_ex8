package com.iu.s8;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.qna.QnaServiceImpl;
import com.iu.util.PageMaker;

@Controller
@RequestMapping("/qna/")
public class QnaController {
	
	@Inject
	private QnaServiceImpl qnaServiceImpl;
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public void selectList(PageMaker pageMaker, ModelAndView mv) throws Exception {
		
		mv.addObject("pager", pageMaker);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		
	}

}
