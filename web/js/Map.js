/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var map,marker;
$(document).ready(function(){
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } 
    initMap('.adMap');
});
function showPosition(position) {
    $('.locationLat').val( position.coords.latitude) ;
    $('.locationLng').val( position.coords.longitude ) ;
}
function initMap(id) {

    var locationLat = $(id).find('.locationLat').val();
    var locationLng = $(id).find('.locationLng').val();
    var uluru = { lat: parseFloat(locationLat), lng: parseFloat(locationLng) };

    var mapContainer = $(id).find('.map')[0];
     map = new google.maps.Map(mapContainer, {
        center: uluru,
        zoom: 17
    });
    marker = new google.maps.Marker({
        position: uluru,
        map: map
    });
    
    google.maps.event.addListener(map, 'click', function( event ){
        uluru = { lat:event.latLng.lat() , lng: event.latLng.lng() }
        marker.setMap(null);
        marker=new google.maps.Marker({
            position: uluru,
            map: map
        });
        var infowindow = new google.maps.InfoWindow({
            content: "<div style=\"width:100px;text-align:left;font-size:15px;font-weight:bold\">Property Location</div>"
        });
        infowindow.open(map,marker);
        $(id).find('.locationLat').val(event.latLng.lat());
        $(id).find('.locationLng').val(event.latLng.lng());
    });
}