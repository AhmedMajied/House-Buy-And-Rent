<%@page import="Models.*"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/allAdsStyle.css">
        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../js/allAdsJS.js"></script>
        <title>All Ads</title>
    </head>
    <body>
        
        <%
            Vector<Advertisement> AllAds = (Vector<Advertisement>) request.getAttribute("AllAds");
            int averageRate;
            int userRate = 0;
            String rateStatus = "new";
            
            //int currentuserID = ((User)session.getAttribute("User")).getID();
            
            for(int i=0;i<AllAds.size();i++){
                averageRate = 0;
                for(int rateIndex=0;rateIndex<AllAds.get(i).getRatings().size();rateIndex++){
                    averageRate += AllAds.get(i).getRatings().get(rateIndex).getValue();
                    /*if(currentUserID == AllAds.get(i).getRatings().get(rateIndex).getUserID()){
                        userRate = AllAds.get(i).getRatings().get(rateIndex).getValue();
                        rateStatus = "existing";
                    }*/
                }
                averageRate /= AllAds.get(i).getRatings().size();
                %>
                <label>
                    <b><%= AllAds.get(i).getTitle()%></b> <%= AllAds.get(i).getAdType()%>
                    <b>Advertised By</b> userName 
                    <!-- Users Ratings-->
                    <span class="heading"> Users Ratings : </span>
                    <span class="fa fa-star" id="<%= "star1"+"0"+AllAds.get(i).getID()%>"></span>
                    <span class="fa fa-star" id="<%= "star2"+"0"+AllAds.get(i).getID()%>"></span>
                    <span class="fa fa-star" id="<%= "star3"+"0"+AllAds.get(i).getID()%>"></span>
                    <span class="fa fa-star" id="<%= "star4"+"0"+AllAds.get(i).getID()%>"></span>
                    <span class="fa fa-star" id="<%= "star5"+"0"+AllAds.get(i).getID()%>"></span>
                    <script>fillStaticStars(<%= averageRate%>,<%= AllAds.get(i).getID()%>);</script>
                </label><br>
                <p><%= AllAds.get(i).getDescription() %></p>
                <b>Size :</b> <%= AllAds.get(i).getBuildingSize()%><br>
                <b>Status :</b> <%= AllAds.get(i).getStatus().getName()%><br>
                <b>Type :</b> <%= AllAds.get(i).getType().getName()%><br>
                <button>Comments</button>
                <Button>View Photos</Button>
                
                <!-- User Rating -->
                <div>
                    <span class="heading"> Your Rating : </span>
                    <span class="fa fa-star" id="<%= "star1"+AllAds.get(i).getID()%>" onclick="fillStars(1,<%= AllAds.get(i).getID()%>)" onmouseover="shadeStars(1,<%= AllAds.get(i).getID()%>)" onmouseout="unShadeStars(1,<%= AllAds.get(i).getID()%>)"></span>
                    <span class="fa fa-star" id="<%= "star2"+AllAds.get(i).getID()%>" onclick="fillStars(2,<%= AllAds.get(i).getID()%>)" onmouseover="shadeStars(2,<%= AllAds.get(i).getID()%>)" onmouseout="unShadeStars(2,<%= AllAds.get(i).getID()%>)"></span>
                    <span class="fa fa-star" id="<%= "star3"+AllAds.get(i).getID()%>" onclick="fillStars(3,<%= AllAds.get(i).getID()%>)" onmouseover="shadeStars(3,<%= AllAds.get(i).getID()%>)" onmouseout="unShadeStars(3,<%= AllAds.get(i).getID()%>)"></span>
                    <span class="fa fa-star" id="<%= "star4"+AllAds.get(i).getID()%>" onclick="fillStars(4,<%= AllAds.get(i).getID()%>)" onmouseover="shadeStars(4,<%= AllAds.get(i).getID()%>)" onmouseout="unShadeStars(4,<%= AllAds.get(i).getID()%>)"></span>
                    <span class="fa fa-star" id="<%= "star5"+AllAds.get(i).getID()%>" onclick="fillStars(5,<%= AllAds.get(i).getID()%>)" onmouseover="shadeStars(5,<%= AllAds.get(i).getID()%>)" onmouseout="unShadeStars(5,<%= AllAds.get(i).getID()%>)"></span>
                </div>
                <hr>
                <%
            }
        %>                
        <script>saveUserRate(1,1,"new");</script>
    </body>
    
</html>
