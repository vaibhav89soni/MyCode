<%@ page session = "true" %>
<%
	session.setAttribute("Name","iNeuron");
	session.setAttribute("Java","NavinReddy");
%>
<h1>The name of the company  is :: <%= session.getAttribute("Name") %></h1><br/>
<h1>The trainer name of java is :: <%= session.getAttribute("Java") %></h1>


