<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.services.ProductService" %>
<%@ page import="java.util.Map" %>
<%@ page import="vn.edu.iuh.fit.week2_phantiensinh.models.Product" %><%--
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
    <title>Cart</title>
</head>
<body>
<%
    ProductService productService = new ProductService();
    Map<Product, Integer> cart = productService.getCarts();
%>

<div class="container">
    <%
        if (cart.isEmpty()) {
    %>
        <h1 class="text-center">Cart is empty</h1>
    <%
        } else {
    %>
        <h1 class="text-center">Cart</h1>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Manufacturer</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <%
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();
        %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getDescription() %></td>
                <td><%= product.getManufacturer() %></td>
                <td><%= product.getUnit() %></td>
                <td><%= quantity %></td>
            </tr>
        <%
            }
        %>

    <%
        }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
</body>
</html>
