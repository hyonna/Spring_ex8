package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDTO;

@Repository
public class FileDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="FileMapper.";
	
	
	public int setDelete(int fnum) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"fileDelete", fnum);
	}
	
	public int setUpdate(List<FileDTO> files) throws Exception {
		
		return sqlSession.update(NAMESPACE+"fileUpdate", files);
	}
	
	public int setWrite(List<FileDTO> files) throws Exception {
		
		int result = sqlSession.insert(NAMESPACE+"fileWrite", files);
		
		return result;
	}
	
	public List<BoardDTO> getList(int num) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"fileList", num);
	}
	
	public FileDTO getSelect(int fnum) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"fileSelect", fnum);
	}
	
	

}
