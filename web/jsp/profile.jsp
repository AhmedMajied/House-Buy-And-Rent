<%-- 
    Document   : profile
    Created on : Nov 19, 2017, 11:27:20 PM
    Author     : MariamAshraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/profileStyle.css">
        <script src="../js/profileJs.js"></script>

        <title>User Profile</title>
    </head>
    <body>
        <header>
            <div id="navBar">
                <a id="active" href ="Home.jsp">Home</a>
                <a href="#">My Advertisments</a>
                <a href="#">About</a>
                <span id="search"></span>
                <input type="text"name="search"id="searchText" placeholder="search field"/>
                <a href="#"id="notification"></a>
                <a href="profile.jsp">MyProfile</a>
                <a href="../index.html">LogOut</a>
            </div>
        </header>
        <section>
            <br><br>
              <img src="../images/userImage.png"alt="No Image" name="image" id="userImage">
              <input type="file" accept="image/*" id="file" onchange="loadFile(event)">
              <br><br>
              <label id="userName">Mariam</label>
              <br><br>
              
              <button id="submit1" onclick="displayPhone();">add Number</button>
              <fieldset id="Phone">
                    
                  <form action="/UserController?ACTION=addPhone" method="POST">
                        <span id="phone"></span>
                        <input type="text" pattern="^[0-9]+" placeholder="Add Your Phone" name="phoneNumber" id="phoneNumber">
                        <br><br>
                        <input type="submit" id="submit" value="add phone Number"/> 
                        <p id="res"></p>
                    </form>
              </fieldset>
              
              <br><br>
              
              <input type="button" id="submit2" value="add Email"onclick="displayEmail()"/>
              <fieldset id="Email">
                    <span id="email"></span>
                    <input type="email"placeholder="Add Your Email"id="userEmail">
                    <br><br>
                    <form action=""method="POST">
                        <input type="submit" id="submit" value="Add Your Email"/>
                    </form>
              </fieldset>
        </section>
    </body>
</html>
