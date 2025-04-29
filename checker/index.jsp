<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>

<p class="message">チェックしたいワードを入力してください</p>

<form action="Check.action" method="post">
<p><input type="text" name="postText"><input type="submit" value="チェック"></p>
</form> 

<%@include file="../footer.jsp" %>