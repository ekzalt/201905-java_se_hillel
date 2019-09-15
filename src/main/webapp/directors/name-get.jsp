<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Find director by name</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>

  <section>
    <h2>Find director by name</h2>
    <p>Enter director name, for example: test</p>
    <form action="name" method="post">
      <input type="text" name="name" id="name" placeholder="director name">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>