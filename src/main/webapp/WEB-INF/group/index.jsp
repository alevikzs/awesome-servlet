<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>
    <h3>Groups</h3>
    <p><a href="group/create">Create Group</a></p>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td><c:out value = "${group.getId()}"/></td>
                    <td><c:out value = "${group.getName()}"/></td>
                    <td><c:out value = "${group.getDescription()}"/></td>
                    <td>
                        <a href="group/update?id=<c:out value = "${group.getId()}"/>">Update</a>
                        <br>
                        <a href="group/delete?id=<c:out value = "${group.getId()}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
