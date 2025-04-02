package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {
	///modifyForm.do

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno=15 단건조회 modifyBoard.jsp
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);	
		
		String page = req.getParameter("page");
		int no = Integer.parseInt(req.getParameter("bno"));
		BoardVO board = mapper.selectOne(no);
		
		// 권한 있는지 체크
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		if(logId != null && logId.equals(board.getWriter())) {
			req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "권한 노노");
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
		}
		
		
		
		
	}

}
