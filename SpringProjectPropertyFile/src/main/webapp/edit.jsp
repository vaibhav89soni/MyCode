<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<body bgcolor="lightblue">
	<center>
		<br /> <br /> <br /> <br /> <br />
		<c:choose>
			<c:when test="${student ne null }">
				<form method='post' action='./controller/update'>
					<table>
						<tr>
							<th>ID</th>
							<td>
								<input type='text' readonly="readonly" name='sid' value='${student.sid}'/>
							</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td>
								<input type='text' name='sname' value='${student.sname }'/>
							</td>
						</tr>
						<tr>
							<th>AGE</th>
							<td>
								<input type='text' name='sage' value='${student.sage }'/>
							</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td>
								<input type='text' name='saddr' value='${student.saddr }'/>
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<input type='submit' value='update'/>
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:when test="${student eq null }">
				<h1 style='color: red; text-align: center;'>RECORD NOT
					AVAILABLE FOR THE GIVEN ID</h1>
			</c:when>
		</c:choose>
	</center>
</body>
</html>