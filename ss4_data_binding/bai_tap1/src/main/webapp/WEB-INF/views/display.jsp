<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/16/2024
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>Settings</h2>
<form:form action="settings" modelAttribute="emailSetting">
    <label for="language">Ngôn ngữ:</label>
    <form:select path="language">
        <form:option value="English" label="English"/>
        <form:option value="Vietnamese" label="Vietnamese"/>
        <form:option value="Japanese" label="Japanese"/>
        <form:option value="Chinese" label="Chinese"/>
    </form:select>
    <br/><br/>

    <label for="pageSize">Kích thước trang:</label>
    <form:select path="pageSize">
        <form:option value="5" label="5"/>
        <form:option value="10" label="10"/>
        <form:option value="15" label="15"/>
        <form:option value="25" label="25"/>
        <form:option value="50" label="50"/>
        <form:option value="100" label="100"/>
    </form:select>
    <br/><br/>

    <label for="enableSpamFilter">Bộ lọc thư rác:</label>
    <form:checkbox path="enableSpamFilter" />
    <br/><br/>

    <label for="signature">Chữ ký:</label>
    <form:textarea path="signature" rows="4" cols="50"/>
    <br/><br/>

    <button type="submit">Cập nhật</button>
</form:form>
<p>${message}</p>
</body>
</html>
