<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Login</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>
  <h1>Login page</h1>

  <section>
    <h2>Login form</h2>
    <p>Enter name and password to login</p>
    <form action="/login" method="post">
      <input type="text" name="name" id="name" placeholder="name">
      <input type="password" name="password" id="password" placeholder="password">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>