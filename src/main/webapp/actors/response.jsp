<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
Core Tags
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Formatting Tags
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

SQL Tags
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

XML Tags
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

Function Tags
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
-->

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Actors</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Actors</h2>
    <table>
      <thead>
        <tr>
          <td>id</td>
          <td>name</td>
          <td>born</td>
        </tr>
      </thead>

      <tbody>
        <c:forEach var="actor" items="${actors}">
          <tr>
            <td><c:out value="${actor.id}" /></td>
            <td><c:out value="${actor.name}" /></td>
            <td><c:out value="${actor.born}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </section>
</body>

</html>