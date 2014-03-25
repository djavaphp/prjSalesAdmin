<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Master</title>
</head>
<body>

	<table>
		<form:form method="POST" action="createarea" >
			<tr>			
				<td><form:label path="areaCode"> Area Code :</form:label></td>
				<td><form:input path="areaCode" /></td>
			</tr>
			<tr>
				<td><form:label path="areaName"> Area Name :</form:label></td>
				<td><form:input path="areaName" /></td>				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Area" /></td>
			</tr>
		</form:form>
	</table>

</body>
</html>