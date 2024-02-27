<%-- 
    Document   : showTime
    Created on : Mar 6, 2023, 12:21:36 PM
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

        <br><br><br><br><br><br>
        <form method="post" action="seat">
            <div class="container">

                
                <p style="font-size: 40px">Danh sách các giờ chiếu trong ngày ${sessionScope.startDateFormat}<br> ${error}</p>           
                <br><br>
                <p style="font-size: 18px">Chọn giờ xem phim (HH:mm)</p>
                <br><br>
                <select id="listTimes" onclick="" class="form-control form-control-lg" name="startTime">
                    <option value="0" disabled selected>--Chọn giờ xem phim--</option>
                    <c:forEach items="${listTime}" var="item">                      
                        <option value="${item.getStartTime()}">${item.getStartTime()}</option>
                    </c:forEach>
                </select>
                <br><br>
                 <button style="border-color: white; color: white;font-family: 'Dosis', sans-serif; border: 3px solid white;" class="btn btn-outline-danger btn-block">Xác Nhận</button>
            </div>
        </form>
        <br><br><br><br><br><br><br><br><br><br>
        <jsp:include page="footer.jsp"/>
        <script>
            // lấy thẻ select và thẻ a
            var select = document.getElementById("listTimes");
            var link = document.querySelector("a.btn-outline-danger");
            const urlParams = new URLSearchParams(window.location.search);
            const movieId = urlParams.get('movieid');
            const branchId = urlParams.get('branchid');
            const date = urlParams.get('date');
            // thêm sự kiện onchange cho thẻ select
            select.onchange = function () {
                // lấy giá trị được chọn
                var selectedValue = select.options[select.selectedIndex].value;
                if (selectedValue !== '0') { // Nếu có giá trị được chọn
                    const newUrl = "seat?time=" + selectedValue + "&date=" + date + "&movieid=" + movieId + "&branchid=" + branchId;
                    // đưa giá trị vào thẻ a
                    link.href = newUrl;
                } else { // Nếu không có giá trị được chọn
                    alert('Vui lòng chọn gio xem phim');
                }

            };
        </script>
    </body>
</html>
