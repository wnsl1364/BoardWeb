package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals("GET")) {
			// 1.회원가입 화면(get 방식) WEB-INF/views/signForm.jsp
			req.getRequestDispatcher("manager/signForm.tiles").forward(req, resp);
		} else {
			// 2.회원가입 처리(post 방식) 파일업로드:images, db 등록
			// 파일업로드하는 라이브러리 추가해줄게유(cos)
			// MultipartRequest 매개변수로 들어가야하는 애들 1)요청정보 2)경로 3)최대크기 4)이름처리해주는 인코딩 방식 5)리네임정책
			// 경로
			String saveDir = req.getServletContext().getRealPath("images");
			// 파일의 최대크기
			int maxSize = 1024 * 1024 * 5; // 5MB
			// 인코딩방식
			String enc = "UTF-8";

			MultipartRequest mr = new MultipartRequest(req, saveDir, maxSize, enc, new DefaultFileRenamePolicy());
			// 사용자가 등록한 파라미터 & 값
			String uid = mr.getParameter("userId");
			String upw = mr.getParameter("userPw");
			String unm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");

			MemberVO mvo = new MemberVO();
			mvo.setUserId(uid);
			mvo.setPassword(upw);
			mvo.setUserName(unm);
			mvo.setImages(img);

			// 업무처리
			MemberService svc = new MemberServiceImpl();
			if (svc.addMember(mvo)) {
				resp.sendRedirect("loginForm.do");
			} else {
				System.out.println("처리오류");
			}
		}
	}

}
