<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Rating</th>
                <th>Publisher</th>
            </tr>
        </thead>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.rating}"/></td>
                <td><c:out value="${book.publisher.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
