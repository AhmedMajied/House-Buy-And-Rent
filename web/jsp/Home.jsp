<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Models.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controllers.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/homeJS.js"></script>
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/homeStyle.css">
        <title>Home</title>
    </head>
    <body>
        <%
            HttpSession currentSession = request.getSession(true);
            User user = new User();
            if (currentSession.getAttribute("User") != null) {
                user = (User) currentSession.getAttribute("User");

            } 
            else 
            {
                response.sendRedirect("/");
            }

            Vector<BuildingStatus> statuses = (Vector<BuildingStatus>) request.getAttribute("Statuses");
            Vector<BuildingType> types = (Vector<BuildingType>) request.getAttribute("Types");
            Vector<Notification> notifications = user.getNotifications();
            Vector<Advertisement> AllAds = (Vector<Advertisement>) request.getAttribute("AllAds");
            int averageRate;
        %>

        <header>
            <div id="navBar">
                <a id="active" href ="/UserController?action=displayHome">Home</a>
                <a href="/AdvertisementController?action=createAdvertisementPage">Create Advertisemenet</a> 
                <a href="#"data-toggle="modal" data-target="#InterestModal">Add Interest</a>
                <a href="/AdvertisementController?action=searchPage">Search</a>
                <a href="#"id="notification" data-toggle="modal" data-target="#NotificationsModal"></a>
                <a href="/jsp/profile.jsp">MyProfile</a>
                <a href="/UserController?action=logOut">LogOut</a>
                <%if (user.isAdmin()) {%>
                <a href="#"data-toggle="modal" data-target="#changePasswordModal">Change User Password</a>
                <%}%>
            </div>
        </header>
            
        
        <!-- All Ads-->
        <%
            for(int i=0;i<AllAds.size();i++){
                averageRate = 0;
                if(!AllAds.get(i).isOpen() && !(user.isAdmin() || user.getUsername().equals(AllAds.get(i).getAdvertiserName()))){
                    continue;
                }
                if(AllAds.get(i).getRatings().size() > 0){
                    for(int rateIndex=0;rateIndex<AllAds.get(i).getRatings().size();rateIndex++){
                        averageRate += AllAds.get(i).getRatings().get(rateIndex).getValue();
                    }
                    averageRate /= AllAds.get(i).getRatings().size();
                }
                %>
                <center>
                <form method="POST" id="<%= AllAds.get(i).getID()%>" action="../AdvertisementController?action=Advertisement&AdID=<%= AllAds.get(i).getID()%>">
                    <label>
                        <span><%= AllAds.get(i).getTitle()%></span> (<%= AllAds.get(i).getAdType()%>)
                        Advertised By <span><%= AllAds.get(i).getAdvertiserName() %></span>
                        
                        <!-- Users Ratings-->
                        <span class="fa fa-star" id="<%= "star1"+"0"+AllAds.get(i).getID()%>"></span>
                        <span class="fa fa-star" id="<%= "star2"+"0"+AllAds.get(i).getID()%>"></span>
                        <span class="fa fa-star" id="<%= "star3"+"0"+AllAds.get(i).getID()%>"></span>
                        <span class="fa fa-star" id="<%= "star4"+"0"+AllAds.get(i).getID()%>"></span>
                        <span class="fa fa-star" id="<%= "star5"+"0"+AllAds.get(i).getID()%>"></span>
                        <script>fillStaticStars(<%= averageRate%>,<%= AllAds.get(i).getID()%>);</script>
                    </label><br>

                    <b>Size :</b> <%= AllAds.get(i).getBuildingSize()%><br>
                    <b>Status :</b> <%= AllAds.get(i).getStatus().getName()%><br>
                    <b>Type :</b> <%= AllAds.get(i).getType().getName()%><br>
                    
                    <%
                        if(user.isAdmin()){
                            %>
                                <div class="AdminAuthority">
                                    <button class="btn btn-default" value="<%= AllAds.get(i).isOpen()%>" id="<%= "closeOpen"+AllAds.get(i).getID()%>"
                                            onclick="closeOpenAd(<%= AllAds.get(i).getID()%>); return false;">
                                        <%if(AllAds.get(i).isOpen()){out.print("Close");}else{out.print("Open");} %>
                                    </button>
                                    <button class="btn btn-default" onclick="deleteAd(<%= AllAds.get(i).getID()%>); return false;">Delete</button>
                                </div>
                            <%
                        }
                    %>          
                    <input class="btn btn-default" type="submit" value="More Details"/>
                    <br><hr>
                </form>
                </center>
                <%
            }
        %>

    <!-- Interest Modal -->
    <div id="InterestModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <center><h4 class="modal-title">Add Interest</h4></center>
                </div>
                <form>
                    <div class="modal-body">

                        <center>
                            <label>Size</label><br><br>
                            <input type="number" id="size" min="70" value="70"/><br><br>

                            <label>Status</label><br><br>
                            <select id="status" value="1">
                                <%
                                    for (int i = 0; i < statuses.size(); i++) {
                                %>
                                <option value=<%= i + 1%>><%= statuses.get(i).getName()%></option>
                                <%
                                    }
                                %>
                            </select><br><br>

                            <label>Type</label><br><br>
                            <select id="type" value="1">
                                <%
                                    for (int i = 0; i < types.size(); i++) {
                                %>
                                <option value=<%= i + 1%>><%= types.get(i).getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </center>

                    </div>
                    <div class="modal-footer">
                        <center>
                            <button type="button" class="btn btn-default" onclick="addInterest()">Save</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </center>
                    </div>
                </form>
            </div>

        </div>
    </div>


    <!-- Notifications Modal -->
    <div id="NotificationsModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <center><h4 class="modal-title">Notifications</h4></center>
                </div>
                <div class="modal-body">
                    <%
                        for (int i = 0; i < notifications.size(); i++) {
                    %>
                            <a href="<%= notifications.get(i).getLink()%>" class="notifications" 
                               onclick="markNotificationAsRead(<%= notifications.get(i).getID()%>)">
                                <b><%= notifications.get(i).getText()%></b>
                                 <% 
                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    out.print(dateFormat.format(notifications.get(i).getTime()));
                                 %>
                            </a><br>
                            
                            <button onclick="markNotificationAsRead(<%= notifications.get(i).getID()%>)" ></button>      
                    <%
                        }
                    %>

                </div>
            </div>

        </div>
    </div>

    <div class="modal fade" id="changePasswordModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/UserController?action=changeUserPassword"method="post">
                    <div class="modal-header">
                        <h5>Change User Password</h5>
                    </div>
                    <div class="modal-body changePassword">
                        <span id="label">User Name</span>
                        <input type="text"name="userName" required id="userData"/>
                        <br><br>
                        <span id="label">New Password</span>
                        <input type="password"name="newPassword" required id="userData"/>
                    </div>
                    <div class="modal-footer">
                        <center>
                        <input type="submit" value="Change Password" class="btn btn-default"/>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </center>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
