<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="forum.ForumDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="forum" class="forum.Forum" scope="page" />
<jsp:setProperty name="forum" property="forumTitle" />
<jsp:setProperty name="forum" property="forumContent" />
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
	} else {
		if (forum.getForumTitle() == null || forum.getForumContent() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('누락된 부분이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			ForumDAO forumDAO = new ForumDAO();
			int result = forumDAO.write(forum.getForumTitle(), userId, forum.getForumContent());
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글 쓰기에 실패했습니다.')");
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