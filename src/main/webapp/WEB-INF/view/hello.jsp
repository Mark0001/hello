<%@ include file="/WEB-INF/view/include/incluseTag.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/navBar.jsp"%>
	<div class="container mainBlock">
		<div class="row">
			<h1>hello ${message}</h1>
		</div>
	</div>

</body>
</html>