<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.services.ProductService" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.enums.ProductStatus" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/19/2024
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Product</title>
</head>
<body>

<%
    ProductService productService = new ProductService();
    List<Product> products = productService.getAll();
%>

<div class="container">
    <h1 class="text-center mb-2">Product List</h1>
    <a href="Home.jsp" class="btn btn-secondary mb-2">Back to Home</a>

    <a href="Cart.jsp" class="btn btn-dark mb-2">View Cart</a>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Manufacturer</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Status</th>
        </tr>
        <%
            for (Product p  : products) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getDescription() %></td>
            <td><%= p.getManufacturer() %></td>
            <td><%= p.getUnit() %></td>
            <td><%= productService.getPrice(p.getId()) %></td>
            <td><%= p.getStatus()%></td>
            <td> <a href="servlet-controller?action=editProduct&id=<%= p.getId() %>" class="btn btn-primary">Edit</a></td>
            <%
                if(p.getStatus() != ProductStatus.TERMINATED){
            %>
            <td> <a href="servlet-controller?action=deleteProduct&id=<%= p.getId() %>" class="btn btn-danger">Delete</a></td>
            <%
                }
            %>
            <td> <a href="servlet-controller?action=addCart&id=<%= p.getId() %>" class="btn btn-success">Add Cart</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <div>
        <h4 class="text-center">Function</h4>
        <a href="servlet-controller?action=addProduct" class="btn btn-primary">Insert New</a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
