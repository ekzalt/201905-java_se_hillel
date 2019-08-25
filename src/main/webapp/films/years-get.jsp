<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Video Library - Find films between years</title>
</head>

<body>
  <section>
    <h2>Find films between years</h2>
    <p>Enter years, for example: 2008, 2018</p>
    <form action="years" method="post">
      <input type="number" name="from" id="from" placeholder="2008" value="0">
      <input type="number" name="to" id="to" placeholder="2018" value="0">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>