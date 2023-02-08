<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete book</title>
</head>
<body>
    <form:form method="post" action="/book/delete/${id}">
        <a href="/book/list">Cancel</a>
        <input type="submit" value="Delete">
    </form:form>
</body>
</html>
