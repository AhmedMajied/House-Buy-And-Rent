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