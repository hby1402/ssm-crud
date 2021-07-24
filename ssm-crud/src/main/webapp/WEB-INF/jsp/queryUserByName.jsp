<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>搜索用户</title>
</head>
<body>
	<div class="container">
		<h2 style="color: gray; height: 50px;">用户显示</h2>
		<a href="/toAddUserPage" type="button" class="btn btn-primary btn-lg">
			<span class="glyphicon glyphicon-plus"></span> 增加用户
		</a>
		<a href="/queryAllUsers" type="button" class="btn btn-info col-md-offset-6">
			返回
		</a>
		<form action="/queryUserByName" class="form-inline col-md-offset-8">
			<input type="text" name="name" class="form-control" placeholder="请输入名称">
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span>搜索
			</button>
		</form>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>地址</th>
					<th>生日</th>
					<th>创建日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.address}</td>
						<td>${user.birth_date}</td>
						<td>${user.create_date}</td>
						<td><a href="/toUpdateUserPage?id=${user.id}"><span class="glyphicon glyphicon-pencil"></span>修改</a>&nbsp; |
							&nbsp; <a href="/deleteUser?id=${user.id}"><span class="glyphicon glyphicon-trash"></span>删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>