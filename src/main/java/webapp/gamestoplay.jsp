<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "navigationServlet" >
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.title}</td>
<td>${currentitem.genre}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem" class="btn btn-warning">
<input type = "submit" value = "delete" name="doThisToItem" class="btn btn-danger">
<input type="submit" value = "add" name = "doThisToItem" class="btn btn-success">

</form>
</body>
</html>