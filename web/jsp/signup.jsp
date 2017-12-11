<%-- 
    Document   : signup.jsp
    Created on : Dec 5, 2017, 3:10:25 PM
    Author     : MariamAshraf
--%>
<%@page import="Models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Sign Up</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../css/signUpStyle.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/signupJS.js"></script>
        <script src='https://www.google.com/recaptcha/api.js'></script>
    </head>
    <body>
        <%
            HttpSession currentSession=request.getSession(true);
            User user=new User();
            if(currentSession.getAttribute("User")!=null)
            {
                user=(User)currentSession.getAttribute("User");
            }
            else
            {
                response.sendRedirect("jsp/Home.jsp");
            }
        %>
        <div id="signUp">
            <form name="form-signUp" id="formSignup" action="/UserController?action=addNewUser" method="post">
                <div class="message">Sign Up</div>
                <br>
                <span id="userIcon"></span>
                <input id="user" placeholder="Username *" name="name" type="text" required pattern="^[a-zA-Z].{3,}$" title="name has at least 3 lettes & name contains only letters">
                <div id="userWarn"></div>
                                
                <span id="lock"></span>
                <input id="pass" placeholder="Password *" name="password" type="password" pattern=".{4,}" required title="password must be atleast 4 symbols">
                
                <span id="lock"></span>
                <input id="cPass" placeholder="confirm Password *" type="password"  pattern=".{4,}" required title="password must be atleast 4 symbols">
                
                <div id="passWarn"></div>
                
                <span id="phone"></span>
                <input id="phoneNumber" placeholder="PhoneNumber" name="phone" type="text" pattern="^[0-9]+" title="phone number">
                <br>
                <center><div
                    class="g-recaptcha"
                    data-sitekey="6LdRWTkUAAAAAMK20VualcTI0UHCU20PMOYy62e0" 
                    data-callback="validateCaptcha">
                    </div>
                </center>
                
                <input value="Sign Up" type="submit" id="signUpButton">
            </form>

        </div>
    </body>
</html>
