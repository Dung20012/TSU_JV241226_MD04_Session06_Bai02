<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách phim</h2>
<a href="<c:url value='/movies/add' />">Thêm phim mới</a>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Thể loại</th>
        <th>Thời lượng</th>
        <th>Ngôn ngữ</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.genre}</td>
            <td>${movie.duration} phút</td>
            <td>${movie.language}</td>
            <td>
                <a href="movies/update?id=${movie.id}">Sửa</a> |
                <a href="movies/delete?id=${movie.id}" onclick="return confirm('Bạn có chắc muốn xóa phim này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
