<%@page import="com.sales.wb.service.PaymentModeVo"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Mode Detail</title>
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
							<td colspan="2">Payment Mode Detail</td>
						</tr>
					</table>
					<table width="100%">
						<tr>
							<td>
								<fieldset>
									<legend>Payment Mode Type Detail</legend>
									<table align="center" border="3" width="40%">										
									<form:form method="POST"  >
									<c:forEach var="listVar" items="${paymenttype}"> 
									<tr>																				
										<td align="center">${listVar.getPaymentModeName()}</td>
									</tr>
   								 		
									</c:forEach>
												
											
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