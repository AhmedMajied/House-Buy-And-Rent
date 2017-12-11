<%-- 
    Document   : search
    Created on : Dec 10, 2017, 11:07:48 AM
    Author     : MariamAshraf
--%>

<%@page import="Models.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/headerStyle.css"/>
        <link rel="stylesheet" href="../css/searchStyle.css"/>
        <title>Search</title>
    </head>
    <body>
      <%
            HttpSession currentSession=request.getSession(true);
            User user=new User();
            if(currentSession.getAttribute("User")!=null)
            {
                user=(User)currentSession.getAttribute("User");
            }
            else
            {
                response.sendRedirect("/");
            }
        %>
       <header>
            <div id="navBar">
                <a id="active" href ="/UserController?action=displayHome">Home</a>
                <a href="#">My Advertisments</a>
                <a href="#">About</a>
                <a href="/AdvertisementController?action=searchPage">Search</a>
                <a href="#"id="notification"></a>
                <a href="/jsp/profile.jsp">MyProfile</a>
                <a href="/UserController?action=logOut">LogOut</a>       
            </div>
        </header>
       <div id="searchForm">
           <form action="/AdvertisementController?action=searchAdvertisements"method="post">
               <div id="title">Search for Advertisements</div>
                <br>
               <span id="name">Buy or Rent</span>
               <select name="buyOrRent"id="field">
                   <option value=""selected></option>
                   <option value="Buy">Buy</option>
                   <option value="Rent">Rent</option>
               </select>
               
               <span id="name">Status</span>
               <select name="status" id="field">
                   <option value="0" selected ></option>
                   <%Vector<BuildingStatus> statuses = (Vector<BuildingStatus>)request.getAttribute("Statuses");
                        for(int i=0;i<statuses.size();i++){%>
                        <option value="<%=statuses.get(i).getID()%>"><%=statuses.get(i).getName()%></option>
                        <%}%>
               </select>
               
               <span id="name">Type</span>
               <select name="type" id="field">
                   <option value="0" selected ></option>
                   <% Vector<BuildingType> types = (Vector<BuildingType>)request.getAttribute("Types");
                        for(int i=0;i<types.size();i++){%>
                        <option value="<%=types.get(i).getID()%>"><%=types.get(i).getName()%></option>
                        <%}%>
               </select>
               <span id="name">Size</span>
               <input type="number" name="size" min="10" value="10" id="size">
               <br><br>
               <input type="submit" value="Search" id="search"/>
           </form>
       </div>
       
    </body>
</html>
