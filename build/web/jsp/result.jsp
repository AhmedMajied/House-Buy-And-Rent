<%-- 
    Document   : result
    Created on : Dec 10, 2017, 9:23:03 PM
    Author     : MariamAshraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.*"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/headerStyle.css"/>
        <link rel="stylesheet" href="../css/resultStyle.css"/>
        <title>Search Results</title>
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
                <a href="/AdvertisementController?action=createAdvertisementPage">Create Advertisemenet</a>
                <a href="/AdvertisementController?action=searchPage">Search</a>
                <a href="/jsp/profile.jsp">MyProfile</a>
                <a href="/UserController?action=logOut">LogOut</a>       
            </div>
        </header>
       
        <% Vector<Advertisement> ads=(Vector<Advertisement>)(request.getAttribute("searchResult"));
        if(ads.size()==0)
        {%>
        <div id="noResult">Sorry ! there are no Results </div>
        <%}else
            for(int i=0 ;i <ads.size();i++){
        %>
        <br><br>
        <fieldset>
            <legend>
                <a id="title" href="/AdvertisementController?action=Advertisement&AdID=<%=ads.get(i).getID()%>"><%=ads.get(i).getTitle()%></a>
            </legend>

            <div id="res">AdvertisementType : <%=ads.get(i).getAdType()%></div>
            <div id="res">BuildingSize : <%=ads.get(i).getBuildingSize()%></div>
            <div id="res">BuildingFloor : <%=ads.get(i).getBuildingFloor()%></div>
        </fieldset>
        <%}%>
    </body>
</html>
