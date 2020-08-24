<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id="center">
	<h1>User Detail Page</h1>
	<h2>${shopdetail.id }</h2>
	<h2>${shopetail.pwd }</h2>
	<h2>${shopdetail.name }</h2>
	<h3><a href="shopdelete.mc?id=${shopdetail.id }">DELETE</a></h3>
	<h3><a href="shopupdate.mc?id=${shopdetail.id }">UPDATE</a></h3>
</div>