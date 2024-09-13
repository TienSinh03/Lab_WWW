<%@ page import="vn.edu.iuh.fit.week01_lab.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/13/2024
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Add Account</title>
</head>
<body>
<%
    String action = request.getParameter("action");
    Object obj = session.getAttribute("account");
    Account account = (Account) obj;
    String account_id = account.getAccount_id() == null ? "" : account.getAccount_id();
    String full_name = account.getFull_name() == null ? "" : account.getFull_name();
    String password = account.getPassword() == null ? "" : account.getPassword();
    String phone = account.getPhone() == null ? "" : account.getPhone();
    String email = account.getEmail() == null ? "" : account.getEmail();
    String status = account.getStatus() == 0 ? "1" : String.valueOf(account.getStatus());
%>

<div class="container">
    <h1 class="text-center">Form Account</h1>
    <form action="controller-servlet" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mb-2">
            <label for="account_id" class="form-label">Id</label>
            <input type="text" class="form-control" id="account_id" name="account_id" value="<%=account_id%>" required>
        </div>
        <div class="mb-2">
            <label for="full_name" class="form-label">FullName</label>
            <input type="text" class="form-control" id="full_name" name="full_name" value="<%=full_name%>" required>
        </div>
        <div class="mb-2">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="<%=password%>" required>
        </div>
        <div class="mb-2">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" value="<%=phone%>" required>
        </div>
        <div class="mb-2">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="<%=email%>" required>
        </div>
        <div class="mb-2">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" id="status" name="status">
                <option value="1" <%=status.equals("1") ? "selected" : ""%>>Active</option>
                <option value="0" <%=status.equals("0") ? "selected" : ""%>>Inactive</option>
                <option value="-1" <%=status.equals("-1") ? "selected" : ""%>>Delete</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
        <a href="dashboard.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
<script>
    <%
    String errorMessage = (String) request.getAttribute("error");
    if (errorMessage != null) { %>
    alert("<%= errorMessage %>");
    <% } %>
</script>

</body>
</html>
