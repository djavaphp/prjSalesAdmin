<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Master</title>
	<link href="<c:url value="/resources/css/sales.css" />" rel="stylesheet" type="text/css" media="screen" />
	
	<script type='text/javascript'>
		
	</script>
</head>
<body>
	<div id="main">
		<div id="header">
			<jsp:include page="../menu/headermenu.jsp" />
		</div>
		<div id="middle">
			<div id="left-column">
				<jsp:include page="../menu/leftmenu.jsp" />
			</div>
			<div id="center-column">
				<div class="table">
					<table align="center">
						<tr>
							<td colspan="2">Company Master</td>
						</tr>
					</table>
					<table width="100%">
						<tr>
							<td>
								<fieldset>
									<legend>Company Master Detail</legend>
									<table align="center">	
									<form:form method="POST"  modelAttribute="areaform">
											<tr>
												<td>Name :</td>
												<td>${compname}</td>
											</tr>
											<tr>
												<td>Address :</td>
												<td>${compadd}</td>
											</tr>
											<tr>
												<td>Phone No :</td>
												<td>${phone}</td>
											</tr>
											<tr>
												<td>Mobile No :</td>
												<td>${mobile}</td>
											</tr>
											</form:form>										
									</table>
								</fieldset>
							</td>
						</tr>						
					</table>
				</div>
			</div>
		</div>
		<div id="footer">
			<jsp:include page="../menu/footer.jsp" />
		</div>
	</div>
</body>
</html>