<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/15/2024
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="calculator" method="post" class="w-50 mx-auto mt-5">
    <div class="row">
        <div class="mb-3 col-6">
            <label for="firstNumber" class="form-label">First Number</label>
            <input type="text" class="form-control" id="firstNumber" name="firstNumber" required>
        </div>
        <div class="mb-3 col-6">
            <label for="lastNumber" class="form-label">Last Number</label>
            <input type="text" class="form-control" id="lastNumber" name="lastNumber" required>
        </div>
    </div>
    <div class="mb-3">
        <label for="result" class="form-label">Result</label>
        <input type="text" class="form-control" id="result" readonly value="${result}">
    </div>

    <div class="d-flex justify-content-between w-75 mx-auto mt-4">
        <button name="operator" value="+" type="submit" class="btn btn-primary">Addition (+)</button>
        <button name="operator" value="-" type="submit" class="btn btn-danger">Subtraction (-)</button>
        <button name="operator" value="*" type="submit" class="btn btn-success">Multiplication (X)</button>
        <button name="operator" value="/" type="submit" class="btn btn-warning">Division (/)</button>
    </div>
    <p class="text-center text-danger mt-3">${message}</p>
    <p class="text-center text-danger">${error}</p>
</form>

</body>
</html>
