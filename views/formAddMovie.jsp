<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm phim mới</h2>
<form action="<c:url value='/movies/add' />" method="post">
    <table>
        <tr>
            <td>Tiêu đề:</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td>Đạo diễn:</td>
            <td><input type="text" name="director" required></td>
        </tr>
        <tr>
            <td>Thể loại:</td>
            <td><input type="text" name="genre" required></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><textarea name="description" rows="3" cols="25"></textarea></td>
        </tr>
        <tr>
            <td>Thời lượng (phút):</td>
            <td><input type="number" name="duration" required></td>
        </tr>
        <tr>
            <td>Ngôn ngữ:</td>
            <td><input type="text" name="language" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Lưu</button>
                <a href="<c:url value='/movies' />">Hủy</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
