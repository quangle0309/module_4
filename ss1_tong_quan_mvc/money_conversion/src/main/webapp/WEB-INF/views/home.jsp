<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/14/2024
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="/conversion" method="post" class="w-25 mx-auto mt-5">
    <div class="mb-3">
        <label for="usd" class="form-label">USD</label>
        <input type="text" class="form-control" id="usd" value="${usd}" name="usd" min="1" required>
    </div>
    <div class="mb-3">
        <label for="rate" class="form-label">Tỉ giá</label>
        <input type="number" class="form-control" id="rate" value="${rate}" name="rate" min="0" required>
    </div>
    <div class="mb-3">
        <label for="result" class="form-label">VND</label>
        <input type="number" class="form-control" value="${vndAmount}" id="result" readonly>
    </div>
    <button type="submit" class="btn btn-primary">Chuyển đổi</button>
</form>
</body>
</html>
