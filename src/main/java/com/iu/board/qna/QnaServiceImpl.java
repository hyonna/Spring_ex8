package com.iu.board.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class QnaServiceImpl implements BoardService {

	@Inject
	private QnaDAOImpl qnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	
	
	public int setReply(BoardDTO boardDTO, QnaDTO qnaDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		result = qnaDAO.setReply(qnaDTO);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		
		String path = session.getServletContext().getRealPath("upload");
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		
		for (MultipartFile multipartFile : multipartFiles) {
			
			String fname = fileSaver.saveFile3(path, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			
			files.add(fileDTO);
		}
		
		
		fileDAO.setWrite(files);
		
		
		return result;
		
		
	}
	
	@Override
	public int setDelete(int num) throws Exception {
		
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {

		
		int result = qnaDAO.setUpdate(boardDTO);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		
		String path = session.getServletContext().getRealPath("upload");
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		
		for (MultipartFile multipartFile : multipartFiles) {
			
			String fname = fileSaver.saveFile3(path, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			
			files.add(fileDTO);
		}
		
		
		fileDAO.setUpdate(files);
		
		
		return result;
	}

	
	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		
		int result = qnaDAO.setWrite(boardDTO);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		
		String path = session.getServletContext().getRealPath("upload");
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		
		for (MultipartFile multipartFile : multipartFiles) {
			
			String fname = fileSaver.saveFile3(path, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			
			files.add(fileDTO);
		}
		
		
		fileDAO.setWrite(files);
		
		return result;
	}
	


	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		int totalCount = qnaDAO.getTotalCount(pageMaker);
		
		pageMaker.makePage(totalCount);
		
		return qnaDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {

		return qnaDAO.getSelect(num);
	}

}
