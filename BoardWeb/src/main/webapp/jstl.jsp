<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/jstl.jsp</title>
</head>
<body>
<!-- JSTL은 JSP에서 자바 코드를 태그로 바꿔주는 도구 -->
<%
	request.setAttribute("name", "Jooyeon");
	List<String> list = new ArrayList<String>();
	list.add("Hello");
	list.add("Hi");
	list.add("What's up");
	request.setAttribute("list", list);
	request.setAttribute("today", new Date());
%>
	<!-- jstl변수 초기화 -->
	<!-- 달러+중괄호: Expression Language(EL) -->

	<!-- set: 변수선언하는 태그 -->
	<c:set var="msg" value="Hello" />

	<!-- out: 변수의 값을 불러오는 태그 -->
	<!-- eq는 ==와 뜻이 같다 -->
	<!-- ne는 !=와 뜻이 같다 -->	
	<%-- <p><c:out value="${msg eq 'Hello'}"></c:out></p>
	<p><c:out value="${msg == 'Hello'}"></c:out></p>
	<p><c:out value="${msg ne 'Hello'}"></c:out></p>
	<p><c:out value="${msg != 'Hello'}"></c:out></p> --%>
	<p><c:out value="${msg}"></c:out></p>
	
	<p>request객체의 name Attribute의 값은 ${name }</p>
	<p>Session객체의 logId Attribute의 값은 ${logId } </p>
	
	<!-- if: 조건문 -->
	<!-- 조건 절을 test로 -->
	<c:if test="${msg == 'Hello'}">
		<c:out value="msg의 값이 Hello입니다!"></c:out>
	</c:if>
	
	<!-- choose when otherwise: 조건문 -->
	<c:set var="age" value="20"></c:set>
	<c:choose>
		<c:when test="${age >= 20 }">
			<p>성인입니다.</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- forEach: 반복문 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>2 * ${i } = ${2*i }</p>
	</c:forEach>
	
	<ul>
		<c:forEach var="str" items="${list }">
			<li><c:out value="${str }"></c:out></li>
		</c:forEach>
	</ul>
	
	<!-- fmt -->
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/>
	<c:set var="cnt" value="100000" ></c:set>
	<fmt:formatNumber value="${cnt }" pattern="##,###,###"></fmt:formatNumber>

	<script>
		let msg = 'Hello';
		console.log(`${msg}`);
	</script>
</body>
</html>