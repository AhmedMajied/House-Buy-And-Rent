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
            <form name="form-login" id="formLogin" action="/IA_Project/UserController?action=logIn" method="post">
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
                        <a href="signup.html" id="link">create one</a>
                </center>
            </form>
        </div>
        
        <!-- for testing-->
        <form action="AdvertisementController?action=AllAds" method="POST">
            <input type="submit"/>
        </form>

    </body>
</html>

