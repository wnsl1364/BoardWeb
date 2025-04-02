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

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전달되는 파라미터 uname, psw
		// 두개의 파라미터를 읽어와서 db에 있는지 확인 있으면 목록으로 없으면 오류메세지
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		
		//업무프로세스(서비스객체)를 통해서 처리
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = svc.login(id, pw); //MemberVO: 리턴타입
		
		if(mvo == null) {
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/views/loginForm.jsp").forward(req, resp); //forward(): 서버 안에서 "몰래 이동"
		}else {
			// 로그인 성공 => 세션객체, 로그인정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("logId", id); //세션의 attr에 저장
			session.setAttribute("userName", mvo.getUserName());
			
			resp.sendRedirect("main.do"); //sendRedirect(): 브라우저가 새로 요청
		}

	}

}
