<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- webapp/WEB-INF/views/board.jsp -->
<h3>상세조회(board.jsp)</h3>
<form action="modifyForm.do" method="post">
	<input type="hidden" name="bno" value="${board.boardNo }"> 
	<input type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>제 목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일자</th>
			<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name="content" rows="5" cols="40" readonly>${board.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="수정" class="btn btn-warning">
				
				<c:choose>
					<c:when test="${logId != null && logId == board.writer }">					
						<button type="button" class="btn btn-danger">삭제</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-danger" disabled>삭제</button>
					</c:otherwise>						
				</c:choose>	
			</td>
		</tr>
		<c:if test="${msg != null }">
			<tr><td colspan="4" align="center" style="color:red">${msg}</td></tr>
		</c:if>
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
		location.href = 'deleteForm.do?bno=${board.boardNo }';// 삭제화면으로 이동
	}
</script>