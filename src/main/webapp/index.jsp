<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="localization.text" />

<!DOCTYPE html>
<html lang="${language}">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title><fmt:message key="index.title" /></title>
</head>

<body>
  <c:import url="/jspf/menu.jspf"></c:import>
  <h1><fmt:message key="index.h1" /></h1>

  <section>
    <h2><fmt:message key="index.h2.sort" /></h2>
    <p><fmt:message key="index.p.sort" /></p>
    <form action="numbers" method="post">
      <input type="text" name="numbers" id="numbers" placeholder="1,3,2">
      <input type="submit" value="submit">
    </form>
  </section>

  <section>
    <h2><fmt:message key="index.h2.word" /></h2>
    <p><fmt:message key="index.p.word" /></p>
    <form action="word" method="post">
      <input type="text" name="word" id="word" placeholder="hello">
      <input type="submit" value="submit">
    </form>
  </section>
</body>

</html>