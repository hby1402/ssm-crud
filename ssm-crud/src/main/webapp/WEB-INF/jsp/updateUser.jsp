<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>修改页面</title>
</head>
<body>
	<div class="container">
		<h2 style="color: gray; height: 50px;">修改用户</h2>
		<form action="/updateUser" method="post">
			<div class="form-group" hidden>
				<label>编号</label> <input type="text" class="form-control"
					name="id" value="${user.id}">
			</div>
			<div class="form-group">
				<label>姓名</label> <input type="text" class="form-control"
					name="name" value="${user.name}" required>
			</div>
			<div class="form-group">
				<label>地址</label> <input type="text" class="form-control"
					name="address" value="${user.address}" required>
			</div>
			<div class="form-group">
				<label>生日</label> <input type="text" class="form-control"
					name="birth_date" value="${user.birth_date}" required>
			</div>
			<div class="form-group">
				<label>创建日期</label> <input type="text" class="form-control"
					name="create_date" value="${user.create_date}" required>
			</div>
			<button type="submit" class="btn btn-primary btn-lg col-md-12">修改</button>
		</form>
	</div>
</body>
</html>