<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form method="post" action="/login">
    Tên đăng nhập: <input type="text" name="username"> <br>
    Mật khẩu: <input type="password" name="password"> <br>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty(error)}">
    <p style="color: red">${error}</p>
</c:if>
</body>
</html>
