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
    </head>
    <body>
        <iframe id="map" src="https://www.google.com/maps/embed/v1/place?origin=<%=ad.getLatitude() %>, <%=ad.getLongitude() %>&key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw"></iframe>
        <br/>
        <%=ad.getTitle()%>
        <br/>
        <%=ad.getAdType()%>
        <br/>
        <%=ad.getDescription()%>
        <br/>
        Size: <%=ad.getBuildingSize()%>
        <br/>
        Floor: <%=ad.getBuildingFloor()%>
        <br/>
        Type: <%=ad.getType().getName()%>
        <br/>
        Status: <%=ad.getStatus().getName()%>
        <br/>
        <% 
          for(Blob image : ad.getPhotos()){
            byte[] imgData = image.getBytes(1, (int)image.length());
            String code = Base64.getEncoder().encodeToString(imgData); 
        %>
            <img src="data:image/jpg;base64,<%=code%>" style="width:50px;height:50px"/>
        <%}%>
        
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
                            <label><b><%= ad.getComments().get(commentIndex).getUserID() %></b>
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
