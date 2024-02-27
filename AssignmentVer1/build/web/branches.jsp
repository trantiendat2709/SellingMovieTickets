<%-- 
    Document   : branches
    Created on : Mar 2, 2023, 3:36:35 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Cinema" %>
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
        <title>Chọn chi nhánh</title>
        <style>
            .img-branch {
                height: 400px;
            }
            .branch-item {
                margin-bottom: 50px;
            }
            h2{
                font-family: 'Dosis', sans-serif;
                color:white;
            }
        </style>
    </head>

    <body>
        <!-- nav bar -->
        <jsp:include page="header.jsp"/>
        <!-- end of navbar -->

        <!-- movie selections-->
        <br>
        <br>
        <br>

        <h2 class="container">Chọn Chi Nhánh</h2>

        <div class="d-flex justify-content-between flex-wrap container">
            <c:forEach items="${cinema}" var="item">
                <div class="card branch-item" style="width:500px">
                    <img class="card-img-top img-branch"
                         src="img/${item.image}"
                         alt="Card image" style="width:100%">
                    <div class="card-body">
                        <h4 class="card-title">${item.name} </h4>
                        <p class="card-text">Địa Chỉ: ${item.address}</p>
                        <p class="card-text">SĐT: ${item.phone}</p>
                        <a href="schedule?movieId=${sessionScope.movieId}&branchId=${item.id}" class="btn btn-outline-danger btn-block">Chọn</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- end of movie selections -->
        <br>
        <br>
        <jsp:include page="footer.jsp"/>
    </body>

</html>
