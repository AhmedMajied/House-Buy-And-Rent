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
    <% Advertisement ad = (Advertisement) request.getAttribute("Advertisement");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=ad.getTitle()%></title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="css/headerStyle.css">
        <link rel="stylesheet" href="css/advertisementStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/advertisementJs.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            HttpSession currentSession = request.getSession(true);
            User user = new User();
            if (currentSession.getAttribute("User") == null) {
                response.sendRedirect("/");
            } else {
                user = (User) (currentSession.getAttribute("User"));
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
        <br>
        <div id="title"><%=ad.getTitle()%></div>
        <br/>
        <div id="div">
            <!-- add Comment button -->
            <div id="btn">
                <button type="button" class="button" data-toggle="modal" data-target="#CommentsModal">Comments</button>
            </div>

            <%
                String rateStatus = "new";
                int userRate = 0;
                for (int i = 0; i < ad.getRatings().size(); i++) {
                    if (ad.getRatings().get(i).getUsername().equals(user.getUsername())) {
                        rateStatus = "existing";
                        userRate = ad.getRatings().get(i).getValue();
                        break;
                    }
                }
            %>
            <!-- User Rating -->
            <%if (!(user.getUsername().equals(ad.getAdvertiserName()))) {%>
            <div id="btn" class="rate">
                <span class="heading"> Your Rating : </span>
                <span class="fa fa-star" id="<%= "star1" + ad.getID()%>" onclick="saveUserRate(1,<%= ad.getID()%>, '<%= rateStatus%>')" onmouseover="shadeStars(1,<%= ad.getID()%>)" onmouseout="unShadeStars(1,<%= ad.getID()%>)"></span>
                <span class="fa fa-star" id="<%= "star2" + ad.getID()%>" onclick="saveUserRate(2,<%= ad.getID()%>, '<%= rateStatus%>')" onmouseover="shadeStars(2,<%= ad.getID()%>)" onmouseout="unShadeStars(2,<%= ad.getID()%>)"></span>
                <span class="fa fa-star" id="<%= "star3" + ad.getID()%>" onclick="saveUserRate(3,<%= ad.getID()%>, '<%= rateStatus%>')" onmouseover="shadeStars(3,<%= ad.getID()%>)" onmouseout="unShadeStars(3,<%= ad.getID()%>)"></span>
                <span class="fa fa-star" id="<%= "star4" + ad.getID()%>" onclick="saveUserRate(4,<%= ad.getID()%>, '<%= rateStatus%>')" onmouseover="shadeStars(4,<%= ad.getID()%>)" onmouseout="unShadeStars(4,<%= ad.getID()%>)"></span>
                <span class="fa fa-star" id="<%= "star5" + ad.getID()%>" onclick="saveUserRate(5,<%= ad.getID()%>, '<%= rateStatus%>')" onmouseover="shadeStars(5,<%= ad.getID()%>)" onmouseout="unShadeStars(5,<%= ad.getID()%>)"></span>
            </div>

            <script>fillStars(<%= userRate%>,<%= ad.getID()%>);</script>
            <%}%>

            <%if (user.getUsername().equals(ad.getAdvertiserName())) {%>
            <div id="btn">
                <form action="/AdvertisementController?action=updateAdvertisementPage&adID=<%=ad.getID()%>" method="post">
                    <input type="submit" class="button" value="Update"/>
                </form>
            </div>
            <%}%>
            <%if (user.getUsername().equals(ad.getAdvertiserName())) {%>
            <div id="btn">
                <form action="/AdvertisementController?action=deleteAdvertisement&adID=<%=ad.getID()%>" method="post">
                    <input type="submit" class="button" value="Delete"/>
                </form>
            </div>
            <%}%>
            <%if (!(user.getUsername().equals(ad.getAdvertiserName()))) {%>
            <input type="hidden"id="hiddenName" value="<%=ad.getAdvertiserName()%>">
            <input type="button" id="displayInfo"value="Request User Info"/>
            <div id="result"></div>
            <%}%>
        </div>
        <br><br>
        <iframe id="map" src="https://www.google.com/maps/embed/v1/place?q=<%=ad.getLatitude()%>, <%=ad.getLongitude()%>&key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw"></iframe>
        <div id="adInfo">
            <div id="type"><%=ad.getAdType()%></div>
            <br/><br/>
            <div id="type"><%=ad.getDescription()%></div>
            <br/><br/>
            <div id="type">Size: <%=ad.getBuildingSize()%></div>
            <br/><br/>
            <div id="type">Floor: <%=ad.getBuildingFloor()%></div>
            <br/><br/>
            <div id="type">Type: <%=ad.getType().getName()%></div>
            <br/><br/>
            <div id="type">Status: <%=ad.getStatus().getName()%></div>
            <br/>
        </div>
        <br/>
        <fieldset id="Photo"> 
            <legend>Photos</legend>
            <%if(ad.getPhotos().size()==0){%>
            <center>
                <label>There are no available photos</label>
            </center>
            <%}%>
            <%  for (Blob image : ad.getPhotos()) {
                    byte[] imgData = image.getBytes(1, (int) image.length());
                    String code = Base64.getEncoder().encodeToString(imgData);
            %>
            <img src="data:image/jpg;base64,<%=code%>" id="photos"/>
            <%}
                Object obj = request.getSession(true).getAttribute("User");
                if (obj != null && ((User) obj).getUsername().equals(ad.getAdvertiserName())) {
            %>
            <br>

            <button id="addPhoto" onclick="displayButtons();">Add New Photo</button>
            <fieldset id="NewPhotos">
                <legend>Add Photo</legend>
                <form action="AdvertisementController?action=addPhoto&adID=<%=ad.getID()%>" method="post" enctype="multipart/form-data">
                    <input name="file" type="file" id="photo"/>
                    <br><br>
                    <input type="submit" id="add" value="Add Photo"/>
                    <br/>
                </form>
            </fieldset>
                    <br><br>
        </fieldset>
        <%}%>

                <br/>
                <br/>





        <!-- Comments Modal -->
        <div id="CommentsModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-body">

                        <%
                            for (int commentIndex = 0; commentIndex < ad.getComments().size(); commentIndex++) {
                        %>
                        <label><span><%= ad.getComments().get(commentIndex).getUsername()%></span>
                            <%= ad.getComments().get(commentIndex).getText()%>
                        </label><br>
                        <%
                            }
                        %>
                        <input type="text" id="newComment"placeholder="write your comment here"/>
                        <br><br>

                    </div>
                    <div class="modal-footer">
                        <center>
                            <button class="btn btn-default" onclick="saveNewComment('<%= ad.getID()%>', '<%= ad.getAdvertiserName()%>', '<%= ((User) session.getAttribute("User")).getUsername()%>')">Add Comment</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </center>
                    </div>
                </div>

            </div>
        </div>


    </body>
</html>
