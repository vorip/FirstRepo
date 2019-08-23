<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.rt.travel.ChatHtmlSetter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<input type = "text" id = "content">
<input type = "hidden" id = "member" value="최한영_id">
<input type = "hidden" id = "chatRoomNum" value="1">
<button id = "contentSubmit">삔또상함</button>
${getChat}

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type = "text/javascript" src = "resources/js/chat.js"></script>
</body>
</html>