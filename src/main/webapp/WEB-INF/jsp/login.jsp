<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form:form id="login" action="login" method="POST" commandName="loginform"
		>
		<table align="center">
			<tr>
				<td colspan="3"><h3> Login</h3></td>
			</tr>
			<tr>
				<td><form:label path="empCode"> Employee Code :</form:label></td>
				<td><form:input path="empCode"></form:input></td>
				<td><font color="red"><form:errors path="empCode"></form:errors></font></td>
			</tr>
			<tr>
				<td><form:label path="password">Password :</form:label></td>
				<td><form:input path="password" type="password"></form:input></td>
				<td><font color="red"><form:errors path="password"></form:errors></font></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><font color="red"><form:errors /></font></td>
			</tr>
		</table>
	</form:form>
</body>
</html>