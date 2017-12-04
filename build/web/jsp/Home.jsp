<%@page import="Models.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controllers.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../css/headerStyle.css">
        <link rel="stylesheet" href="../css/homeStyle.css">
        <title>Home</title>
    </head>
    <body>
        <%
            Vector<BuildingStatus> statuses = (Vector<BuildingStatus>)request.getAttribute("Statuses");
            Vector<BuildingType> types = (Vector<BuildingType>)request.getAttribute("Types");
        %>
        <%
            HttpSession HSession=(HttpSession)application.getAttribute("Session");
            User user=new User();
            user=(User)HSession.getAttribute("User");
        %>
       <header>
            <div id="navBar">
                <a id="active" href ="Home.jsp">Home</a>
                <a href="#">My Advertisments</a>
                <a href="#">About</a>
                <span id="search"></span>
                <input type="text"name="search"id="searchText" placeholder="search field"/>
                <a href="#"id="notification"></a>
                <a href="#"><%=user.getUsername()%></a>
                <a href="profile.jsp">MyProfile</a>
                <a href="../index.html">LogOut</a>
                
            </div>
        </header>
        
        <!-- add interest button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" 
                data-target="#InterestModal">Add Interest</button>

        <!-- Interest Modal -->
        <div id="InterestModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center><h4 class="modal-title">Add Interest</h4></center>
              </div>
                <form action="../UserController?action=adInterest" method="POST">
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
        
        
        
        
    </body>
</html>
