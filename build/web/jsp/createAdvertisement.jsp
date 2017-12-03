<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Models.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create Advertisement</title>
                <link rel="stylesheet" href="../css/createAdvertisement.css"/>
                <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw"></script>
                <script src="../js/jquery.min.js"></script>
                <script src="../js/Map.js"></script>
	</head>
<body>
	<form action="AdvertisementController?action=addAdvertisement" method="POST">
		<label>Title</label>
		<input type="text" name="Title" />
                <br/>
                <label>Advertisement Type</label>
                <select name="AdType">
                    <option value="Rent" >Rent</option>
                    <option value="Sale" >Sale</option>
                </select>
                <br/>
		<label>Size</label>
		<input type="number" name="Size" />
                 <br/>

		<label>Floor</label>
		<input type="number" name="Floor" />
		<br/>
		<label>Building Status</label>
		<select name="Status">
			<%
				Vector<BuildingStatus> statuses = (Vector)request.getAttribute("Statuses");
				for(BuildingStatus status : statuses){
			%>
			<option value="<%=status.getID()%>"><%=status.getName() %></option>
			
			<%	}
			%>
		
		</select>
		<br/>
		
		<label>Building Type</label>
		<select name="Type">
			<%
				Vector<BuildingType> types = (Vector)request.getAttribute("Types");
				for(BuildingType type : types){
			%>
			<option value="<%=type.getID()%>"><%=type.getName() %></option>
			
			<%	}
			%>
		
		</select>
		<br/>
		<label>Description</label>
                <br/>
		<textarea name="Description"></textarea>
                <br/>
                <label>Location</label>
                <br/>
                <div class="adMap">
                    <div class="map" style="width:500px;height:200px;">
                    </div>
                <input type="hidden" name="Latitude"   class="locationLat"/>
		<input type="hidden" name="Longitude"  class="locationLng"/>

                </div>
		<br/>
                <input type="submit" value="Add"/>
	</form>
                        
</body>
</html>