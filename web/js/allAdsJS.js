var stars = ["star1","star2","star3","star4","star5"];

function saveUserRate(AdID,rateValue,rateStatus){
    $.post("/IA_Project/AdvertisementController",{action:'rateAd',rateStatus:rateStatus,AdID:AdID,rateValue:rateValue});
    fillStars(rateValue,AdID);
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
