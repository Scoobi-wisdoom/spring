<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#cancelBtn").click(function() {
			history.back();
		});
	});
</script>

</head>
<body>
	<div class="container">
		<h2>게시판 글 수정</h2>
		<form method="post">
			<!-- 숨겨서 넘김 데이터: Spring에서 param 데이터를 잡아서 넘겨주는 것 같다. 그러므로 생략하자. -->
<%-- 			<input name="page" type="hidden" value="${param.page }" />
			<input name="perPageNum" type="hidden" value="${param.perPageNum }" />
			<input name="key" type="hidden" value="${param.key }" />
			<input name="word" type="hidden" value="${param.word }" /> --%>
			<table class="table">
				<tr>
					<th>번호</th>
					<td><input name="no" value="${vo.no }" readonly="readonly" class="form-control" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input class="form-control" name="title"
						value="${vo.title }" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="form-control" name="content">${vo.content }</textarea></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input class="form-control" name="writer"
						value="${vo.writer }" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input name="pw" type="password" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn btn-default">수정</button>
						<button class="btn btn-default" type="reset">다시 입력</button>
						<button class="btn btn-default" type="button" id="cancelBtn">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>