<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="forum.Forum" %>
<%@ page import= "forum.ForumDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>JSP 게시판 웹 사이트</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%
		String userId = null;
	if (session.getAttribute("userId") != null) {
		userId = (String) session.getAttribute("userId");
	}
	int forumId = 0;
	if (request.getParameter("forumId") != null) {
		forumId = Integer.parseInt(request.getParameter("forumId"));
	}
	if (forumId == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다.')");
		script.println("location.href = 'forum.jsp'");
		script.println("</script>");
	}
	
	Forum forum = new ForumDAO().getForum(forumId);
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collpase-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="forum.jsp">게시판</a></li>
			</ul>
			<%
				if (userId == null) {
			%>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					arai-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul></li>
			</ul>
			<%
			} 
			else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					arai-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
			}
			%>

		</div>
	</nav>
	<div class="container">
		<div class="row">
		<table class="table table:striped" style="text-algin: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center; border: 1px solid #dddddd">게시판 글 보기</th>	
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width:20%;">글 제목</td>
					<td colspan="2"><%= forum.getForumTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;") %></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2"><%= forum.getUserId() %></td>
				</tr>
				<tr>
					<td>작성 일자</td>
					<td colspan="2"><%= forum.getForumDate().substring(0, 11) + forum.getForumDate().substring(11, 13) + " 시 " + forum.getForumDate().substring(14, 16) + " 분 " %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="2" style="min-height: 200px; text-align: left;"><%= forum.getForumContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;") %></td>
				</tr>
			</tbody>
		</table>
		<a href="forum.jsp" class="btn btn-primary">목록</a>
		<%
			if(userId != null && userId.equals(forum.getUserId())) {
		%>
				<a href="update.jsp?forumId=<%= forumId %>" class="btn btn-primary">수정</a>
				<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?forumId=<%= forumId %>" class="btn btn-primary">삭제</a>
		<%
			}
		%>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js">	
	</script>
	<script src="js/bootstrap.js"></script>
</body>
</html>