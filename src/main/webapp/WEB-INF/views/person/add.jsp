<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <c:forEach items="${languages}" var="lang">--%>
<%--        ${lang}<br>--%>
<%--    </c:forEach>--%>
    <form:form method="post" modelAttribute="person">
        <label for="login">Login</label>
        <form:input path="login"/>
        <label for="password">Password</label>
        <form:password path="password"/>
        <label for="email">Email</label>
        <form:input path="email"/>
        <label for="language">Language</label>
        <form:select path="language" items="${languages}" />
        <label for="vip">VIP</label>
        <form:checkbox id="vip" path="vip"/>
        <label for="m">Male</label>
        <form:radiobutton id="m" path="sex" value="M"/>
        <label for="f">Female</label>
        <form:radiobutton id="f" path="sex" value="F"/>
        <input type="submit">
    </form:form>
</body>
</html>
