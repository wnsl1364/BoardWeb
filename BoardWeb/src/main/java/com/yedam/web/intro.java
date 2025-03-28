package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/intro")
public class intro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public intro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>한주연</h3>");
		out.print("<p>성별: 여성👩</p>");
		out.print("<p>고양이 유무: 有😺</p>");
		out.print("<p>주소: 대구광역시 동구 신천 4동🚩 </p>");
		out.print("<p>취미: 드라마보기📺</p>");
		out.print("<p>좋아하는 음식: 샤브샤브🍲</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
