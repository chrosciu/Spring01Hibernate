<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
    <form:form method="post" modelAttribute="student">
        <p>
            <label for="firstName">First name</label>
            <form:input path="firstName"/>
        </p>
        <p>
            <label for="lastName">Last name</label>
            <form:input path="lastName"/>
        </p>
        <p>
            <input type="submit">
        </p>
    </form:form>
</body>
</html>
