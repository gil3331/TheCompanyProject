<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전화번호 리스트</title>
</head>
<body>
<f:view>
<h1 align=center>전화번호 리스트</h1>
<form method="post" action=PhoneupdateDB.html>
<table cellspacing=1 width=600 border=1 align=center>
	<tr>
		<td width=50><p align=center>전화ID</p></td>
		<td width=50><p align=center>전화번호</p></td>
		<td width=50><p align=center>사용자ID</p></td>
					
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
				<c:forEach items="${phone}" var="p">
				<tr>
           	 		<td width=50><p align=center><input type=text name=PhoneId value="${p.phoneId}" ></p></td>
           			<td width=50><p align=center><input type=text name=number value="${p.number}"></p></td>
           			<td width=50><p align=center><input type=text name=user.id value="${p.user.id}"></p></td>
        
           		</tr>
           		</c:forEach>
          </c:otherwise>
         </c:choose>
    </table>
    
    
    <input type=submit value="전화번호 수정">
    </form>
</body>
</f:view>
</body>
</html>