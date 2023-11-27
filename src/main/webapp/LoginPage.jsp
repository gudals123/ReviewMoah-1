<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link  rel="stylesheet" href="css/main.css">
<title>Login Page</title>
</head>
<body>

        <div class="mainWrap">
            <div class="wrap-content">
            	<div class="wrap-login">
                    <div class="wrap-form">
                        <div class="form-div">
                        	<form method="post" action="loginAction.jsp">
	                            <div class="logo-wrapper">
	                                <img src = "img/Reviewmoah.svg"/>
	                            </div>
	                            <div class="form-div">
	                            	<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">          
	                            	<input type="password" class="form-control" placeholder="비밀번호" name="userPW" maxlength="20">
		                            <input type="submit" class="login-button" value="로그인">
	                            </div>
	                    	</form>
                        </div>
                   </div>
                </div>
				<div class="wrap-singup">
                    <div class="text1">계정이 없으신가요?</div>
                    <div class="text2">
	                    <a href='join.jsp'>가입하기</a>
                    </div>
                </div>
            </div>
        </div>


</body>
</html>