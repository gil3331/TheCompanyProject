<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 조회결과</title>
</head>
<body>
<f:view>
<button type="button" name=사용자리스트 onclick="location.href='Userlist.html'">사용자 리스트</button><button type="button" name=전화번호리스트 onclick="location.href='Phonelist.html'">전화번호 리스트</button>
<h1 align=center>사용자 조회결과</h1>


<form action=newUser.html style="text-align:center">
<input type=submit value="사용자 추가">
</form>
<table cellspacing=1 width=600 border=1 align=center>
	<tr>
		<td width=50><p align=center>ID</p></td>
		<td width=50><p align=center>이름</p></td>
		<td width=50><p align=center>부서</p></td>
		<td width=50><p align=center>등록일</p></td>
		<td width=50><p align=center>수정/삭제</p></td>			
	</tr>
	<c:choose>
		<c:when test="${empty user}">
			<tr>
				<td colspan=3>
					<spring:message code="common.listEmpty"/>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<form>
				<c:forEach items="${user}" var="u">
				<tr>
					<td width=50><p align=center><a href="newPhone.html?user.id=${u.id}">${u.id}</a></p></td>
           			<td width=50><p align=center>${u.name}</p></td>
           			<td width=50><p align=center>${u.department}</p></td>
           			<td width=50><p align=center>${u.registDate}</p></td>
           			<td width=50><p align=center><input type=button value=수정 onclick="location.href='Userupdate.html?id=${u.id}'"><input type=button value=삭제 onclick="location.href='Userdelete.html?id=${u.id}'"></p></td>
           		</tr>
           		</c:forEach>
           		</form>
          </c:otherwise>
         </c:choose>
    </table>
    <form action=UserLike.html style="text-align:center">
    <input type=text name=name placeholder="이름을 입력하세요">
    <input type=submit value="조회">
    </form>
</body>
</f:view>
</body>
</html>