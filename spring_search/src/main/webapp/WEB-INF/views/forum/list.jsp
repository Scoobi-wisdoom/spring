<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	.dataRow:hover {
		background: #ddd;
		cursor: pointer;
	}
</style>

<script type="text/javascript">
	$(function(){
		$(".dataRow").click(function(){
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no + "&inc=1";
			});
		});
</script>

</head>
<body>
	<div class="container">
		<h2>게시판 리스트</h2>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:if test="${empty list }">
				<tr>
					<td colspan="5">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:if test="${! empty list }">
			<!-- list는 request에 담긴 것을 꺼내온 것이고, vo는 pageObject에 담긴 것을 꺼내 온 것이다.-->
				<c:forEach items="${list }" var="vo">
					<tr class="dataRow">
						<td class="no">${vo.no }</td>
						<td>${vo.title }</td>
						<td>${vo.writer }</td>
						<td><fmt:formatDate value="${vo.writeDate }"
								pattern="yyyy.MM.dd" /></td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="5">
					<pageObject:pageNav pageObject="${pageObject }" listURI="list.do" />
				</td>
			</tr>
			<tr>
				<td colspan="5"><a href="write.do" class="btn btn-default">글쓰기</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>