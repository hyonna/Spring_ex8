package com.iu.s8;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.board.qna.QnaServiceImpl;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.PageMaker;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	@Inject
	private QnaServiceImpl qnaServiceImpl;
	@Inject
	private FileDAO fileDAO;

	
	
	//////////////////////////////////////Write
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView setWrite(ModelAndView mv) throws Exception {

		mv.setViewName("board/boardWrite");
		mv.addObject("board", "qna");

		return mv;
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String setWrite(Model model, BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session)
			throws Exception {
		int result = qnaServiceImpl.setWrite(boardDTO, f1, session);
		String view = "common/messageMove";
		if (result > 0) {
			view = "redirect:./qnaList";
		} else {
			model.addAttribute("message", "Write Fail");
			model.addAttribute("path", "./qnaList");
		}
		return view;
	}

	
	//////////////////////////////////////Select
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public String getSelect(Model model, @RequestParam(defaultValue = "0", required = false) int num) throws Exception {

		BoardDTO boardDTO = qnaServiceImpl.getSelect(num);
		String view = "common/messageMove";

		if (boardDTO != null) {

			view = "board/boardSelect";
			model.addAttribute("board", "qna");
			model.addAttribute("dto", boardDTO);

		} else {

			model.addAttribute("message", "No contents");
			model.addAttribute("path", "./qnaList");
		}

		return view;
	}

	//////////////////////////////////////Delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public String setDelete(Model model, @RequestParam(defaultValue = "0", required = false) int num) throws Exception {

		int result = qnaServiceImpl.setDelete(num);
		String view = "common/messageMove";

		if (result > 0) {

			view = "redirect:../";

		} else {

			model.addAttribute("message", "Delete Fail");
			model.addAttribute("path", "./qnaList");
		}

		return view;
	}

	//////////////////////////////////////Update
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public String setUpdate(Model model, BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {

		int result = qnaServiceImpl.setUpdate(boardDTO, f1, session);
		String view = "common/messageMove";

		if (result > 0) {

			view = "redirect:./qnaList";
		} else {

			model.addAttribute("message", "Update Fail");
			model.addAttribute("path", "./qnaList");
		}

		return view;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public String setUpdate(int num, Model model) throws Exception {
		
		BoardDTO boardDTO = qnaServiceImpl.getSelect(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("board", "qna");
		
		return "board/boardUpdate";
		
	}

	
	////////////////////////////////////// List
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView selectList(PageMaker pageMaker, ModelAndView mv) throws Exception {

		List<BoardDTO> ar = qnaServiceImpl.getList(pageMaker);
		mv.addObject("list", ar);
		mv.addObject("pager", pageMaker);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");

		return mv;
	}

}
