<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <style>
            body {
                margin: 0;
                background-image: url(TIM图片20180615070041.jpg);
                background-repeat: no-repeat;
                transition: 1.5s;
            }
            .login {
            	position: absolute;
            	top: 100px;
            	right: 340px;
                width: 260px;
                height: 360px;
                margin: 100px auto;
                padding-left: 10px;
                padding-right: 10px;
                border: 1px silver solid;
                border-radius: 15px;
                box-shadow:  0px 0px 40px;
            }
            p {
                margin: 0;
                height: 35px;
                color: red;
                text-align: center;
                font-family: 宋体;
                font-size: 14px;
            }
            .head-portrait {
                width: 80px;
                height: 80px;
               /* border: 1px salmon solid;*/
                border-radius: 50%;
                margin: 20px auto;
                overflow: hidden;
            }
            .head-portrait img {
                width: 80px;
            }
            .input-content {
                float: right;
                height: 28px;
                padding: 0;
                outline: none;
                /*vertical-align: middle;*/
                border: 1px white solid;
                border-radius: 10px;
                font-size: 16px;
            }
           /* .input-content:active {
                background-color: #00ff40;
            }*/
            .input-login {
                position: relative;
                height: 200px;
                margin-top: 50px;
            }
            .input-login div {
                height: 35px;
                margin-top: 5px;
                line-height: 35px;
                vertical-align: middle;
                font-family: 楷体;
                font-size: 18px;
                color: #fff;
            }
            a {
                text-decoration: none;
            }
            .input-login a {
                position: absolute;
                font-family: 楷体;
                color: #fff;
            }
            .input-login .btn1 {
                bottom: 10px;
            }
            .input-login .btn2 {
                bottom: 10px;
                right: 0;
            }
            .input-login a:hover {
                color: #5bc0de;
            }
            /*.input-login a:active {
                font-size: 16px;
            }*/
            span {

                font-family: 楷体;
                font-size: 16px;
                color: #fff;
            }
            #btn-login {
                position: absolute;
                bottom: 50px;
                background-color: #fff;
                width: 100%;
                height: 30px;
                outline: none;
                border: 1px white solid;
                border-radius: 15px;
                margin: auto;
                font-family: 楷体;
                font-size: 18px;
                color: #00ff40;
                opacity: .9;
            }
            #btn-login:hover {
                background-color: rgba(256,256,256,.5);
            }
            #btn-login:active {
                border-left-width: 2px;
                border-top-width: 2px;
            }
        </style>
    </head>
    <body>
        <div class="login">
            <div class="head-portrait">
                <img src="images/21.jpg">
            </div>
            <div class="input-login">
                <div>用户名: <input type="text" class="input-content" id="username" placeholder="用户名/账号"></div>
                <div>密&nbsp;&nbsp;码: <input type="password" class="input-content" id="user-password" placeholder="密码">
                    <p id="tip"></p>
                </div>
                <button type="button" id="btn-login">登 录</button>
                <a href="javascript:void(0)" class="btn1">立即注册</a>
                <a href="javascript:void(0)" class="btn2">忘记密码？</a>
                	<%if(session.isNew()){
                	session.setAttribute("user", "yes");       
                	}
		              %>
            </div>
        </div>
        <script type="text/javascript">
            var index = 0;
            /*var backPicture = ['01.jpg','02.jpg','03.jpg','04.jpg','05.jpg','06.jpg','07.jpg'];
            setInterval(function(){
                index = (index == 7 ? 0 : index);
                document.body.style.backgroundImage = "url(images/Background-picture/"+backPicture[index++]+")";
            },6000);*/
            var btnLogin = document.getElementById("btn-login");

            var oUser = document.getElementById("username");
            var oPassword = document.getElementById("user-password");

         
            btnLogin.onclick = function() {
                var xhr = new XMLHttpRequest();
                xhr.open("POST","http://localhost:8080/TTMS/login_servlet",true);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xhr.send("userid="+oUser.value+"&userpwd="+oPassword.value);
                xhr.onreadystatechange = function() {
                    if (xhr.status == 200 && xhr.readyState == 4) {
                        var str = xhr.responseText;
                        if(str === 'ok') {
                        	location.replace("main-interface.html");
                        } else {
                        	document.getElementById("tip").innerText = str;
                        }
                        
                    }
                }
            }
        </script>
    </body>
</html>