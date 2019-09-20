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
<form method="post" action=UserupdateDB.html>
<table cellspacing=1 width=600 border=1 align=center>
	<tr>
		<td width=50><p align=center>ID</p></td>
		<td width=50><p align=center>이름</p></td>
		<td width=50><p align=center>부서</p></td>
		<td width=50><p align=center>등록일</p></td>
					
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
				<c:forEach items="${user}" var="e">
				<tr>
           	 		<td width=50><p align=center><input type=text name=id value="${e.id}" ></p></td>
           			<td width=50><p align=center><input type=text name=name value="${e.name}"></p></td>
           			<td width=50><p align=center><input type=text name=department value="${e.department}"></p></td>
        			<td width=50><p align=center><input type=text name=registDate value="${e.registDate}"></p></td>
           		</tr>
           		</c:forEach>
          </c:otherwise>
         </c:choose>
    </table>
    
    
    <input type=submit value="사용자 수정">
    </form>
</body>
</f:view>
</body>
</html>