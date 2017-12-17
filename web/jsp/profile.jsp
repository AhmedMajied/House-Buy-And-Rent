<%-- 
    Document   : profile
    Created on : Nov 19, 2017, 11:27:20 PM
    Author     : MariamAshraf
--%>

<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="Models.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/profileStyle.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/profileJs.js"></script>

        <title>User Profile</title>
    </head>
    <body>
        <%
            HttpSession currentSession = request.getSession(true);
            User user = new User();
            if (currentSession.getAttribute("User") != null) {
                user = (User) currentSession.getAttribute("User");
            } else {
                response.sendRedirect("/");
            }
        %>
        <header>
            <div id="navBar">
                <a id="active" href ="/UserController?action=displayHome">Home</a>
                <a href="/AdvertisementController?action=createAdvertisementPage">Create Advertisemenet</a> 
                <a href="/AdvertisementController?action=searchPage">Search</a>
                <a href="/jsp/profile.jsp">MyProfile</a>
                <a href="/UserController?action=logOut">LogOut</a>
            </div>
        </header>
        <section>
            <br><br>

            <label id="data">User Name : <%=user.getUsername()%></label>
            <%if (user.getPhone() != null) {%>
            <label id="data">Phone Number : <%=user.getPhone()%></label>
            <%}%>
            <br><br>
            <fieldset id="fieldSet">
                <legend>Picture</legend>
                <%  if (user.getPicture() != null) {
                        String url = "data:image/png;base64," + Base64.getEncoder().encodeToString(user.getPicture().getBytes(1, (int) user.getPicture().length()));
                %>
                <img src="<%=url%>"name="image"id="userImage">
                <%} else {%>
                <img src="../images/userImage.png" name="image" id="userImage">
                <%}%>
                <form action="/UserController?action=addPhoto" method="POST" enctype="multipart/form-data">
                    <input type="file" accept="image/*" id="addPhoto" name="file" onchange="loadFile(event)">
                    <input type="submit" value="Save Photo"id="savePhoto">
                </form>
            </fieldset>
            <br><br>
            <button id="addPhone" onclick="displayPhone();">Change Phone</button>
            <fieldset id="Phone">
                <form action="/UserController?action=addPhone" method="post">
                    <span id="phone"></span>
                    <input type="text" pattern="^[0-9]+" placeholder="Add Your Phone" name="phoneNumber" id="phoneNumber">
                    <br><br>
                    <input type="submit" id="submit" value="add phone Number"/> 
                </form>
            </fieldset>              
            <%if (user.getPhone() != null) {%>
            <br>
            <form id="deletePhone" action="/UserController?action=deletePhone" method="post">
                <br>
                <input type="submit" id="submit1" value="Delete Phone"/> 
            </form>
            <br>
            <%}%>
            <br>
            <button id="changePassword" onclick="displayFields();">ChangePassword</button>
            <fieldset id="password">
                <form action="/UserController?action=changePassword" method="post"id="passwordForm">
                    <input type="hidden"name="userName"value="<%=user.getUsername()%>"/>
                    <span id='iPass'></span>
                    <input type="password" required placeholder='old Password'name="oldPassword" id="oPassword"><br><br>
                    <span id='iPass'></span>
                    <input type="password" required placeholder='new Password'name="newPassword" id="nPassword"><br><br>
                    <div id="valid"></div>
                    <input type="submit" id="submit" value="change Password"/> 
                </form>
            </fieldset>     
            <br><br>
        </section>
    </body>
</html>
