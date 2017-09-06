<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Persons</title>
</head>
<body>
    <h3>Persons</h3>
    <p><a href="person/create">Create Person</a></p>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${persons}" var="person">
            <tr>
                <td><c:out value = "${person.getId()}"/></td>
                <td><c:out value = "${person.getFirstName()}"/></td>
                <td><c:out value = "${person.getLastName()}"/></td>
                <td>
                    <a href="person/update?id=<c:out value = "${person.getId()}"/>">Update</a>
                    <br>
                    <a href="person/delete?id=<c:out value = "${person.getId()}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
