<%@ page import="vn.edu.iuh.fit.backend.dtos.ThuocDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/22/2024
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Type Medicine</title>
</head>
<body>

<%
   List<ThuocDTO> medicines = (List<ThuocDTO>) session.getAttribute("medicines");
 %>
<div class="container">
    <h1 class="text-center mb-3">Type Medicine</h1>
    <a href="dashboard.jsp" class="btn btn-outline-primary">Back to Dashboard</a>

    <table class="table">
        <tr>
            <th>Ma Thuoc</th>
            <th>Ten Thuoc</th>
            <th>Don Gia</th>
            <th>Nam SX</th>
            <th>Loai Thuoc</th>
        </tr>
        <%
            for (ThuocDTO medicine : medicines) {
        %>
        <tr>
            <td><%=medicine.getMaThuoc() %>
            </td>
            <td><%=medicine.getTenThuoc() %>
            </td>
            <td><%=medicine.getDonGia() %>
            </td>
            <td><%=medicine.getNamSX() %>
            </td>
            <td><%=medicine.getLoaiThuoc() %>
            </td>
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
