<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/15/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Condiments</title>
</head>
<body>
    <h1>Gia vị của bạn là:</h1>
    <ul>
        <c:forEach var="condiment" items="${condiments}">
            <li>${condiment}</li>
        </c:forEach>
    </ul>
</body>
</html>
