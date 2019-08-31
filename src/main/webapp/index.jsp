<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Main</title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>
  <h1>Video Library</h1>

  <section>
    <h2>Sort Numbers</h2>
    <p>Enter unsorted integers, for example: 1,3,2</p>
    <form action="numbers" method="post">
      <input type="text" name="numbers" id="numbers" placeholder="1,3,2">
      <input type="submit" value="submit">
    </form>
  </section>

  <section>
    <h2>Find word</h2>
    <p>Enter word to find, for example: hello</p>
    <form action="word" method="post">
      <input type="text" name="word" id="word" placeholder="hello">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>