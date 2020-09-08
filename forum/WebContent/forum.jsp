<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="forum.ForumDAO"%>
<%@ page import="forum.Forum"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a:hover{
		color : #000000;
		text-decoration: none;
	}
</style>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%
		String userId = null;
	if (session.getAttribute("userId") != null) {
		userId = (String) session.getAttribute("userId");
	}
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
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
						<th style="background-color: #eeeeee; text-align: center; border: 1px solid #dddddd">번호</th>
						<th style="background-color: #eeeeee; text-align: center; border: 1px solid #dddddd">제목</th>
						<th style="background-color: #eeeeee; text-align: center; border: 1px solid #dddddd">작성자</th>
						<th style="background-color: #eeeeee; text-align: center; border: 1px solid #dddddd">작성일</th>
					</tr>
				</thead>
				<tbody>
				<%
					ForumDAO forumDAO = new ForumDAO();
					ArrayList<Forum> list = forumDAO.getList(pageNumber);
					
					for(int i = 0; i < list.size(); i++) {
				%>
					<tr>
						<td><%= list.get(i).getForumId() %></td>
						<td><a href="view.jsp?forumId=<%= list.get(i).getForumId() %>"><%= list.get(i).getForumTitle() %></a></td>
						<td><%= list.get(i).getUserId() %></td>
						<td><%= list.get(i).getForumDate().substring(0, 11) + list.get(i).getForumDate().substring(11, 13) + " 시 " + list.get(i).getForumDate().substring(14, 16) + " 분 " %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<%
				if(pageNumber != 1) {
			%>
				<a href="forum.jsp?pageNumber=<%=pageNumber -1%>" class="btn btn-success btn-arrow-left">이전</a>
			<%		
				} if(forumDAO.nextPage(pageNumber + 1)) {
			%>
				<a href="forum.jsp?pageNumber=<%=pageNumber +1%>" class="btn btn-success btn-arrow-left">다음</a>
			<%		
				}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js">	
	</script>
	<script src="js/bootstrap.js"></script>
</body>
</html>