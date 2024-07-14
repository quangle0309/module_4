<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/14/2024
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển Anh - Việt</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/dictionary" method="post" class="w-25 mx-auto mt-5">
    <div class="mb-3">
        <label for="usd" class="form-label">English</label>
        <input type="text" class="form-control" id="usd" value="${english}" name="english" required>
    </div>

    <div class="mb-3">
        <label for="result" class="form-label">Vietnamese</label>
        <input type="text" class="form-control" value="${result}" id="result" readonly>
    </div>
    <button type="submit" class="btn btn-primary">Tìm kiếm</button>
</form>
</body>
</html>
