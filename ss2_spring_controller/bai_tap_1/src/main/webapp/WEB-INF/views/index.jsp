<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="sandwich" method="post">
  <c:forEach var="condiment" items="${condiments}">
    <input type="checkbox" name="condiments" value="${condiment}" id="${condiment}"> <label for="${condiment}">${condiment}</label>
  </c:forEach>
  <button>Select</button>
  <p>${message}</p>
</form>
</body>
</html>