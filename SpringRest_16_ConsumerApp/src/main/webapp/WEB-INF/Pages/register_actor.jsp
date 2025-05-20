<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:center">Register From Page</h1>

<frm:form action="actor_add" modelAttribute="actor" method="POST">

<table bgcolor="cyan" align="center">

<tr>
<td>actor name :: </td>
<td><frm:input path="actorName"/></td>
</tr>

<tr>
<td>category :: </td>
<td><frm:input path="category"/></td>
</tr>

<tr>
<td>Mobile No :: </td>
<td><frm:input path="moblieNo"/></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="register"></td>
</tr>
</table>
</frm:form>