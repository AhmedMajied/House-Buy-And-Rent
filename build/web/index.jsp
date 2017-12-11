
<%-- 
    Document   : index.jsp
    Created on : Dec 5, 2017, 3:00:39 PM
    Author     : MariamAshraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/indexStyle.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/loginJS.js"></script>
    </head>
    
    <body>
        <%
            HttpSession currentSession=request.getSession(true);
            if(currentSession.getAttribute("User")!=null)
            {
                response.sendRedirect("jsp/Home.jsp");
            }
        %>
        <div id="login">
            <form name="form-login" id="formLogin" action="/UserController?action=logIn" method="post">
                <div id="title">LogIn</div><br><br>
                <span id="userIcon"></span>
                <input id="user" placeholder="Username" name="name" type="text" required />
                <span id="lock"></span>
                <input id="pass" placeholder="Password"name="password" type="password" required />
                <br>
                <div id="warning"></div>
                <br>
                <input value="Login" type="submit" id="loginButton">
                
                <center>
                    <label id="account">do not have an account ?</label>
                        <a href="jsp/signup.jsp" id="link">create one</a>
                </center>
            </form>
        </div>
        
        <!-- for testing-->
        <form action="AdvertisementController?action=createAdvertisementPage" method="POST">
            <input type="submit"/>
        </form>

    </body>
</html>

