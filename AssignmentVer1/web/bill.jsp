<%-- 
    Document   : bill
    Created on : Mar 5, 2023, 6:25:04 PM
    Author     : Admin
--%>

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
            th {
                padding: 0px 20px 5px 0px;
            }
            th{
                color: white;
            }


            .image img {
                width: 350px;
                height: 350px;
                margin-left: 50px;
            }

        </style>
    </head>

    <body>
        <!-- nav bar -->
        <jsp:include page="header.jsp"/>
        <!-- end of navbar -->

        <br><br><br>
        <div class="container">
            <h2 style="color: white">Thanh toán hóa đơn</h2>
            <br>
            <div style="display:flex">
                <table>
                    <tr>
                        <th><b>Tên Phim: </b></th>
                        <th>${sessionScope.movieName}</th>
                    </tr>
                    <tr>
                        <th><b>Tên Chi Nhánh:</b></th>
                        <th>${sessionScope.cinemaName}</th>
                    </tr>
                    <tr>
                        <th><b>Giờ Chiếu:</b></th>
                        <th>${sessionScope.time}</th>
                    </tr>
                    <tr>
                        <th><b>Ngày Chiếu:</b></th>
                        <th>${sessionScope.startDateFormat}</th>
                    </tr>
                    <tr>
                        <th><b>Tên Phòng:</b></th>
                        <th>${sessionScope.roomname}</th>
                    </tr>
                    <tr>
                        <th><b>Số Vé:</b></th>
                        <th>${numberSeats}</th>
                    </tr>
                    <tr>
                        <th><b>Tiền Vé Đơn:</b></th>
                        <th>70000</th>
                    </tr>
                    <tr>
                        <th><b>Tổng:</b></th>
                        <th>${price}</th>
                    </tr>
                </table>
                <div class="image">
                    <img src="img/${sessionScope.cinemaPicture}" alt="">
                </div>
                <div class="image">
                    <img " src="img/${sessionScope.moviePicture}" alt="">
                </div>
            </div>
            <br><br><br>
            <a href="listticket" onclick="addTime()" class="btn btn-outline-danger btn-block">Thanh Toán</a>
        </div>
        <br>
        <br>
        <br>
        <jsp:include page="footer.jsp"/>

        <script>
            function addTime() {
                // Lấy thời gian hiện tại
                var currentTime = new Date();
                // Tạo định dạng cho thời gian
                var timeFormat = currentTime.toLocaleString();
                // Lấy đường dẫn của thẻ a
                var link = document.querySelector('a[href="listticket"]');
                // Truyền thời gian vào đường dẫn của thẻ a
                link.href += "?timeBooking=" + timeFormat;
            }
        </script>
    </body>
</html>
