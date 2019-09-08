<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 리스트</title>
</head>
<body>
<f:view>
<h1 align=center>사용자 리스트</h1>
<table cellspacing=1 width=600 border=1 align=center>
	<tr>
		<td width=50><p align=center>ID</p></td>
		<td width=50><p align=center>이름</p></td>
		<td width=50><p align=center>전화번호</p></td>		
	</tr>
	<c:choose>
		<c:when test="${empty users}">
			<tr>
				<td colspan=3>
					<spring:message code="common.listEmpty"/>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${users}" var="e">
				<tr>
           	 		<td width=50><p align=center>${e.id}</p></td>
           			<td width=50><p align=center>${e.name}</p></td>
           			<td width=50><p align=center>${e.number}</p></td>
           		</tr>
           		</c:forEach>
          </c:otherwise>
         </c:choose>
    </table>
    <form action=newUser align=center>
    <input type=button value="사용자 추가">
    </form>
</body>
</f:view>
</body>
</html>