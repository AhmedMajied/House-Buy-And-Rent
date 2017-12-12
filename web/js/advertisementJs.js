/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

