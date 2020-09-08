<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="forum.ForumDAO"%>
<%@ page import="forum.Forum" %>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		String userId = null;
	if (session.getAttribute("userId") != null) {
		userId = (String) session.getAttribute("userId");
	}
	if (userId == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
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
	if (!userId.equals(forum.getUserId())) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다.')");
		script.println("location.href = 'forum.jsp'");
		script.println("</script>");
	} else {
		if (request.getParameter("forumTitle") == null || request.getParameter("forumContent") == null ||
				request.getParameter("forumTitle").equals("") || request.getParameter("forumContent").equals("")) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('누락된 부분이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			ForumDAO forumDAO = new ForumDAO();
			int result = forumDAO.update(forumId, request.getParameter("forumTitle"), request.getParameter("forumContent"));
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글 수정에 실패했습니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'forum.jsp'");
				script.println("</script>");
			}
		}	
	}
	
	%>

</body>
</html>