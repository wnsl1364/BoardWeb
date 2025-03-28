package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 서블릿은 브라우저에서 "/Welcome"이라는 URL로 요청이 들어왔을 때 실행됩니다.
// 즉, 주소창에 http://localhost:8080/프로젝트명/Welcome 을 입력하면 이 클래스가 실행됩니다.
@WebServlet("/Welcome") // 웹에서 접근 가능한 URL 매핑
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서블릿 객체가 생성될 때 한 번만 호출되는 생성자입니다.
	public WelcomeServlet() {
		super();
	}

	// GET 방식으로 요청이 들어왔을 때 실행되는 메서드입니다.
	// (브라우저 주소창에서 직접 요청하거나, 링크 클릭 시 대부분 GET 방식으로 요청됩니다.)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 응답의 콘텐츠 타입을 HTML로 설정하고, 문자 인코딩은 UTF-8로 지정합니다.
		response.setContentType("text/html;charset=utf-8");		
		
		// 브라우저에 출력할 내용을 작성하기 위해 PrintWriter 객체를 생성합니다.
		PrintWriter out = response.getWriter();
		
		// 브라우저에 출력할 HTML 코드 작성
		out.print("<h3>안녕하세요! 서블릿 페이지입니다~!</h3>");
		out.print("<a href ='index.html'>첫페이지로 이동</a>");
	}

	// POST 방식으로 요청이 들어왔을 때 실행되는 메서드입니다.
	// 여기서는 GET과 동일한 로직을 처리하게 하기 위해 doGet()을 호출하고 있습니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}