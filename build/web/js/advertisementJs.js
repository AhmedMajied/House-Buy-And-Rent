var stars = ["star1","star2","star3","star4","star5"];

$(document).ready(function() {
    var btn = $('#displayInfo');
    btn.click(function(e){
        var advertiserID=$("#hiddenId").val();
        $.ajax({
            type: "POST",
            url: "/UserController?action=requestContact",
            data:"advertiserID="+advertiserID,
            success: function(data){
               btn.hide();
               $("#result").css("display","block");
               $("#result").html(data);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $("#result").html("an error happens please try again");
            }
        });
    });
});

function saveNewComment(AdID,AdvertiserName,userName){
    var commentText = $("#newComment").val();
    $.post("/IA_Project/AdvertisementController",{action:'commentOnAd',AdID:AdID,AdvertiserName:AdvertiserName,commentText:commentText},function(result){
        if(result === "true"){
            $("#newComment").val("").before("<label><<b>"+userName+"</b> "+commentText+"</label><br>");
        }
    });
}

function saveUserRate(AdID,rateValue,rateStatus){
    
    $.post("AdvertisementController",{action:'rateAd',rateStatus:rateStatus,AdID:AdID,rateValue:rateValue},function(result){
       alert(result); 
    });
    
}

function fillStars(clickedStar,id){
    var starIndex = 0;
    
    for(starIndex;starIndex<clickedStar;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.add('checked');
    }
    for(starIndex;starIndex<stars.length;starIndex++){
        document.getElementById(stars[starIndex]+id).classList.remove('checked');
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

