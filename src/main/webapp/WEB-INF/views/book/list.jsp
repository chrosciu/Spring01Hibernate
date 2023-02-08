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
                <th>Pages</th>
                <th>Publisher</th>
                <th>Authors</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
        </thead>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.rating}"/></td>
                <td><c:out value="${book.pages}"/></td>
                <td><c:out value="${book.publisher.name}"/></td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        <c:out value="${author.name}"/>
                    </c:forEach>
                </td>
                <td><c:out value="${book.category.name}"/></td>
                <td>
                    <a href="/book/edit/${book.id}">Edit</a>
                    <a href="/book/delete/${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/book/new">Add new book</a>
</body>
</html>
