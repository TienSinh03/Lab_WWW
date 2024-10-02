<%@ page import="vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/21/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Form</title>
</head>
<body>
<%
    String action = request.getParameter("action");
    Object product_id = session.getAttribute("product");

    Product product = (Product) product_id;
    int id = product.getId() == null ? 0 : product.getId();
    String name = product.getName() == null ? "" : product.getName();
    String description = product.getDescription() == null ? "" : product.getDescription();
    String img_path = product.getImgPath() == null ? "" : product.getImgPath();

%>

<div class="container">
    <h1 class = "text-center">Form Product</h1>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">

        <div class="mt-3">
            <div class="mb-2">
                <label for="pro_id" class="form-label">Id</label>
                <input type="text" class="form-control" id="pro_id" name="product_id" value="<%=id%>" readonly>
            </div>
            <div class="mb-2">
                <label for="name_product" class="form-label">Name</label>
                <input type="text" class="form-control" id="name_product" name="name" value="<%=name%>" required>
            </div>
            <div class="mb-2">
                <label for="des" class="form-label">Description</label>
                <input type="text" class="form-control" id="des" name="description" value="<%=description%>" required>
            </div>
            <div class="mb-2">
                <label for="img" class="form-label">Img_Path</label>
                <input type="text" class="form-control" id="img" name="img_path" value="<%=img_path%>" required>
            </div>
        </div>

        <input type="submit" class="btn btn-primary" value="Submit">
        <a href="ProductList.jsp" class="btn btn-secondary">Cancel</a>

    </form>

    <%
        if (action.equals("edit")) {
    %>
    <div class="input-group">
        <form class="form-outline" id="searchForm">
            <input type="hidden" name="action" value="search">
            <label class="form-label" for="form1">Search Product: </label>
            <input id="search-input" type="search" id="form1" name="search_id" class="form-control" placeholder="product id"/>
            <button type="submit" class="btn btn-outline-success" id = "search-btn" data-mdb-ripple-init>Search</button>
        </form>
    </div>

    <% } %>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>

<%
    if (action.equals("edit")) {
%>
<script src="./resource/js/fetchAPI_Id.js"></script>

<%}%>

</body>
</html>
