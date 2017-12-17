var stars = ["star1","star2","star3","star4","star5"];


function addInterest(){
    var size1 = $("#size").val();
    var status1 = $("#status").val();
    var type1 = $("#type").val();
    
    $.post("/UserController",{action:'addInterest',size:size1,status:status1,type:type1},function(result){
        if(result === "true"){
            $('#InterestModal').modal('hide');
        }
    });
}

function closeOpenAd(AdID){
    var action;
    // that means that Ad is currently open
    if($("#closeOpen"+AdID).val() === "true")
       action = "closeAd";
    else
        action = "openAd";
    
    $.post("/AdvertisementController",{action:action,AdID:AdID},function(result){
        if(result === "true"){
            if(action === "closeAd"){
                $("#closeOpen"+AdID).text("Open");
                $("#closeOpen"+AdID).val("false");
            }
            else{
                $("#closeOpen"+AdID).text("Close");
                $("#closeOpen"+AdID).val("true");
            }
        }
    });
    
}

function deleteAd(AdID){
    $.post("/AdvertisementController",{action:'deleteByAdmin',adID:AdID},function(result){
        if(result === "true"){
            $("#"+AdID).hide();
        }
    });
}

// start changes
function markNotificationAsRead(notificationID){
    $.post("/UserController",{action:'markNotificationsAsRead',notificationID:notificationID});
}

function fillStaticStars(rate,id){
    var newID = "0"+id;
    var starIndex = 0;
    
    for(starIndex;starIndex<rate;starIndex++){
        document.getElementById(stars[starIndex]+newID).classList.add('checked');
    }
    for(starIndex;starIndex<stars.length;starIndex++){
        document.getElementById(stars[starIndex]+newID).classList.remove('checked');
    }
}