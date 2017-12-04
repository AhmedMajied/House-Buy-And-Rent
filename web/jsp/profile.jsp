<%-- 
    Document   : profile
    Created on : Nov 19, 2017, 11:27:20 PM
    Author     : MariamAshraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="Models.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/profileStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="../js/profileJs.js"></script>

        <title>User Profile</title>
    </head>
    <body>
        <%
            User user=new User();
            user=(User)request.getAttribute("User");
        %>
        <header>
            <div id="navBar">
                <a id="active" href ="Home.jsp">Home</a>
                <a href="#">My Advertisments</a>
                <a href="#">About</a>
                <span id="search"></span>
                <input type="text"name="search"id="searchText" placeholder="search field"/>
                <a href="#"id="notification"></a>
                <a href="#"id="userName"><%=user.getUsername()%></a>
                <a href="profile.jsp">MyProfile</a>
                <a href="../index.html">LogOut</a>
            </div>
        </header>
        <section>
            <br><br>
            <form action="/IAProject/UserController?action=addPhoto" method="POST" enctype="mulipart/form-data">
                <input type="hidden" value="<%=user.getUsername()%>" name="userName" id="userName">
                <img src="../images/userImage.png" name="image" id="userImage">
                <input type="file" accept="image/*" id="addPhoto" name="photo" onchange="loadFile(event)">
                <input type="submit" value="Save Photo"id="savePhoto">
            </form>
            
            <form action="/UserController?action=deletePhoto"id="deleteImage">
              <input type="hidden"value="<%=user.getUsername()%>" name="userName" id="userName">
              <input type="submit"value="Delete Image"id="deletephoto">
            </form>
              
                <br><br>
                <label id="userName"><%=user.getUsername()%></label>
                <br><br>
              
              <button id="addPhone" onclick="displayPhone();">Add Phone</button>
              <fieldset id="Phone">
                  <form action="/IAProject/UserController?action=addPhone" method="post">
                        <input type="hidden"name="userName"value="<%=user.getUsername()%>">
                        <span id="phone"></span>
                        <input type="text" pattern="^[0-9]+" placeholder="Add Your Phone" name="phoneNumber" id="phoneNumber">
                        <br><br>
                        <input type="submit" id="submit" value="add phone Number"/> 
                    </form>
              </fieldset>              
              
                <form id="deletePhone" action="/IAProject/UserController?action=deletePhone" method="post">
                    <input type="hidden"name="userName"value="<%=user.getUsername()%>">
                    <br>
                    <input type="submit" id="submit1" value="Delete Phone"/> 
                </form>
              <br>
              
               <button id="changePassword" onclick="displayFields();">ChangePassword</button>
                <fieldset id="password">
                    <form action="/IAProject/UserController?action=changePassword" method="post"id="passwordForm">
                          <input type="hidden"name="userName"id="userName" value="<%=user.getUsername()%>"><br>
                          <span id='iPass'></span>
                          <input type="password" required placeholder='old Password'name="oldPassword" id="oPassword"><br><br>
                          <span id='iPass'></span>
                          <input type="password" required placeholder='new Password'name="newPassword" id="nPassword"><br><br>
                          <div id="valid"></div>
                          <input type="submit" id="submit" value="change Password"/> 
                      </form>
                 </fieldset> 
              
        </section>
    </body>
</html>
