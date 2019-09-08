<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>Samples : ${samples } <br /><!-- el 언어를 통해서 samples를 부름-->
Sample.name : ${sample.name } <br /><!-- el 언어를 통해서 sample에서의 name을 부름-->
findSampleByName : ${findSampleByName} <br /><!-- el 언어를 통해서 findsamplebyname 값을 부름-->
<!--해당 부분이 곧 view이다.-->
</body>
</html>