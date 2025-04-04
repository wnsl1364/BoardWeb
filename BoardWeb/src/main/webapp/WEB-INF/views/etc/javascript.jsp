<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	#list li:not(last-child){margin-bottom:10px;}
</style>
<h3>javascript.jsp</h3>

<div class="row">
	<div class="col-sm-6">
		<input type="text" id="userInput" class="form-control">
	</div>
	<div class="col-sm-4">
		<button id="addBtn" class="btn btn-primary">추가</button>
	</div>
</div>

<ul id="list" style="margin-top:20px; display:none;">
	<li>banana</li>
	<li>tomato</li>
	<li>pineapple</li>
	<li>durian</li>
</ul>

<!-- 성별목록 -->
<select class="form-control" id="searchGender" style="margin:20px 0;">
	<option value="all">전체</option>
	<option value="male">남성</option>
	<option value="female">여성</option>
</select>

<table class="table">
	<thead>
		<tr>
			<th><input type="checkbox"></th>
			<th>Id</th>
			<th>First</th>
			<th>Last</th>
			<th>Gender</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody id="target">
		
	</tbody>
</table>

<!-- <script src="js/object.js"></script> -->
<!-- <script src="js/array.js"></script> -->
<!-- <script src="js/json.js"></script> -->
<script src="js/ajax.js"></script>