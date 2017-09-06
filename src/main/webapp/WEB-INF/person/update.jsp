<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Person</title>
</head>
<body>
    <h3>Update Person</h3>
    <form action="" method="post">
        <label for="firstName">First Name</label>
        <br>
        <input id="firstName" type="text" name="firstName" value="${person.getFirstName()}">
        <br><br>
        <label for="lastName">Last Name</label>
        <br>
        <input id="lastName" name="lastName" value="${person.getLastName()}">
        <br><br>
        <input type="submit">
    </form>
</body>
</html>
