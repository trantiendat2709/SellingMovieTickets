<%-- 
    Document   : history
    Created on : Mar 5, 2023, 6:26:04 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Seat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thanh Toán</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
                            <th>Thời gian mua</th>
                        </tr>
                        <c:forEach items="${listTickets}" var="ticket">
                            <tr>
                
                                <td >${sessionScope.movieName}</td>
                                <td>${sessionScope.cinemaName}</td>
                                <td>${sessionScope.time} ${sessionScope.startDate}</td>
                                <td>${sessionScope.roomname}</td>
                                <td>${ticket.getName()}</td>
                                <td>${timeBooking}</td>
                          
                            </tr>
                        </c:forEach>


                    </table>

                </div>
                <br>
                <br>
                <br>
                <h2 style="text-align: center">Xin cảm ơn</h2>
                <br>
                <br>
            </div>
            <br>
            <br>
            <jsp:include page="footer.jsp"/>
        </body>
    </html>
