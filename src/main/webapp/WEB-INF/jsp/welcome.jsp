<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link href="<c:url value="/resources/css/sales.css" />" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>
	<div id="main">
		<div id="header">
			<jsp:include page="../jsp/menu/headermenu.jsp" />
		</div>
	
	<div id="middle">
		<div id="left-column">
			<jsp:include page="../jsp/menu/leftmenu.jsp" />
		</div>
		<div id="center-column">
			<div class="table">
				<table align="center">
					<tr>
						<td>
							Welcome  <%=session.getAttribute("usename")%>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="../jsp/menu/footer.jsp" />
	</div>
	</div>
</body>
</html>