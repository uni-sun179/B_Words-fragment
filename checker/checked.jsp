<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${message != null }">
<p class="message">${message }</p>
</c:if>

<form action="Check.action" method="post">
<p><input type="text" name="postText"><input type="submit" value="チェック"></p>
</form> 

<hr>
<table>
<tr>
<td>番号</td>
<td>テキスト</td>
<td>アウト？</td>
</tr>
<c:forEach var="post" items="${list }">
<tr>
<td>${post.id }</td>
<td>${post.postText }</td>
<td>${post.isContains? 'Yes':'No'}</td>
</tr>
</c:forEach>
</table>
<%@include file="../footer.jsp" %>