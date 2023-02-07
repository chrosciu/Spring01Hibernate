<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
    <form:form method="post" action="/book/save" modelAttribute="book">
        <p>
            <form:label path="title">Title</form:label>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:input path="rating"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:input path="description"/>
        </p>
        <p>
            <form:label path="rating">Publisher</form:label>
            <form:select itemValue="id" itemLabel="name" path="publisher" items="${publishers}" />
        </p>
        <p>
            <input type="submit">
        </p>
    </form:form>
</body>
</html>
