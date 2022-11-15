<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%
	pageContext.setAttribute("base", request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/");
	pageContext.setAttribute("contextPath", request.getContextPath());%>

<!DOCTYPE html>
<html lang="cn">
<head>
	<title>主窗口</title>
	<meta charset="UTF-8">
	<link href="${contextPath}/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${contextPath}/jquery/jquery-1.11.1-min.js"></script>
	<script type="text/javascript" src="${contextPath}/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<img src="${contextPath}/image/home.png" style="position: relative;top: -10px; left: -10px;" alt="pic"/>
</body>
</html>