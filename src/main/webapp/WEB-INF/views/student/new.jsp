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
            <label for="male">Male</label>
            <form:radiobutton id="male" path="gender" value="M"/>
            <label for="female">Female</label>
            <form:radiobutton id="female" path="gender" value="F"/>
        </p>
        <p>
            <label for="notes">Notes</label>
            <form:textarea path="notes" rows="3" cols="20"/>
        </p>
        <p>
            <label for="mailingList">Mailing list</label>
            <form:checkbox id="mailingList" path="mailingList"/>
        </p>
        <p>
            <label for="country">Country</label>
            <form:select path="country" items="${countries}" />
        </p>
        <p>
            <label for="programmingSkills">Programming skills</label>
            <form:select path="programmingSkills" items="${programmingSkills}" multiple="true" />
        </p>
        <p>
            <input type="submit">
        </p>
    </form:form>
</body>
</html>
