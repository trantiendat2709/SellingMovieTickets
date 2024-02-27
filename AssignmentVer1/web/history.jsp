<%-- 
    Document   : history
    Created on : Mar 9, 2023, 3:55:54 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Ticket" %>
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



        </style>
    </head>

    <body>
        <!-- nav bar -->
        <jsp:include page="header.jsp"/>
        <!-- end of navbar -->

        <br><br><br>
        <div class="container-fluid">
            <h2 style="text-align: center">Danh sách vé đã đặt</h2>
            <br>
            <div>
                <table style="width:100%">
                    <tr>
                        <th>Tên Phim</th>
                        <th>Tên Chi Nhánh</th>
                        <th>Giờ Chiếu</th>
                        <th>Tên Phòng</th>
                        <th>Ghế</th>
                        <th>Gía</th>
                        <th>Thời gian mua</th>
                    </tr>
                    <c:forEach items="${data}" var="item">
                        <tr>

                            <td >${item.getMovieName()}</td>
                            <td>${item.getCinemaName()}</td>
                            <td>${item.getTime()} ${item.getDate()}</td>
                            <td>${item.getRoomName()}</td>
                            <td>${item.getSeatName()}</td>
                            <td>70000</td>
                            <td>${item.getCreateTime()}</td>

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
    </body>
</html>
