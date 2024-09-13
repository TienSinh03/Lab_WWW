<%@ page import="vn.edu.iuh.fit.week01_lab.repositories.AccountRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week01_lab.entities.Account" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2024
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Dashboard</title>
</head>
<body>
<%
    AccountRepository account = new AccountRepository();
    List<Account> accounts = account.findAll();
%>
<div class="container">
    <h1 class="text-center">Account List</h1>
    <a href="controller-servlet?action=add">Add New</a>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Status</th>
        </tr>
        <%
            for (Account acc : accounts) {
        %>
        <tr>
            <td><%=acc.getAccount_id() %>
            </td>
            <td><%=acc.getFull_name() %>
            </td>
            <td><%=acc.getPassword() %>
            </td>
            <td><%=acc.getPhone() %>
            </td>
            <td><%=acc.getEmail() %>
            </td>
            <td><%=acc.getStatus() %>
            </td>
            <td><a href="controller-servlet?action=edit&id=<%=acc.getAccount_id()%>">Edit</a></td>
            <td><a href="controller-servlet?action=delete&id=<%=acc.getAccount_id()%>">Delete</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">

</script>
</body>
</html>
