<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
	<!-- modifyBoard.jsp -->
	<h3>수정화면(modifyBoard.jsp)</h3>
	<%
	BoardVO bvo = (BoardVO) request.getAttribute("board");
	String paging = (String) request.getAttribute("page");
	%>
	<form action="modifyBoard.do" method="post">
		<input type="hidden" name="bno" value="<%=bvo.getBoardNo()%>">
		<input type="hidden" name="page" value="<%=paging%>">
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
				<td colspan="4" align="center"><input type="submit" value="저장"
					class="btn btn-warning"></td>
			</tr>
		</table>
	</form>
	
<jsp:include page="includes/footer.jsp" />