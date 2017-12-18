var stars = ["star1","star2","star3","star4","star5"];

$(document).ready(function() {
    var btn = $('#displayInfo');
    btn.click(function(e){
        var advertiserName=$("#hiddenName").val();
        $.ajax({
            type: "POST",
            url: "/UserController?action=requestContact",
            data:"advertiserName="+advertiserName,
            success: function(data){
                btn.hide();
                $("#result").css("display","block");
                if(data==="null"){
                    $("#result").html("No Phone");
                }
                else
                {
                    $("#result").html(data);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $("#result").html("an error happens please try again");
            }
        });
    });
});


// start changes

function saveNewComment(AdID,AdvertiserName,userName){
    var commentText = $("#newComment").val();
    
    $.post("/AdvertisementController",{action:'commentOnAd',AdID:AdID,AdvertiserName:AdvertiserName,commentText:commentText},function(result){
        if(result === "true"){
            $("#newComment").val("").before("<label><b>"+userName+"</b> "+commentText+"</label><br>");
        }
    });
}

function saveUserRate(rateValue,AdID,rateStatus){    
    $.post("/AdvertisementController",{action:'rateAd',rateStatus:rateStatus,AdID:AdID,rateValue:rateValue},function(result){
        if(result === "true"){    
            fillStars(rateValue,AdID);
            rateStatus = "existing";
        } 
    });
}

function fillStars(rateValue,AdID){
    var starIndex = 0;
    
    for(starIndex;starIndex<rateValue;starIndex++){
        document.getElementById(stars[starIndex]+AdID).classList.add('checked');
    }
    for(starIndex;starIndex<stars.length;starIndex++){
        document.getElementById(stars[starIndex]+AdID).classList.remove('checked');
    }
}

function shadeStars(star,id){
    var starIndex = 0;
    
    for(starIndex;starIndex<star;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.add('shaded');
    }
}

function unShadeStars(star,id){
    var starIndex = 0;
    
    for(starIndex;starIndex<star;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.remove('shaded');
    }
}
