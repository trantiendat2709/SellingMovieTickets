<%-- 
    Document   : CartEmpty
    Created on : Mar 15, 2023, 2:54:32 AM
    Author     : Admin
--%>

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
            <p class="error">Chưa có vé trong giỏ hàng<p>
            <br>
            <br>
            <br>
        </div>
        <br>
        <br>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
