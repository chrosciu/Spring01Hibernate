<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        <label for="login">Login</label>
        <form:input path="login"/>
        <label for="password">Password</label>
        <form:input path="password"/>
        <label for="email">Email</label>
        <form:input path="email"/>
        <input type="submit">
    </form:form>
</body>
</html>
