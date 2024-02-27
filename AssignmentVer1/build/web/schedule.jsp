<%-- 
    Document   : schedule
    Created on : Mar 5, 2023, 6:22:03 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Schedule" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

        <title>Chọn lịch xem phim</title>
        <style>
            p{
                color : white;
                font-family: 'Dosis', sans-serif;
            }
        </style>
    </head>

    <body>
        <!-- nav bar -->
        <jsp:include page="header.jsp"/>
        <!-- end of navbar -->

        <br><br><br><br><br>
        <form action="showtime" method="post">
            <div class="container">

                <p style="font-size: 40px">Chọn lịch xem phim ${error} <p>
                    <br><br>
                <p style="font-size: 18px">Chọn ngày xem phim (dd-MM-yyyy)</p>
                <br><br>
                <select id="listDate" onchange="" class="form-control form-control-lg" name="startDate" >
                    <option value="0" disabled selected>--Chọn ngày xem phim--</option>
                    <c:forEach items="${list}" var="item">                      
                        <option value="${item.getStartDate()}">${item.getStartDate()}</option>
                    </c:forEach>
                </select>
                <br><br>
                <button style="border-color: white; color: white;font-family: 'Dosis', sans-serif; border: 3px solid white;" class="btn btn-outline-danger btn-block">Xác Nhận</button>
            </div>
        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
