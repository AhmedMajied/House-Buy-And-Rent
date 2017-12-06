var stars = ["star1","star2","star3","star4","star5"];

function saveUserRate(AdID,rateValue,rateStatus){
    
    $.post("AdvertisementController",{action:'rateAd',rateStatus:rateStatus,AdID:AdID,rateValue:rateValue},function(result){
       alert(result); 
    });
    
}

function saveUserComment(AdID,commentText){
    //xmlHttp.open('POST', 'AdvertisementController?action=commentOnAd,AdID='+AdID+'commentText'+commentText, true);
}

function fillStaticStars(clickedStar,id){
    var newID = "0"+id;
    fillStars(clickedStar,newID);
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
