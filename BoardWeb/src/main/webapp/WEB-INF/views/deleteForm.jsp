<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<h3>삭제화면(deleteForm.jsp)</h3>
	<%
	BoardVO bvo = (BoardVO) request.getAttribute("board");
	%>
	<form action="deleteBoard.do" method="post">
		<input type="hidden" name="bno" value="<%=bvo.getBoardNo()%>">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><%=bvo.getBoardNo()%></td>
				<th>제 목</th>
				<td><input type="text" name="title" class="form-control" value="<%=bvo.getTitle()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=bvo.getWriter()%></td>
				<th>작성일자</th>
				<td><%=bvo.getWriteDate()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea class="form-control" name="content" rows="5" cols="40"><%=bvo.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="삭제"
					class="btn btn-danger"></td>
			</tr>
		</table>
	</form>
<jsp:include page="includes/footer.jsp" />