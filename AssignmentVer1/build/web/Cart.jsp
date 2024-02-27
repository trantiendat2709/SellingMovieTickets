<%-- 
    Document   : Cart
    Created on : Mar 14, 2023, 4:52:53 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Cart" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lịch sử</title>
        <style type="text/css">
            table, th, td {
                border: 2px solid white;
                border-collapse: collapse;
                text-align: center;
                color: white;
                font-family: 'Dosis', sans-serif;
            }
            td{
                text-align:center
            }

            h2{

                color : white;
                font-family: 'Dosis', sans-serif;
            }
            .error{
                text-align: center;
                color : white;
                font-family: 'Dosis', sans-serif;       
            }



        </style>
    </head>

    <body>
        <!-- nav bar -->
        <jsp:include page="header.jsp"/>
        <!-- end of navbar -->

        <br><br><br>
        <div class="container-fluid">
            <h2 style="text-align: center">Giỏ Hàng</h2>
            <br>
            <p class="error">${errorMessage}<p>
            <div>
                <table style="width:100%">
                    <tr>
                        <th>Tên Phim</th>
                        <th>Tên Chi Nhánh</th>
                        <th>Giờ Chiếu</th>
                        <th>Tên Phòng</th>
                        <th>Ghế</th>
                        <th>Gía</th>
                        <th>Thanh Toán</th>
                    </tr>
                    <c:forEach items="${listCart}" var="item">


                        <tr>

                            <td >${item.getMovieName()}</td>
                            <td>${item.getCinemaName()}</td>
                            <td>${item.getTime()} ${item.getDate()}</td>
                            <td>${item.getRoomName()}</td>
                            <td>${item.getSeatName()}</td>
                            <td>70000</td>
                            <td><a href="billcart?lcId=${item.getLcId()}&sId=${item.getsId()}&cId=${item.getcId()}&mName=${item.getMovieName()}&cName=${item.getCinemaName()}&time=${item.getTime()}&date=${item.getDate()}&rName=${item.getRoomName()}&sName=${item.getSeatName()}&timeBooking=" onclick="addTime(event)" class="btn btn-outline-danger btn-block">Thanh Toán</a></td>

                        </tr>

                    </c:forEach>
                </table>

            </div>
            <br>
            <br>
            <br>
        </div>
        <br>
        <br>
        <jsp:include page="footer.jsp"/>

        <script>
            function addTime(event) {
                event.preventDefault(); // Chặn sự kiện mặc định của thẻ a
                var currentTime = new Date();
                var timeFormat = currentTime.toLocaleString();
                var link = event.target; // Sử dụng tham số event để lấy thẻ a được click
                link.href += "?timeBooking=" + timeFormat;
                window.location.href = link.href; // Chuyển hướng đến trang thanh toán
            }
        </script>
    </body>
</html>
