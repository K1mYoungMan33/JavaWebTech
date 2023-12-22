<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="one" />
	</div>
	<div>
		<tiles:insertAttribute name="two" />
	</div>
	<div>
		<tiles:insertAttribute name="three" />
	</div>
</body>
</html>