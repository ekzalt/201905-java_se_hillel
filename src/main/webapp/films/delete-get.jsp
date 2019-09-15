<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Delete films</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Delete films older than entered years</h2>
    <p>Enter years, for example: 10</p>
    <form action="delete" method="post">
      <input type="number" name="year" id="year" placeholder="2000" value="2000">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>