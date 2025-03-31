<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
	<% 
	BoardVO bvo = (BoardVO) request.getAttribute("olist");
	%>
	<h3>상세조회</h3>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제 목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=bvo.getBoardNo()%></td>
				<td><%=bvo.getTitle()%></td>
				<td><%=bvo.getContent()%></td>
				<td><%=bvo.getWriter()%></td>
				<td><%=bvo.getWriteDate()%></td>
			</tr>
		</tbody>
	</table>
<jsp:include page="includes/footer.jsp" />