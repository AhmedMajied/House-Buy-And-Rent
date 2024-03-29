<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Models.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Create Advertisement</title>
        <link rel="stylesheet" href="css/headerStyle.css"/>
        <link rel="stylesheet" href="css/createAdvertisement.css"/>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/Map.js"></script>
    </head>
    <body>
        <%
            HttpSession currentSession = request.getSession(true);
            User user = new User();
            if (currentSession.getAttribute("User") != null) {
                user = (User) (currentSession.getAttribute("User"));
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
    <div id="addForm">
        <form action="/AdvertisementController?action=addAdvertisement" method="POST">
            <div id="Title">Add New Advertisement</div>
            <br>
            <span id="title">Title</span>
            <input type="text" name="Title" id="field"required/>
            <br/>
            <span id="title">Advertisement Type</span>
            <select name="AdType"id="field2">
                <option value="Rent" >Rent</option>
                <option value="Sale" >Sale</option>
            </select>
            <br/>
            <span id="title">Size</span>
            <input type="number" name="Size"id="field"min="0" required/>
            <br/>

            <span id="title">Floor</span>
            <input type="number" name="Floor"id="field" min="0"required/>
            <br/>
            <span id="title">Building Status</span>
            <select name="Status"id="field2">
                <%
                    Vector<BuildingStatus> statuses = (Vector) request.getAttribute("Statuses");
                    for (BuildingStatus status : statuses) {
                %>
                <option value="<%=status.getID()%>"><%=status.getName()%></option>

                <%	}
                %>

            </select>
            <br/>

            <span id="title">Building Type</span>
            <select name="Type"id="field2">
                <%
                    Vector<BuildingType> types = (Vector) request.getAttribute("Types");
                    for (BuildingType type : types) {
                %>
                <option value="<%=type.getID()%>"><%=type.getName()%></option>

                <%	}
                %>

            </select>
            <br/>
            <span id="title">Description</span>
            <textarea name="Description"id="field1" required></textarea>
            <br/>
            <span id="title1">Location</span>
            <br/>
            <div class="adMap">
                <div class="map">
                </div>
                <input type="hidden" name="Latitude"   class="locationLat"/>
                <input type="hidden" name="Longitude"  class="locationLng"/>

            </div>
            <br/>
            <input type="submit" id="add" value="Add"/>
        </form>
    </div>
</body>
</html>