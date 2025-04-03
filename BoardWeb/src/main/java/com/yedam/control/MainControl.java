package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메인화면
		HttpSession session = req.getSession();
		String logId = (String)session.getAttribute("logId");
		
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		//업무프로세스(서비스객체)를 통해서 처리
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = svc.login(id, pw); //MemberVO: 리턴타입
				
		if(logId == null) {
			resp.sendRedirect("loginForm.do");
		}else {
			if(mvo.getResponsibility().equals("User")) {
//				resp.sendRedirect("main.do"); //sendRedirect(): 브라우저가 새로 요청
				req.getRequestDispatcher("board/main.tiles").forward(req, resp);
			}else if(mvo.getResponsibility().equals("Admin")) {
				req.getRequestDispatcher("manager/main.tiles").forward(req, resp);
			}
		}

	}

}
