<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
    <form:form method="post" action="/book/new" modelAttribute="book">
        <p>
            <form:label path="title">Title</form:label>
            <form:input path="title"/>
            <form:errors path="title" cssClass="error"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:input path="rating"/>
            <form:errors path="rating" cssClass="error"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:input path="description"/>
            <form:errors path="description" cssClass="error"/>
        </p>
        <p>
            <form:label path="pages">Pages</form:label>
            <form:input path="pages"/>
            <form:errors path="pages" cssClass="error"/>
        </p>
        <p>
            <form:label path="publisher">Publisher</form:label>
            <form:select itemValue="id" itemLabel="name" path="publisher" items="${publishers}" />
            <form:errors path="publisher" cssClass="error"/>
        </p>
        <p>
            <form:label path="authors">Authors</form:label>
            <form:select itemValue="id" itemLabel="name" path="authors" items="${authors}" multiple="true" />
            <form:errors path="authors" cssClass="error"/>
        </p>
        <p>
            <form:label path="category">Category</form:label>
            <form:select itemValue="id" itemLabel="name" path="category" items="${categories}"/>
            <form:errors path="category" cssClass="error"/>
        </p>
        <p>
            <a href="/book/list">Cancel</a>
            <input type="submit" value="Add">
        </p>
    </form:form>
</body>
</html>
