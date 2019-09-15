<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Films</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Films</h2>
    <table>
      <thead>
        <tr>
          <td>id</td>
          <td>name</td>
          <td>country</td>
          <td>released</td>
        </tr>
      </thead>

      <tbody>
        <c:forEach var="film" items="${films}">
          <tr>
            <td><c:out value="${film.id}" /></td>
            <td><c:out value="${film.name}" /></td>
            <td><c:out value="${film.country}" /></td>
            <td><c:out value="${film.released}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </section>
</body>

</html>