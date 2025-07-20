<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Cập nhật phim</h2>
<form action="${pageContext.request.contextPath}/movies/edit/${movie.id}" method="post">
  <input type="hidden" name="id" value="${movie.id}">
  <table>
    <tr>
      <td>Tiêu đề:</td>
      <td><input type="text" name="title" value="${movie.title}" required></td>
    </tr>
    <tr>
      <td>Đạo diễn:</td>
      <td><input type="text" name="director" value="${movie.director}" required></td>
    </tr>
    <tr>
      <td>Thể loại:</td>
      <td><input type="text" name="genre" value="${movie.genre}" required></td>
    </tr>
    <tr>
      <td>Mô tả:</td>
      <td><textarea name="description" rows="3" cols="25">${movie.description}</textarea></td>
    </tr>
    <tr>
      <td>Thời lượng (phút):</td>
      <td><input type="number" name="duration" value="${movie.duration}" required></td>
    </tr>
    <tr>
      <td>Ngôn ngữ:</td>
      <td><input type="text" name="language" value="${movie.language}" required></td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="submit">Cập nhật</button>
        <a href="<c:url value='/movies' />">Hủy</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
