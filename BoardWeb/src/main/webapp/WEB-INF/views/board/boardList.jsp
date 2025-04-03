<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- webapp/WEB-INF/views/boardList.jsp -->
<p>${pageDTO}</p>
<!-- blist, paging, searchCondition, keyword -->
<h3>게시글 목록(boardList.jsp)</h3>
<!-- 검색조건 -->
<form action="boardList.do" method="get">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option>선택하세요</option>
				<option value="T" ${searchCondition != null and searchCondition eq 'T' ? 'selected' : ''}>제목</option>
				<option value="W" ${searchCondition != null and searchCondition eq 'W' ? 'selected' : ''}>작성자</option>
				<option value="TW" ${searchCondition != null and searchCondition eq 'TW' ? 'selected' : ''}>제목&작성자</option>
			</select>
		</div>
		<div class="col-sm-4">
			<input type="text" name="keyword" class="form-control" value="${keyword != null ? keyword : ''}">
		</div>
		<div class="col-sm-2">
			<button type="submit" class="btn btn-primary">검색</button>
		</div>
	</div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="board" items="${blist }">
			<tr>
				<td>${board.boardNo}</td>
				<td><a href='board.do?page=${paging.currentPage }&bno=${board.boardNo}'>${board.title }</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이징 처리 -->
<nav aria-label="...">
  <ul class="pagination">
  	<!-- 이전 10개 페이지 여부 -->
  	<c:choose>
  	<c:when test="${paging.prev }">	  
	  	<li class="page-item">
	      <a class="page-link" href="boardList.do?page=${paging.startPage - 1}">Previous</a>
	    </li>
    </c:when>
    <c:otherwise>
	    <li class="page-item disabled">
	      <span class="page-link">Previous</span>
	    </li>
    </c:otherwise>
    </c:choose>
    
    
    <c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
	    <c:choose>
	    	<c:when test="${paging.currentPage == p }">
			    <li class="page-item active" aria-current="page">
			      <span class="page-link">${p }</span>
			    </li>
		    </c:when>
		    <c:otherwise>
		    	<li class="page-item"><a class="page-link" href="boardList.do?page=${p }&searchCondition=${searchCondition }&keyword=${keyword }">${p }</a></li>
		     </c:otherwise>
	     </c:choose>
     </c:forEach>
    
    <!-- 이후 10개 페이지 여부 -->
    <c:choose>
    	<c:when test="${paging.next }">
		  	<li class="page-item">
		      <a class="page-link" href="boardList.do?page=${paging.endPage + 1}">Next</a>
		    </li>
	    </c:when>
    	<c:otherwise>
		    <li class="page-item disabled">
		      <span class="page-link">Next</span>
		    </li>
	    </c:otherwise>
    </c:choose>
  </ul>
</nav>
