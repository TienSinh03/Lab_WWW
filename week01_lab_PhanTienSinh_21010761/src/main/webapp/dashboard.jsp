<%@ page import="vn.edu.iuh.fit.week01_lab.repositories.AccountRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week01_lab.entities.Account" %>
<%@ page import="vn.edu.iuh.fit.week01_lab.services.AccountServices" %>
<%@ page import="vn.edu.iuh.fit.week01_lab.services.RoleServices" %>
<%@ page import="vn.edu.iuh.fit.week01_lab.entities.Role" %>
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
    AccountServices accountServices = new AccountServices();
    RoleServices roleServices = new RoleServices();
    List<Role> roles = roleServices.findAllRoles();

    List<Account> accounts = session.getAttribute("accounts") == null ? accountServices.getAllInforAccount() : (List<Account>) session.getAttribute("accounts");
    Account account = (Account) request.getServletContext().getAttribute("account");
%>
<div class="container">
    <div class="header mb-3">
        <h5 class="text-end">Username currently logged in: <%=account.getFull_name()%> </h5>
        <div class="d-flex justify-content-start">
            <a href="controller-servlet?action=logout">Logout</a>
        </div>
    </div>

    <div class="account-management">
        <h1 class="text-center">Account Management</h1>
        <div class="search-account">
            <form action="controller-servlet" method="get">
                <input type="hidden" name="action" value="searchAccountByRole">
                <div class="form-group">
                    <label for="selectRole">Search Account By Role: </label>
                    <select class="form-control row-2" id="selectRole" name="selectRoleId" onchange="submitForm()">
                        <option value="">Choose Role</option>
                        <option value="0">All</option>
                        <%
                            for (Role role : roles) {
                        %>
                        <option value="<%=role.getRole_id()%>"><%=role.getRole_id()%> </option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </form>
        </div>
        <a href="controller-servlet?action=add">Insert</a>
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Status</th>
                <th>Role</th>
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
                <td><%=roleServices.getRoleByIdAccount(acc.getAccount_id()) !=null ? roleServices.getRoleByIdAccount(acc.getAccount_id()).getRole_name() : ""%>
                </td>
                <td><a href="controller-servlet?action=edit&id=<%=acc.getAccount_id()%>">Edit</a></td>
                <td><a href="controller-servlet?action=delete&id=<%=acc.getAccount_id()%>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
<script>
    function submitForm() {
        const selectElement = document.getElementById('selectRole');
        if (selectElement.value !== "") {
            selectElement.form.submit();
        } else {
            // If you want to also submit the form for the empty value, you can call submit here
            selectElement.form.submit();
        }
    }
</script>
</body>
</html>
