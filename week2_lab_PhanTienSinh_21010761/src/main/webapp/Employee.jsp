<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.services.EmployeeService" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.models.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.converters.EmployeeStatusConverter" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/19/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Employee</title>
</head>
<body>
<%
    EmployeeService employeeService = new EmployeeService();
    List<Employee> employees = employeeService.findAll();
%>

<div class="container">
    <h1 class="text-center mb-2">Employee List</h1>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Date of birth</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Status</th>
        </tr>
        <%
            for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getFullName() %></td>
            <td><%= employee.getDob() %></td>
            <td><%= employee.getPhone() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getAddress() %></td>
            <td><%= employee.getStatus()%></td>
            <td> <a href="servlet-controller?action=edit&id=<%= employee.getId() %>" class="btn btn-primary">Edit</a></td>
            <%
                if(employee.getStatus() != EmployeeStatus.TERMINATED){
            %>
            <td> <a href="servlet-controller?action=delete&id=<%= employee.getId() %>" class="btn btn-danger">Delete</a></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>
    <div>
        <h4 class="text-center">Function</h4>
        <a href="servlet-controller?action=add" class="btn btn-primary">Insert New</a>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
