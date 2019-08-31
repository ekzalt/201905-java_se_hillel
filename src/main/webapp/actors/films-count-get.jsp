<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Find actors who has films count</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Find actors who has films count</h2>
    <p>Enter number of films, for example: 2</p>
    <form action="films-count" method="post">
      <input type="number" name="count" id="count" placeholder="2" value="0">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>