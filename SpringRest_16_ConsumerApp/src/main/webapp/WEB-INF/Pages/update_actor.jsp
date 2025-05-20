<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:center">Register From Page</h1>

<frm:form action="actor_edit" modelAttribute="artist" method="POST">

<table bgcolor="cyan" align="center">

<tr>
<td>actor Id :: </td>
<td><frm:input path="actorId" readonly="true"/></td>
</tr>


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
<td colspan="2"><input type="submit" value="update Actor"></td>
</tr>
</table>
</frm:form>