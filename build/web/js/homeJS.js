var stars = ["star1","star2","star3","star4","star5"];

$("document").ready(function(){
   $(".AdminAuthority").hide(); 
});

function closeOpenAd(AdID){
    var action;
    if($("#closeOpen"+AdID).text() === "Close")
       action = "closeAd";
    else
        action = "openAd";
    
    $.post("/IA_Project/AdvertisementController",{action:action,AdID:AdID},function(result){
        if(result === "true"){
            if(action === "closeAd")
                $("#closeOpen"+AdID).text("Open");
            else
                $("#closeOpen"+AdID).text("Close");
        }
    });
}

function deleteAd(AdID){
    $.post("/IA_Project/AdvertisementController",{action:'deleteAdvertisement',adID:AdID},function(result){
        if(result === "true"){
            $("#"+AdID).hide();
        }
    });
}

function showAdminAuthority(){
    $(".AdminAuthority").show();
}

function markNotificationsAsRead(){
    $.post("/IA_Project/UserController",{action:'markNotificationsAsRead'});
}

function fillStaticStars(clickedStar,id){
    var newID = "0"+id;
    var starIndex = 0;
    
    for(starIndex;starIndex<clickedStar;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.add('checked');
    }
    for(starIndex;starIndex<stars.length;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.remove('checked');
    }
}