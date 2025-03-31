package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		if (req.getMethod().equals("GET")) {
			//url에 직접입력, 링크 => get방식요청
			
			//요청재지정
			req.getRequestDispatcher("/WEB-INF/views/addForm.jsp").forward(req, resp);
		}else if(req.getMethod().equals("POST")){
			//등록
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession(true):자동커밋
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			int r = mapper.insertBoard(board);
			
			resp.sendRedirect("boardList.do"); //요청재지정
		}
	}

}
