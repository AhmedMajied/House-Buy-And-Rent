<%-- 
    Document   : advertisement
    Created on : Dec 2, 2017, 7:56:38 PM
    Author     : andre
--%>

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
        <% ArrayList<String>images=(ArrayList)request.getAttribute("Photos");
          for(int i=0;i<images.size();++i){%>
            <img src="data:image/jpg;base64,<%=images.get(i)%>" />
        <%}%>
        
    </body>
</html>
