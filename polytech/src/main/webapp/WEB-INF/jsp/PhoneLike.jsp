<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전화번호 조회결과</title>
</head>
<body>
<f:view>
<button type="button" name=사용자리스트 onclick="location.href='Userlist.html'">사용자 리스트</button><button type="button" name=전화번호리스트 onclick="location.href='Phonelist.html'">전화번호 리스트</button>
<h1 align=center>전화번호 조회결과</h1>

<table cellspacing=1 width=800 border=1 align=center>
	<tr>
		<td width=50><p align=center>전화ID</p></td>
		<td width=50><p align=center>전화번호</p></td>
		<td width=50><p align=center>사용자ID</p></td>
		<td width=50><p align=center>수정/삭제</p></td>			
	</tr>
	<c:choose>
		<c:when test="${empty phone}">
			<tr>
				<td colspan=3>
					<spring:message code="common.listEmpty"/>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<form>
				<c:forEach items="${phone}" var="p">
				<tr>
					<td width=50><p align=center>${p.phoneId}</p></td>
					<td width=50><p align=center>${p.number}</p></td>
					<td width=50><p align=center>${p.user.id}</p></td>
           			<td width=50><p align=center><input type=button value=수정 onclick="location.href='Phoneupdate.html?phoneId=${p.phoneId}'"><input type=button value=삭제 onclick="location.href='Phonedelete.html?phoneId=${p.phoneId}'"></p></td>
           		</tr>
           		</c:forEach>
           		</form>
          </c:otherwise>
         </c:choose>
    </table>
    <form action=PhoneLike.html style="text-align:center">
    <input type=text name=number placeholder="전화번호를 입력하세요">
    <input type=submit value="조회">
    </form>
</body>
</f:view>
</body>
</html>