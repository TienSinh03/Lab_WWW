<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/19/2024
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Form Employee</title>
</head>
<body>
<%
    String action = request.getParameter("action"); // get action from request
    Object employee = session.getAttribute("employee"); // get employee from request
    Employee emp = (Employee) employee;
    long emp_id = emp.getId() == 0 ? 0 : emp.getId();
    String full_name = emp.getFullName() == null ? "" : emp.getFullName();
    String address = emp.getAddress() == null ? "" : emp.getAddress();
    String phone = emp.getPhone() == null ? "" : emp.getPhone();
    String email = emp.getEmail() == null ? "" : emp.getEmail();
    LocalDateTime dob = emp.getDob() == null ? LocalDateTime.now() : emp.getDob();
    int status = emp.getStatus() == null ? 1 : emp.getStatus().getValue();
%>
<div class="container">
    <h1 class="text-center">Form Employee</h1>
    <form action="servlet-controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mt-3">
            <div class="mb-2">
                <label for="emp_id" class="form-label">Id</label>
                <input type="text" class="form-control" id="emp_id" name="emp_id" value="<%=emp_id%>" readonly>
            </div>
            <div class="mb-2">
                <label for="name_emp" class="form-label">Full name</label>
                <input type="text" class="form-control" id="name_emp" name="name_emp" value="<%=full_name%>" required>
            </div>
            <div class="mb-2">
                <label for="dob" class="form-label">Date of birth</label>
                <input type="datetime-local" class="form-control" id="dob" name="dob" value="<%=dob%>" required>
            </div>
            <div class="mb-2">
                <label for="Phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="Phone" name="phone" value="<%=phone%>" required>
            </div>
            <div class="mb-2">
                <label for="email" class="form-label">Id</label>
                <input type="text" class="form-control" id="email" name="email" value="<%=email%>" required>
            </div>
            <div class="mb-2"   >
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" value="<%=address%>" required>
            </div>
            <div class="mb-2">
                <label for="status" class="form-label">status</label>
                <%
                    if(action.equals("edit")) {
                %>
                <select class="form-select" id="status" name="status">
                    <option value="1" <%= status == 1 ? "selected" : ""%>> Active</option>
                    <option value="0" <%= status == 0 ? "selected" : ""%>>Inactive</option>
                    <option value="-1" <%= status == -1 ? "selected" : ""%>>Terminate</option>
                </select>
                <%
                    } else {
                %>
                <select class="form-select" id="status" name="status">
                    <option value="1" <%= status == 1 ? "selected" : ""%>>Active</option>
                    <option value="0" <%= status == 0 ? "selected" : ""%>>Inactive</option>
                </select>
                <%
                    }
                %>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="Employee.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
<%
    String errorMessage = (String) request.getAttribute("error");
    if (errorMessage != null) { %>
        alert("<%= errorMessage %>");
    <% } %>
</body>
</html>
