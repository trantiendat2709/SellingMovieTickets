<%-- 
    Document   : footer
    Created on : Mar 1, 2023, 11:36:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <!-- Google font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@500&family=Josefin+Sans&display=swap" rel="stylesheet">
        <!-- animation library -->

        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <style>
            *{
                box-sizing: border-box;
                padding: 0;
                margin: 0;
            }

            body{
                background-image: linear-gradient(to right,#8E44AD,#F5B041);
/*                background: wheat;*/
            }

            .all{
                width: 98%;
                height: auto;
                background-color: #ffffff;
                margin: 5px;
                border-radius: 5px;
                transition: all 0.9s ease;
            }

            /* // trang tri logo // */
            .top-logo{
                /* border-bottom: 3px #8E44AD solid; */
            }

            .logo{
                width: 17vh;
                position: absolute;
                transition: 0.9s;
                animation-name: down;
                animation-duration: 2s;
            }

            .close{
                text-shadow: 0 0 5px rgb(114, 114, 122);
                position: absolute;
                font-size: 20px;
                top: 17px;
                right: 60px;
                animation-name: down;
                animation-duration: 0.7s;
                color: #273746;
                cursor: pointer;
                z-index: 2;
            }

            .hide{
                display: none;
            }

            .hide1{
                display: none;
            }

            .dark{
                background-color: #273746;
            }

            .dark1{
                background-color: #5D6D7E;
            }

            .dark-search{
                background-color: #273746;
                color: #EBEDEF;
            }

            .dark-bag{
                background-color: #273746;
                color: #EBEDEF;
            }

            .dark-user{
                background-color: #273746;
                color: #EBEDEF;
            }

            .dark-more{
                background-color: #273746;
                color: #EBEDEF;
            }

            .dark-mode{
                background-color: #273746;
                color: #EBEDEF;
            }

            .content{
                padding: 7px;
            }

            .video1{
                display: block;
                margin-top: 70px;
                margin-right: auto;
                margin-left: auto;
                border-radius: 7px;
            }

            .color-dark{
                color: #EBEDEF;
            }

            .title{
                font-family: 'Dosis', sans-serif;
                margin-left: 1.8%;
                text-align: start;
                font-size: 37px;
                font-weight: 900;
                animation-name: left;
                animation-duration: 1.5s;
            }

            .title-1{
                font-family: 'Dosis', sans-serif;
                text-align: start;
                margin-left: 1.8%;
                font-size: 15px;
                font-weight: 500;
                animation-name: left;
                animation-duration: 2.3s;
            }

            .button-shop{
                font-family: 'Dosis', sans-serif;
                background-image: linear-gradient(to right,#8E44AD,#F5B041);
                color: #ffffff;
                width: 100px;
                height: 30px;
                margin-top: 7px;
                margin-left: 1.8%;
                font-size: 15px;
                font-weight: 550;
                border-style: none;
                border-radius: 100px;
                transition: 0.7s;
                animation-name: left;
                animation-duration: 2.8s;
            }

            .title-2{
                font-family: 'Dosis', sans-serif;
                margin-top: 20px;
                margin-left: 1.8%;
                font-size: 30px;
                font-weight: 500;
                animation-name: left;
                animation-duration: 2.3s;
            }

            .trend-icon{
                color: #8E44AD;
                animation-name: top;
                animation-duration: 2.0s;
            }

            /* card jordan */

            .jordan-card{
                width: 96%;
                height: 250px;
                margin-top: 7px;
                margin-left: 1.8%;
                background-image: linear-gradient(to right,#8E44AD,#F5B041);
                border-radius: 7px;
                padding: 10px;
                animation-name: top;
                animation-duration: 1.5s;
                transition: 0.8s;
                position: relative;
            }

            .jordan-card:hover{
                width: 96%;
                height: 330px;
            }

            .jordan-card i{
                color: #EBEDEF;
                font-size: 25px;
                transition: 0.3s;
            }

            .heart-card:hover{
                transform: scale(1.2,1.2);
                color: #E74C3C;
            }

            .bag-card:hover{
                transform: scale(1.2,1.2);
                color: #8E44AD;
            }

            .bag-card, .heart-card{
                position: absolute;
                left: 15px;
                top: 15px;
            }

            .bag-card{
                left: unset;
                right: 15px;
            }

            .title-card{
                text-align: center;
                transition: 0.8s;
            }

            .title-card h2{
                font-family: 'Dosis', sans-serif;
                color: #EBEDEF;
            }

            .title-card h3{
                font-family: 'Dosis', sans-serif;
                color: #EBEDEF;
            }

            .img-card{
                /* width: 50%; */
                width: 180px;
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-top: 20px;
                transition: 0.8s;
            }

            .size-card{
                font-family: 'Dosis', sans-serif;
                color: #EBEDEF;
            }

            .size-card h3{
                margin-left: 7px;
            }

            .size-card span {
                margin: 7px;
                transition: 1s;
                cursor: pointer;
            }


            .color-card{
                font-family: 'Dosis', sans-serif;
                color: #EBEDEF;
                margin-left: 7px;
            }

            .color-card button{
                margin-top: 7px;
                width: 20px;
                height: 20px;
                border: 2px solid #EBEDEF;
                border-radius: 3px;
                cursor: pointer;
            }

            .color1{
                background-color: #F5B041;
            }

            .color2{
                background-color: #EC7063;
            }

            .color3{
                background-color: #A569BD;
            }

            .color1:hover {
                border-color: #273746;
            }

            .color2:hover {
                border-color: #273746;
            }

            .color3:hover {
                border-color: #273746;
            }

            .ct7-title{
                font-family: 'Dosis', sans-serif;
                margin-top: 20px;
                font-size: 30px;
                font-weight: 500;
                margin-bottom: 7px;
                margin-left: 2%;
            }

            .ct7-icon-title{
                font-size: 35px;
                margin-left: 10px;
                color: #8E44AD;

            }

            .content-7{
                font-family: 'Dosis', sans-serif;
                padding-bottom: 30px;
                margin-left: 2%;
            }

            .ct7-card{
                margin-top: 7px;
                padding: 7px;
                text-align: center;
                width: 98%;
                /* background-image: linear-gradient(to right,#8E44AD,#F5B041); */
                background-image: linear-gradient(to right,#8E44AD,#F5B041);
                border-radius: 7px;
                color: #ffffff;
                overflow: hidden;
                transition: 0.6s;
            }

            .ct7-p1{
                font-size: 27px;
                font-weight: 650;
            }

            .ct7-p2{
                color: #F5B041;
            }

            .ct7-imgg{
                width: 120px;
                height: 120px;
                border: 4px solid #ffffff;
                border-radius: 50%;
                overflow: hidden;
                margin:  auto;
                margin-top: 20px;
                transition: 0.9s;
            }

            .ct7-img{
                object-fit: cover;
                width: 100%;
                height: 100%;
                object-position: center;
                transition: 0.9s;
            }
            
            .ct7-menu a i{
                font-size: 37px;
                color: #ffffff;
                margin: 20px;
                transition: 0.5s ease;
            }

            .ct7-fb:hover ,.ct7-ig:hover ,.ct7-mail:hover ,.ct7-git:hover   {
                transform: scale(1.2,1.2);
                color: #F5B041;
            }

            .ct7-mail:hover ,.ct7-git:hover{
                transform: scale(1.2,1.2);
                color: #8E44AD;
            }

            .ct7-bt:hover {
                transform: scale(1.2,1.2);
                color: #ffffff;
            }

            .ct7-bt{
                width: 130px;
                height: 35px;
                background-image: linear-gradient(to right,#8E44AD,#F5B041);
                color: #ffffff;
                font-family: 'Dosis', sans-serif;
                margin-bottom: 15px;
                font-size: 20px;
                border: 3px solid #ffffff;
                transition: 0.6s ease;
                border-radius: 50px;
            }

            .ct7-boder{
                border: solid 3px #ffffff;
            }

            .st-icon-title{
                font-size: 50px;
                vertical-align: middle;
            }

            /* setting  */
            .setting{
                position: fixed;
                background: rgba(54, 53, 53, 0.6);
                top: 0;
                height: 100%;
                width: 100%;
                z-index: 1;
            }

            .st-title{
                font-family: 'Dosis', sans-serif;
                font-size: 40px;
                margin-top: 17px;
                padding-left: 15px;
                color: #8E44AD;
                font-weight: 590;
            }

            .st-menu{
                background-color: #EBEDEF;
                color: #273746;
                position: fixed;
                top: 0;
                right: 0;
                width: 60%;
                height: 100%;
                box-shadow: 0 0 25px rgb(41, 41, 44);
                animation-name: right;
                animation-duration:  0.7s;
                transition: 0.5s;
            }

            .st-menu-dark{
                background-color: #273746;
                color: #EBEDEF;
            }

            .st-ul{
                position: absolute;
                top: 90px;
                font-family: 'Dosis', sans-serif;
                font-size: 20px;
                list-style: none;

                width: 100%;
            }



            .st-ul li{
                color: #8E44AD;
                margin: 14px;
                transition: 0.4s;
            }

            .l1:hover ,.l2:hover ,.l3:hover  ,.l4:hover ,.l5:hover {
                color: #8E44AD;
                font-weight: 600;
                font-size: 24px
            }

            .st-close{
                position: absolute;
                font-size: 40px;
                color: #ffffff;
                text-shadow: 0 0 25px rgb(171, 171, 177);
                left: 10px;
                top: 10px;
                transition: 0.4s;
            }

            .st-close:hover{
                font-weight: 550;
                transform: scale(1.2,1.2);
            }

            .st-content{
                margin-top: 225px;
                padding: 15px;
                font-family: 'Dosis', sans-serif;
                position: relative;
            }

            .st-login-bt{
                font-family: 'Dosis', sans-serif;
                font-size: 15px;
                width: 100%;
                height: 35px;
                background-color: #8E44AD;
                color: #ffffff;
                border: none;
                border-radius: 50px;
                transition: 0.6s;
                margin-bottom: 3%;

            }

            .st-sign-up-bt{
                font-family: 'Dosis', sans-serif;
                font-size: 17px;
                width: 100%;
                height: 35px;
                color: #8E44AD;
                border: 2px solid #8E44AD;
                border-radius: 50px;
                transition: 0.6s;
            }

            .st-login-bt:hover ,.st-sign-up-bt:hover{
                transform: scale(1.1,1.1);
            }

            .st-p1{
                margin-top: 7px;
                font-size: 15px;
                font-weight: 500;
            }

            .st-a{
                color: #8E44AD;
                font-weight: 600;
            }

            .st-ul2 li{
                margin-bottom: 10px;
                font-size: 15px;
            }

            .st-ul2{
                margin-top: 20px;
                list-style: none;
                font-size: 25px;
            }

            .st-icon{
                margin-right: 10px;
                font-size: 25px;
                vertical-align: middle;
                font-weight: 500;
            }

            .st-icon:hover{
                color: #8E44AD;
            }

            .st-hide{
                display: none;
            }

            /* tinh nang login */
            .login{
                font-family: 'Dosis', sans-serif;
                position: fixed;
                background: rgba(54, 53, 53, 0.6);
                top: 0;
                height: 100%;
                width: 100%;
                z-index: 1;
                text-align: center;

            }

            .lg-ul{
                list-style: none;
            }

            .lg-title{
                font-size: 45px;
                color: #8E44AD;

            }

            .lg-last{
                margin-top: 20px;
            }

            .lg-content{
                background-color: #ffffff;
                box-shadow: 0 0 25px rgb(41, 41, 44);
                margin-top: 100px;
                padding: 20px;
                width: 85%;
                height: 420px;
                margin-left: auto;
                margin-right: auto;
                border-radius: 5px;
                animation-name: top;
                animation-duration:  0.7s;
            }

            .lg-forget{
                color: #5D6D7E;
                font-size: 15px;
            }

            .lg-p1{
                color: #5D6D7E;
                font-size: 15px;
            }

            .lg-a{
                color: #5D6D7E;
                font-size: 15px;
            }

            .lg-forget:hover ,.lg-a:hover{
                color: #8E44AD;
                font-weight: 600;
            }

            .lg-mail{
                margin-bottom: 30px;
            }

            .lg-mail, .lg-pass {
                font-family: 'Dosis', sans-serif;
                width: 90%;
                height: 40px;

                border: none;
                outline: none;
                border-bottom: 2px solid #d5b7cd;
                font-size: 17px;
            }

            .lg-bt{
                font-family: 'Dosis', sans-serif;
                width: 90%;
                height: 40px;
                margin: 13px;
                font-size: 23px;
                color: #8E44AD;
                background-color: #ffffff;
                border: 2.5px solid #8E44AD;
                border-radius: 50px;
                font-weight: 500;
            }

            .lg-bt:hover{
                background-color: #8E44AD;
                color: #ffffff;
                border: none;
            }

            .lg-close{
                position: absolute;
                font-size: 40px;
                color: #ffffff;
                text-shadow: 0 0 25px rgb(171, 171, 177);
                left: 10px;
                top: 10px;
                transition: 0.4s;
            }

            .lg-close:hover{
                font-weight: 550;
                transform: scale(1.2,1.2);
            }

            .lg-hide{
                display: none;
            }

            .lg-li{
                position: relative;
            }

            .lg-li span{
                position: absolute;
                color: #273746;
                border-bottom: 3px solid #8E44AD;
                width: 0%;
                top: 38px;
                left: 5%;
                transition: 0.7s;
            }

            .lg-mail:focus ~ span{
                width: 90%;
            }

            .lg-pass:focus ~ span{
                width: 90%;
            }



            .lg-error{
                color: #E74C3C;
                font-weight: 600;
                position: absolute;
                top: 40px;
                left: 5%;
                font-size: 15px;
            }

            .lg-show-error{
                color: #E74C3C;
                font-weight: 600;
            }

            .lg-fb, .lg-ap{
                margin-top: 20px;
                font-size: 25px;
                color: #8E44AD;
                transition: 0.4s;

            }

            .lg-ap{
                font-size: 28px;
            }

            .lg-fb:hover , .lg-ap:hover{
                transform: scale(1.2,1.2);
            }

            /* Register card */
            .register{
                width: 100%;
                height: 100%;
                position: fixed;
                top: 0;
                background: rgba(54, 53, 53, 0.6);
                z-index: 1;
                text-align: center;
            }

            .rs-close{
                position: absolute;
                font-size: 40px;
                color: #ffffff;
                text-shadow: 0 0 25px rgb(171, 171, 177);
                left: 10px;
                top: 10px;
                transition: 0.4s;
            }

            .rs-close:hover{
                font-weight: 550;
                transform: scale(1.2,1.2);
            }

            .rs-card{
                text-align: center;
                box-shadow: 0 0 25px rgb(41, 41, 44);
                background-color: #ffffff;
                width: 80%;
                border-radius: 5px;
                font-family: 'Dosis', sans-serif;
                margin-left: auto;
                margin-right: auto;
                margin-top: 70px;
                padding: 20px;
                height: 500px;
                animation-name: top;
                animation-duration: 0.7s;
            }

            .rs-user , .rs-mail , .rs-pass1 , .rs-pass2 {
                font-family: 'Dosis', sans-serif;
                width: 90%;
                height: 40px;
                margin-bottom: 10px;
                margin-top: 15px;
                border: none;
                outline: none;
                border-bottom: 2px solid #d5b7cd;
                font-size: 17px;
            }

            .rs-bt{
                font-family: 'Dosis', sans-serif;
                width: 90%;
                height: 40px;
                margin-bottom: 10px;
                margin-top: 10px;
                font-size: 23px;
                background-color: #8E44AD;
                color: #ffffff;
                background-color: #8E44AD;
                border: 2.5px solid #8E44AD;
                border-radius: 50px;
                font-weight: 500;
            }

            .rs-bt:hover {
                color: #8E44AD;
                background-color: #ffffff;
                border: 2.5px solid #8E44AD;
            }

            .rs-form{
                position: relative;
            }

            .rs-error{
                position: absolute;
                top: 55px;
                left: 5%;
                color: #E74C3C;
                font-weight: 600;
            }

            .rs-last{
                margin-top: 15px;
            }

            .rs-p1{
                font-size: 15px;
            }

            .rs-p1:hover{
                font-weight: 600;
            }

            .rs-form span{
                color: black;
                border-bottom: 3px solid #8E44AD;
                width: 0px;
                transition: 0.5s;
                position: absolute;
                top: 52px;
                left: 5%;
                transition: 0.5s;
            }

            .rs-user:focus ~ span,.rs-mail:focus ~ span, .rs-pass1:focus ~ span,.rs-pass2:focus ~ span{
                width: 90%;
            }

            .rs-hide{
                display: none;
            }

            /* Bag */
            .bag-content{
                position: fixed;
                width: 100%;
                height: 100%;
                top: 0;
                background: rgba(54, 53, 53, 0.6);
                z-index: 1;
            }

            .bag-card-ct{
                background-color: #ffffff;
                width: 70%;
                height: 400px;
                margin-left: auto;
                margin-right: auto;
                margin-top: 100px;
                font-family: 'Dosis', sans-serif;
                text-align: center;
                border-radius: 5px;
                position: relative;
                box-shadow: 0 0 25px rgb(41, 41, 44);
                animation-name: top;
                animation-duration: 0.7s;
            }

            .bag-close{
                position: absolute;
                top: 5px;
                font-size: 30px;
                right: 5px;
                transition: 0.5s;
                text-shadow: 0 0 25px rgb(41, 41, 44);
            }

            .bag-close:hover{
                transform: scale(1.2,1.2);
            }

            .bag-ct{
                background-color: #A569BD;
                width: 90%;
                height: 250px;
                margin-left: auto;
                margin-right: auto;
                border-radius: 5px;
                margin-top: 7px;
                margin-bottom: 7px;
                padding: 7px;
            }

            .bag-p2{
                color: #ffffff;
            }

            .bag-bt1{
                font-family: 'Dosis', sans-serif;
                border-radius: 50px;
                width: 90%;
                margin-top: 10px;
                height: 35px;
                color: #8E44AD;
                border: 3px solid #A569BD;
                background-color: #ffffff;
                font-size: 20px;
                font-weight: 600;
            }

            .bag-bt1:hover{
                background-color: #A569BD;
                color: #ffffff;

            }

            .bag-hide{
                display: none;
            }

            .bag-bt{
                display: none;
            }

            .user-bt{
                display: none;
            }

            .dark-bt{
                display: none;
            }




            @keyframes down{
                0%{
                    opacity: 0;
                    transform: translate(0,-100px);
                }


                100%{
                    opacity: 1;
                    transform: translate(0,0);
                }
            }

            @keyframes top{
                0%{
                    opacity: 0;
                    transform: translate(0,+100px);
                }


                100%{
                    opacity: 1;
                    transform: translate(0,0);
                }
            }

            @keyframes right{
                0%{
                    opacity: 0;
                    transform: translate(+100px,0);
                }


                100%{
                    opacity: 1;
                    transform: translate(0,0);
                }
            }

            @keyframes left{
                0%{
                    opacity: 0;
                    transform: translate(-100px,0);
                }


                100%{
                    opacity: 1;
                    transform: translate(0,0);
                }
            }
        </style>

    </head>
    <body>

        <p class="ct7-title" style="color: white">ABOUT ME<i style="color: white" class='bx bxs-user-account ct7-icon-title'></i></p>

        <div class="content-7">
            <div class="ct7-card">
                <div class="ct7-boder">
                    <div class="ct7-imgg">
                        <img class="ct7-img" src="img/anh.jpg">
                    </div>
                    <p class="ct7-p1">TRAN TIEN DAT</p>
                    <p class="ct7-p2">Cinema Tickets Booking Website</p>
                    <div class="ct7-menu">
                        <a href=https://www.facebook.com/profile.php?id=100041115664079><i class='bx bxl-facebook ct7-fb' ></i></a>
                        <a href="https://www.instagram.com/tdat_2709/"><i class='bx bxl-instagram ct7-ig' ></i></a>
                        <a href=""><i class='bx bxl-gmail ct7-mail' ></i></a>
                        <a href=""><i class='bx bxl-github ct7-git' ></i></a>
                    </div>
                    <a href=https://www.facebook.com/profile.php?id=100041115664079> <button class="ct7-bt">CONTACT ME</button></a>
                </div>
            </div>
        </div>
</html>
