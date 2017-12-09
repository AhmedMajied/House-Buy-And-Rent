
<%-- 
    Document   : advertisement
    Created on : Dec 2, 2017, 7:56:38 PM
    Author     : andre
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Blob"%>
<%@page import="Models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Advertisement ad = (Advertisement)request.getAttribute("Advertisement"); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=ad.getTitle()%></title>
        <link rel="stylesheet" href="css/headerStyle.css">
        <link rel="stylesheet" href="css/advertisementStyle.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/advertisementJs.js"></script>
    </head>
    <body>        
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
        <br>
        <div id="title"><%=ad.getTitle()%></div>
        <br/>
        
        <input type="hidden"id="hiddenId" value="<%=ad.getAdvertiserName()%>">
        <input type="button" id="displayInfo"value="Request User Info"/>
        <div id="result"></div>
        <br>
        
        <iframe id="map" src="https://www.google.com/maps/embed/v1/place?q=<%=ad.getLatitude() %>, <%=ad.getLongitude() %>&key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw"></iframe>
        <br/>
        <div id="type"><%=ad.getAdType()%></div>
        <br/>
        <div id="type"><%=ad.getDescription()%></div>
        <br/>
        <div id="type">Size: <%=ad.getBuildingSize()%></div>
        <br/>
        <div id="type">Floor: <%=ad.getBuildingFloor()%></div>
        <br/>
        <div id="type">Type: <%=ad.getType().getName()%></div>
        <br/>
        <div id="type">Status: <%=ad.getStatus().getName()%></div>
        <br/>

        <fieldset id="Photo"> 
            <legend>Photos</legend>
            <%  for(Blob image : ad.getPhotos()){
               byte[] imgData = image.getBytes(1, (int)image.length());
               String code = Base64.getEncoder().encodeToString(imgData); 
           %>
            <img src="data:image/jpg;base64,<%=code%>" id="photos"/>
        <%}
        Object obj = request.getSession(true).getAttribute("User");
        if(obj!=null && ((User)obj).getUsername().equals(ad.getAdvertiserName())){
        %>
            <br>
            
            <form action="AdvertisementController?action=addPhoto&adID=<%=ad.getID()%>" method="post" enctype="multipart/form-data">
                <input name="file" type="file" id="photo"/>
                <br><br>
                <input type="submit" id="add" value="Add Photo"/>
            </form>
        <%}%>
        </fieldset>
    </body>
</html>
