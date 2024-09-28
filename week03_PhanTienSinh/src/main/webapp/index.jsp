<%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/21/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="img_path" placeholder="img path">
    <input type="submit" value="Submit">
    <input type="reset" value="Rest">
</form>
</body>
</html>
