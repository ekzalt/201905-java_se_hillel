<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Directors</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Directors</h2>
    <table>
      <thead>
        <tr>
          <td>id</td>
          <td>name</td>
          <td>born</td>
        </tr>
      </thead>

      <tbody>
        <c:forEach var="director" items="${directors}">
          <tr>
            <td><c:out value="${director.id}" /></td>
            <td><c:out value="${director.name}" /></td>
            <td><c:out value="${director.born}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </section>
</body>

</html>