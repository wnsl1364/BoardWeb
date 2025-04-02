package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class LoginFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 화면을 열어줌 /WEB-INF/views/loginForm.jsp
		req.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(req, resp);
	}

}
