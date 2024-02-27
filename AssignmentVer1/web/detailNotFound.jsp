<%-- 
    Document   : detailNotFound
    Created on : Mar 2, 2023, 10:57:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                margin-top:0px;
                padding: 0px;
                box-sizing:border-box;
            }

         

            ::-moz-selection {
                color: white;
                text-shadow: none;
                background: #222222;
            }
            ::selection {
                color: white;
                text-shadow: none;
                background: #222222;
            }
            img::selection {
                color: white;
                background: transparent;
            }
            img::-moz-selection {
                color: white;
                background: transparent;
            }
            body{
                margin:0;
                font-family: 'Roboto', sans-serif;
                font-weight:300;
                overflow-x:hidden;
                color:#fff;
                font-size:14px;

            }
            html,
            body {
                height: 100%;
                width: 100%;
                background: #AA076B;
                background: -webkit-linear-gradient(to top, #aa076b, #61045f);
                background: linear-gradient(to top, #aa076b, #61045f);
                letter-spacing: 1px;
            }
            a {
                -webkit-transition: all 0.35s;
                -moz-transition: all 0.35s;
                transition: all 0.35s;
                color: #f39c12;
                margin-left: 45%;
            }
            a:hover,
            a:focus {
                color: #f39c12;
                text-decoration:none;
            }
            hr {
                width: 100%;
                margin: 20px 0;
                border-top:2px dashed #dedede;
            }
            hr.light {
                border-color: white;
            }
            h1,
            h2,
            h3,
            h4,
            h5,
            h6 {
                font-family: 'Roboto', sans-serif;
                font-weight: normal;
                letter-spacing: 1px;
                color: #fff;
            }
            p {
                font-size: 20px;
                line-height: 1.5;
                margin-bottom: 20px;
            }

            .brand{
                color: #fff;
            }
            .brand span{
                margin-top:50px;
                font-size: 40px;
            }
            h1.head{
                font-size: 100px;
                font-weight: 900;
                letter-spacing: 25px;
                margin: 0px 0 0 0;
                text-align: center;
            }
            .btn-outline{
                border: 2px solid #fff;
                color: #fff;
                padding: 12px 40px;
                border-radius: 25px;
                margin-top: 25px;
                display: inline-block;
                font-weight: 600;
            }
            .btn-outline:hover{
                color: #aa076b;
                background: #fff;
            }
            .bwt-footer-copyright {
                font-size:14px;
                padding:10px 0;
                line-height:20px;
                margin-top:50px;
            }
            .bwt-footer-copyright .left-text{
                text-align:left;
                margin:10px 0;
            }
            .bwt-footer-copyright .right-text{
                text-align:right;
                margin:10px 0;
            }
            .bwt-footer-copyright a{
                color: #fff;
                font-weight: 500;
            }


        </style>
    </head>
    <body>
        <div  class="container text-center">
            <h1 class="head"><span>Hmm...</span></h1>
            <p style="text-align: center">Không Tìm Thấy Phim Bạn Muốn Tìm Kiếm</p>
             <a class="nav-link btn-outline" href="/AssignmentVer1/movie">Về Trang Chủ</a>
        </div>
    </body>
</html>
