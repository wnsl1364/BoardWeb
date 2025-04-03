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
	//이 컨트롤러는 Control 인터페이스를 구현했기 때문에 반드시 exec() 메서드를 정의해야 함
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBoard.do
		
		// HttpServletRequest req: 클라이언트(브라우저)가 보낸 요청 데이터
		// HttpServletResponse resp: 서버가 응답할 때 사용하는 객체
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		if (req.getMethod().equals("GET")) {
			//url에 직접입력, 링크 => get방식요청
			
			//요청재지정
			req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);
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
			
			resp.sendRedirect("boardList.do"); //요청재지정 //다른 페이지로 이동(redirect)
		}
	}

}
