<%@ page import="vn.edu.iuh.fit.backend.entities.Loaithuoc" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Type Medicine</title>
</head>
<body>

<%
    List<Loaithuoc> types = (List<Loaithuoc>) session.getAttribute("type_medicine");
%>
<div class="container">
    <h1 class="text-center mb-3">Type Medicine</h1>
    <a href="dashboard.jsp" class="btn btn-outline-primary">Back to Dashboard</a>

    <table class="table">
        <tr>
            <th>Ma Thuoc</th>
            <th>Ten Loai Thuoc</th>
        </tr>
        <%
            for (Loaithuoc type : types) {
        %>
        <tr>
            <td><%=type.getMaLoaiThuoc() %>
            </td>
            <td><%=type.getTenLoaiThuoc() %>
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
