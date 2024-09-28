<%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 9/28/2024
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
  Tạo các chức năng CRUD với API, và trong form product nếu chức năng thêm thì không có tìm kiếm sp,
  nếu chức năng sửa thì có tìm kiếm sp để tìm sp cần sửa,
  nếu chức năng xóa thì có tìm kiếm sp để tìm sp cần xóa
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Product List</title>
</head>
<body>
<div class="container">
    <h1 class="text-center mb-2">Employee List</h1>
    <a href="Home.jsp" class="btn btn-secondary mb-2">Back to Home</a>
    <div id="productList" class="row"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
</script>
<script src="resource/js/fetchAPI.js"></script>
</body>
</html>
