<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
	<%
	BoardVO bvo = (BoardVO) request.getAttribute("olist");
	String paging = (String) request.getAttribute("page");
	%>
	<h3>상세조회(board.jsp)</h3>
	<form action="modifyForm.do" method="post">
		<input type="hidden" name="bno" value="<%=bvo.getBoardNo()%>">
		<input type="hidden" name="page" value="<%=paging%>">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><%=bvo.getBoardNo()%></td>
				<th>제 목</th>
				<td><%=bvo.getTitle()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=bvo.getWriter()%></td>
				<th>작성일자</th>
				<td><%=bvo.getWriteDate()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea class="form-control" name="content" rows="5" cols="40" readonly><%=bvo.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정" class="btn btn-warning">
					<button type="button" class="btn btn-danger">삭제</button>
				</td>
			</tr>
		</table>
	</form>
	<p>
		<a href='boardList.do'>목록으로</a>
	</p>
	<script>
		//삭제버튼에 이벤트 등록
		document.querySelector('.btn-danger').addEventListener('click', deleteFnc);
		//삭제 함수
		function deleteFnc(){
			location.href = 'deleteForm.do?bno=<%=bvo.getBoardNo()%>';// 삭제화면으로 이동
		}
	</script>
<jsp:include page="includes/footer.jsp" />