package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//interface를 만드는 이유: 컨트롤이 가진 공통된 메소드 exec실행을 위해서
public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
