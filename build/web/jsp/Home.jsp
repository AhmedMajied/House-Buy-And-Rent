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
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/homeStyle.css">
        <title>Home</title>
    </head>
    <body>
        <%
            HttpSession currentSession=request.getSession(true);
            User user=new User();
            if(currentSession.getAttribute("User")!=null)
            {
                user=(User)currentSession.getAttribute("User");
                if(user.getUsername().equals("Admin")){
                    %>
                    <script>showAdminAuthority();</script>
                    <%
                }
            }
            else
            {
                response.sendRedirect("/");
            }
        %>
        <%
            Vector<BuildingStatus> statuses = (Vector<BuildingStatus>)request.getAttribute("Statuses");
            Vector<BuildingType> types = (Vector<BuildingType>)request.getAttribute("Types");
        %>
        
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
        
        <%
            Vector<Advertisement> AllAds = (Vector<Advertisement>) request.getAttribute("AllAds");
            int averageRate;
            
            String currentUsername = user.getUsername();
            
            for(int i=0;i<AllAds.size();i++){
                averageRate = 0;
                for(int rateIndex=0;rateIndex<AllAds.get(i).getRatings().size();rateIndex++){
                    averageRate += AllAds.get(i).getRatings().get(rateIndex).getValue();
                }
                averageRate /= AllAds.get(i).getRatings().size();
                %>
                
                <form method="POST" id="<%= AllAds.get(i).getID()%>" action="../AdvertisementController?action=Advertisement&AdID=<%= AllAds.get(i).getID()%>">
                    <label>
                        <b><%= AllAds.get(i).getTitle()%></b> <%= AllAds.get(i).getAdType()%>
                        <b>Advertised By</b> <%= AllAds.get(i).getAdvertiserName() %>
                        
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
                    
                    <div class="AdminAuthority">
                        <button id="<%= "closeOpen"+AllAds.get(i).getID()%>" onclick="closeOpenAd(<%= AllAds.get(i).getID()%>)"><% if(AllAds.get(i).isOpen()){out.print("Close");}else{out.print("Open");} %></button>
                        <button onclick="deleteAd(<%= AllAds.get(i).getID()%>)">Delete</button>
                    </div>

                    <input type="submit" value="see full details"/>
                    
                    <br><hr>
                </form>
                <%
            }
        %>
        
        <!-- add interest button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" 
                data-target="#InterestModal">Add Interest</button>
        
        <!-- show notifications button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" 
                data-target="#NotificationsModal" onclick="markNotificationsAsRead()">Notifications</button>

        <!-- Interest Modal -->
        <div id="InterestModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center><h4 class="modal-title">Add Interest</h4></center>
              </div>
                <form action="/UserController?action=adInterest" method="POST">
                <div class="modal-body">

                    <center>
                      <label>Size</label><br><br>
                      <input type="number" name="size" min="70" value="70"/><br><br>

                      <label>Status</label><br><br>
                      <select name="status" value="0">
                          <%
                              for(int i=0;i<statuses.size();i++){
                                  %>
                                  <option value=<%= i%>><%= statuses.get(i).getName()%></option>
                                  <%
                              }
                          %>
                      </select><br><br>

                      <label>Type</label><br><br>
                      <select name="type" value="0">
                          <% 
                              for(int i=0;i<types.size();i++){
                                  %>
                                  <option value=<%= i%>><%= types.get(i).getName()%></option>
                                  <%
                              }
                          %>
                      </select>
                  </center>

                </div>
                <div class="modal-footer">
                    <center>
                        <input type="submit" class="btn btn-default" value="Save">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                        Vector<Notification> notifications = ((User) request.getAttribute("User")).getNotifications();
                        for(int i=0;i<notifications.size();i++){
                            %>
                            <a href="<%= notifications.get(i).getLink()%>" class="notifications">
                                <b><%= notifications.get(i).getText()%></b>
                                 <%= notifications.get(i).getTime()%>
                            </a>
                            <%
                        }
                    %>
                </div>
            </div>

          </div>
        </div>
                
    </body>
</html>
