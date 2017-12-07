function saveNewComment(AdID,AdvertiserName,userName){
    var commentText = $("#newComment").val();
    $.post("/IA_Project/AdvertisementController",{action:'commentOnAd',AdID:AdID,AdvertiserName:AdvertiserName,commentText:commentText},function(result){
        if(result === "true"){
            $("#newComment").val("").before("<label><<b>"+userName+"</b> "+commentText+"</label><br>");
        }
    });
}