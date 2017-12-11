
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/advertisementJs.js"></script>
    </head>
    <body>        
        <%
            int userRate = 0;
            String rateStatus = "new";
            //int currentUsername = ((User)session.getAttribute("User")).getUsername();
            
            for(int rateIndex=0;rateIndex<ad.getRatings().size();rateIndex++){
                /*if(currentUsername == AllAds.get(i).getRatings().get(rateIndex).getUsername()){
                    userRate = AllAds.get(i).getRatings().get(rateIndex).getValue();
                    rateStatus = "existing";
                }*/
            }
        %>
            <div id="navBar">
                <a id="active" href ="/UserController?action=displayHome">Home</a>
                <a href="#">My Advertisments</a>
                <a href="#">About</a>
                <a href="/AdvertisementController?action=searchPage">Search</a>
                <a href="#"id="notification"></a>
                <a href="jsp/profile.jsp">MyProfile</a>
                <a href="/UserController?action=logOut">LogOut</a>
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
        <!-- User Rating -->
        <div>
            <span class="heading"> Your Rating : </span>
            <span class="fa fa-star" id="<%= "star1"+ad.getID()%>" onclick="fillStars(1,<%= ad.getID()%>)" onmouseover="shadeStars(1,<%= ad.getID()%>)" onmouseout="unShadeStars(1,<%= ad.getID()%>)"></span>
            <span class="fa fa-star" id="<%= "star2"+ad.getID()%>" onclick="fillStars(2,<%= ad.getID()%>)" onmouseover="shadeStars(2,<%= ad.getID()%>)" onmouseout="unShadeStars(2,<%= ad.getID()%>)"></span>
            <span class="fa fa-star" id="<%= "star3"+ad.getID()%>" onclick="fillStars(3,<%= ad.getID()%>)" onmouseover="shadeStars(3,<%= ad.getID()%>)" onmouseout="unShadeStars(3,<%= ad.getID()%>)"></span>
            <span class="fa fa-star" id="<%= "star4"+ad.getID()%>" onclick="fillStars(4,<%= ad.getID()%>)" onmouseover="shadeStars(4,<%= ad.getID()%>)" onmouseout="unShadeStars(4,<%= ad.getID()%>)"></span>
            <span class="fa fa-star" id="<%= "star5"+ad.getID()%>" onclick="fillStars(5,<%= ad.getID()%>)" onmouseover="shadeStars(5,<%= ad.getID()%>)" onmouseout="unShadeStars(5,<%= ad.getID()%>)"></span>
        </div>
        <hr>
        
        <!-- add Comment button -->
        <button type="button" class="btn" data-toggle="modal" 
                data-target="#CommentsModal">Comments</button>

        <!-- Comments Modal -->
        <div id="CommentsModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <center><h4 class="modal-title">Comments</h4></center>
              </div>
                <div class="modal-body">

                    <%
                        for(int commentIndex=0;commentIndex<ad.getComments().size();commentIndex++){
                            %>
                            <label><b><%= ad.getComments().get(commentIndex).getUsername() %></b>
                                <%= ad.getComments().get(commentIndex).getText() %>
                            </label><br>
                            <%
                        }
                    %>
                    <input type="text" id="newComment" /><br>
                    <button class="btn btn-default" onclick="saveNewComment(<%= ad.getID()%>,<%= ad.getAdvertiserName()%>,<%= ((User)session.getAttribute("User")).getUsername()%>)">Add Comment</button>

                </div>
                <div class="modal-footer">
                    <center>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </center>
                </div>
            </div>

          </div>
        </div>
        
        
    </body>
</html>
