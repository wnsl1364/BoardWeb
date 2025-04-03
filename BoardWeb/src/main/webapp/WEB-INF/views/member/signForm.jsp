<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원가입(signForm.jsp)</h3>
<form action="signUp.do" method="post" enctype="multipart/form-data">
	<!-- application/x-www-form-urlencoded: 기본값으로, 모든 문자들은 서버로 보내기 전에 인코딩됨을 명시함. -->
	<!-- multipart/form-data: 모든 문자를 인코딩하지 않음을 명시함. 이 방식은 <form> 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용함. -->
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId" class="form-control"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userPw" class="form-control"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="userName" class="form-control"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="userImg" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원가입" class="btn btn-primary">
				<input type="reset" value="초기화" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>