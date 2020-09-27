<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<!--  bootstrap 라이브러리 등록 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

<script type="text/javascript">
	$(function() {
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no;
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>게시판 리스트</h1>
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<tbody>
				<!-- 데이터가 있는 만큼 반복의 시작 : 먼저 위에다 taglib 디렉티브 태그를 이용해서 태그를 등록(JSTL)해서 반복문 처리를 한다. -->
				<c:forEach items="${list }" var="vo">
					<tr class="dataRow">
						<td class="no">${vo.no }</td>
						<td>${vo.title }</td>
						<td>${vo.writer }</td>
						<td>${vo.writeDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
				<c:if test="${pageObject.totalRow > pageObject.perPageNum }">
					<tr>
						<td>
						<pageNav:pageNav endPage="${pageObject.endPage }"
								totalPage="${pageObject.totalPage }"
								startddPage="${pageObject.startPage }" />
						</td>
					</tr>
				</c:if>
				<!-- 데이터가 있는 만큼 반복의 끝 -->
			</tbody>
			<tr>
				<td colspan="5"><a href="write.do"><button>글쓰기</button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>