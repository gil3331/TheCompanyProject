<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규 사용자 작성</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script>
function check_key() {
	var char_ASCII = event.keyCode;
	//숫자
	if (char_ASCII >= 48 && char_ASCII <= 57)
		return 1;
	//영어
	else if ((char_ASCII >= 65 && char_ASCII <= 90)
			|| (char_ASCII >= 97 && char_ASCII <= 122))
		return 2;
	//특수기호 및 공백
	else if ((char_ASCII >= 32 && char_ASCII <= 48)
			|| (char_ASCII >= 58 && char_ASCII <= 64)
			|| (char_ASCII >= 91 && char_ASCII <= 96)
			|| (char_ASCII >= 123 && char_ASCII <= 127))
		return 4;
	//한글
	else if ((char_ASCII >= 12592) || (char_ASCII <= 12687))
		return 3;
	
	else
		return 0;
}

function nonHangulSpecialKey() {
	if (check_key() != 3) {
		event.returnValue = false;
		alert("한글만 입력하세요!");
		return;
	}
}
</script>
</head>
<body>
<f:view>
<h1 align=center>신규 사용자 작성</h1>
<form action=Userinsert.html>
<table cellspacing=1 width=600 border=1 align=center>
	<c:forEach items="${currentDate}" var="date">
	<tr>
		<td width=50>ID<input type=text name=ID placeholder="자동부여"></td><tr>
		<td width=50>이름<input type=text name=name onKeyPress="nonHangulSpecialKey()"></td><tr>
		<td width=50>부서<input type=text name=department></td><tr>
		<td width=50>등록일<input type=text id="currentDate" name=registDate value="${date}"></td><tr>
	</tr>
	</c:forEach>
    </table>
    <input class="btn btn-primary" type=submit value=저장>
    <input class="btn btn-danger" type="button" value="취소" onclick="location.href='javascript:history.back()'">
</form>

</body>

</f:view>
</body>
</html>