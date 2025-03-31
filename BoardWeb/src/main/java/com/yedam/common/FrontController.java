package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

public class FrontController extends HttpServlet {

	// 요청 url <=>실행컨트롤
	Map<String, Control> map;

	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init() throws ServletException {
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 글목록
		map.put("/addBoard.do", new AddBoardControl());// 글등록
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("uri: " + uri);
		String context = req.getContextPath();
		System.out.println("context: " + context);
		String page = uri.substring(context.length());
		System.out.println("page: " + page);
		Control sub = map.get(page);
		sub.exec(req, resp);
	}
}
