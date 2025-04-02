<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="includes/header.jsp" />
	<!-- modifyBoard.jsp -->
	<h3>수정화면(modifyBoard.jsp)</h3>
	<form action="modifyBoard.do" method="post">
		<input type="hidden" name="bno" value="${board.boardNo }%>">
		<input type="hidden" name="page" value="${page }">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>${board.boardNo }</td>
				<th>제 목</th>
				<td><input type="text" name="title" class="form-control" value="${board.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer }</td>
				<th>작성일자</th>
				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea class="form-control" name="content" rows="5" cols="40">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="저장"
					class="btn btn-warning"></td>
			</tr>
		</table>
	</form>
	
<jsp:include page="includes/footer.jsp" />