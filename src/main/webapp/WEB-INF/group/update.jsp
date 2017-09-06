<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Group</title>
</head>
<body>
    <h3>Update Group</h3>
    <form action="" method="post">
        <label for="name">Name</label>
        <br>
        <input id="name" type="text" name="name" value="${group.getName()}">
        <br><br>
        <label for="description">Description</label>
        <br>
        <textarea name="description" id="description" cols="25" rows="10">${group.getDescription()}</textarea>
        <br><br>
        <input type="submit">
    </form>
</body>
</html>
