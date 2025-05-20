<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="color:red;text-align:center">Actor Information Report</h1>

<c:choose>
  <c:when test="${!empty actorInfo}">
    <table border="1" align="center">
      <tr bgcolor="green">
        <th>Actor id</th>
        <th>Actor Name</th>
        <th>Category</th>
        <th>Mobile No</th>
        <th>Operations</th>
      </tr>
      <c:forEach var="artist" items="${actorInfo}">
        <tr>
          <td>${artist.actorId}</td>
          <td>${artist.actorName}</td>
          <td>${artist.category}</td>
          <td>${artist.moblieNo}</td>
          <td>
          <a href="actor_edit?aid=${artist.actorId}"><b>edit</b><img src="images/edit.png" width=30px height=30px></a>
          <a href="actor_delete?aid=${artist.actorId }"onclick="return confirm('do u want to delete?')"><b>delete</b><img src="images/delete.jpeg" width=30px height=30px></a>
          </td>
        </tr>
      </c:forEach>
    </table>
    <h1 style="color:green;text-align:center">${resultMsg}</h1>
    <center><a href="actor_add"><b>Register</b><img src="images/add.png" width=30px height=30px></a></center>
    <center><a href="./"><b>Home</b><img src="images/home.jpeg" width=30px height=30px></a></center>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Actor not found</h1>
  </c:otherwise>
</c:choose>
