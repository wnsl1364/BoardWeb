package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

// form태그(jsp) -> 서블릿
// 서블릿 -> jsp(아직 안함)

@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet {
	// http://localhost/BoardWeb/getBoard?board_no=13

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String boardNo = req.getParameter("board_no");

		SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true):자동커밋
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO board = mapper.selectOne(Integer.parseInt(boardNo));

		PrintWriter out = resp.getWriter();
		String html = "<h3>게시글 상세조회</h3>";
		html += "<table border='2'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일시</th></tr></thead>";
		html += "<tbody>";
		html += "<tr>";
		html += "<td>" + board.getBoardNo() + "</td>";
		html += "<td>" + board.getTitle() + "</td>";
		html += "<td>" + board.getWriter() + "</td>";
		html += "<td>" + board.getContent() + "</td>";
		html += "<td>" + board.getWriteDate() + "</td>";
		html += "</tr>";
		html += "</tbody></table>";
		html += "<p><a href='mainServlet'>목록으로</a></p>";
		
		out.print(html);
	}
}
